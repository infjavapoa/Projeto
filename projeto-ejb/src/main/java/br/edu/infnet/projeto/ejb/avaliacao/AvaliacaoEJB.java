package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.infnet.projeto.ejb.core.Email;
import br.edu.infnet.projeto.ejb.core.GerarArqCSV;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.core.Seguranca;
import br.edu.infnet.projeto.ejb.infnet.Aluno;
import br.edu.infnet.projeto.ejb.parametros.Parametros;
import br.edu.infnet.projeto.ejb.questionario.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopico;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopicoQuestao;

@Stateless
public class AvaliacaoEJB {
	
	@EJB
	Repositorio repositorio;
	@EJB
	Email email;

	public void abrirAvaliacoes(){
		
		System.out.println("abrir avaliações");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dataAtual", new Date());
		List<Avaliacao> avaliacoes = repositorio.listarWithNamedQuery(Avaliacao.class, "Avaliacao.pesquisarNaoAbertas", param);
		
		for (Avaliacao avaliacao : avaliacoes) {
			List<Aluno> alunos = avaliacao.getTurma().getAlunos();
			
			//Manda e-mail para cada aluno que pertence à turma avaliada
			for (Aluno aluno : alunos) {				
				email.enviarMsgAbertura(aluno, avaliacao);
			}
			
			//Seta o status da avaliação para "Aberta"
			avaliacao.setSituacao("A");
			repositorio.atualizar(avaliacao);
		}
	}
	
	public AvaliacaoAluno criarAvaliacaoAluno(String id){
		id = Seguranca.decriptar(id);
    	String idAluno = id.split(":")[0];
    	String idAvaliacao = id.split(":")[1];
    	System.out.println("criar avaliacao");
    	AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
    	avaliacaoAluno.setAluno(repositorio.obter(Aluno.class, new Long(idAluno)));
    	avaliacaoAluno.setAvaliacao(repositorio.obter(Avaliacao.class, new Long(idAvaliacao)));
    	
    	for (QuestionarioTopico qt : avaliacaoAluno.getAvaliacao().getQuestionario().getQuestionarioTopicos()) {
    		RespostaTopico rt = new RespostaTopico();
    		rt.setAvaliacaoAluno(avaliacaoAluno);
    		rt.setQuestionarioTopico(qt);
    		
			for (QuestionarioTopicoQuestao qtq : qt.getQuestionarioTopicoQuestoes()) {
				RespostaQuestao rq;
				if (qtq.getQuestao() instanceof QuestaoObjetiva) 
					rq = new RespostaQuestaoObjetiva();
				else 
					rq = new RespostaQuestaoDissertativa();
				rq.setQuestionarioTopicoQuestao(qtq);
				rq.setRespostaTopico(rt);
				
				rt.adicionaRespostaQuestao(rq);
			}
			avaliacaoAluno.adicionaRespostaTopico(rt);
		}
    	
    	return avaliacaoAluno;
	}
	
	public void processarAvaliacoes(){
		
		System.out.println("XXXXXXXXXXXXXX processar avaliações");
		
		Parametros parametros;
		String nomeArq = "I:/SAI/";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("false", false);
		List<AvaliacaoAluno> avaliadas = repositorio.listarWithNamedQuery(AvaliacaoAluno.class, "AvaliacaoAluno.pesquisarNaoProcessadas", param);
		List<String> linhas = new ArrayList<String>();
				
		List<Parametros> parametrosList = repositorio.listar(Parametros.class);
		if (parametrosList != null && parametrosList.size() > 0) {
			parametros = parametrosList.get(0);
			if (parametros != null && !parametros.getDiretorioArquivoAvaliacao().isEmpty()){
				nomeArq = parametros.getDiretorioArquivoAvaliacao() + "/"; 
			}
		}
		
		System.out.println("O que temos???" + avaliadas.size());
		for (AvaliacaoAluno avaliacaoAluno : avaliadas) {
			linhas.add(new String("Código da Avaliação;Turma;Professor;Curso;Bloco;Módulo;Questionário;"));
			System.out.println("Ta de boa..." + avaliadas);
			//avaliacao.setEmailEnviado(false);
			if (!avaliacaoAluno.getEmailEnviado()){
				try {
					System.out.println("manda o email para o viado" + avaliacaoAluno.getAluno().getNome());
					email.enviarMsgConfirmaRecebAval(avaliacaoAluno);
				} catch (Exception ex){
					
				}				
				avaliacaoAluno.setEmailEnviado(true);				
			}
			
			if (!avaliacaoAluno.getArquivoGerado()){
				try {
					nomeArq += avaliacaoAluno.getAvaliacao().getCodigo().replace("/", "_");
					nomeArq = nomeArq.replace("\"", "_");
					nomeArq = nomeArq.replace(".", "_");
					nomeArq = nomeArq.replace(" ", "_");
					nomeArq += "_" + avaliacaoAluno.getAluno().getMatricula().toString();
					nomeArq += ".csv";
					System.out.println("gera o arquivo csv" + nomeArq);
					String linha = new String();
					linha = avaliacaoAluno.getAvaliacao().getCodigo() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getTurma().getNome() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getTurma().getProfessor().getNome() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getTurma().getModulo().getBloco().getCurso().getNome() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getTurma().getModulo().getBloco().getNome() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getTurma().getModulo().getNome() + ";";
					linha = linha + avaliacaoAluno.getAvaliacao().getQuestionario().getNome() + ";";
					linhas.add(linha);
					for (QuestionarioTopico qt : avaliacaoAluno.getAvaliacao().getQuestionario().getQuestionarioTopicos()) {
						linhas.add(new String(qt.getTopico().getTexto()));
						linhas.add(new String("Ordem;Questão;Resposta"));					
						for (QuestionarioTopicoQuestao qtq : qt.getQuestionarioTopicoQuestoes()) {
							for (RespostaQuestao rq : qtq.getRespostas()){
								if (rq instanceof RespostaQuestaoObjetiva){
									linhas.add(new String(qtq.getOrdem() + ";" + qtq.getQuestao().getTexto() + ";" + 
														  ((RespostaQuestaoObjetiva) rq).getAlternativa().getTexto()));														
								} else {
									linhas.add(new String(qtq.getOrdem() + ";" + qtq.getQuestao().getTexto() + ";" + 
														  ((RespostaQuestaoDissertativa) rq).getTexto()));
								}							
							}						
						}					
					}
				} catch (Exception ex){
					
				}
				avaliacaoAluno.setArquivoGerado(true);
			}			
			repositorio.atualizar(avaliacaoAluno);
			GerarArqCSV arq = new GerarArqCSV();
			arq.criaCSVFile(nomeArq, linhas);
		}
		
		System.out.println("XXXXXXXXXXXXXX TERMINOU processar avaliações");
	}
}
