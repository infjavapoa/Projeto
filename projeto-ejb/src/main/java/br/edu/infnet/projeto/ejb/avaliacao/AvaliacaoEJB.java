package br.edu.infnet.projeto.ejb.avaliacao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.infnet.projeto.ejb.core.Email;
import br.edu.infnet.projeto.ejb.core.GerarArqCSV;
import br.edu.infnet.projeto.ejb.core.InfnetException;
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

	public void abrirAvaliacoes() throws InfnetException{
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("dataAtual", new Date());
			List<Avaliacao> avaliacoes = repositorio.listarWithNamedQuery(Avaliacao.class, "Avaliacao.pesquisarNaoAbertas", param);
			
			for (Avaliacao avaliacao : avaliacoes) {
				if (avaliacao.getTurma() != null) {
					List<Aluno> alunos = avaliacao.getTurma().getAlunos();
					
					if (alunos != null && alunos.size() > 0) {
						//Manda e-mail para cada aluno que pertence à turma avaliada
						for (Aluno aluno : alunos) {				
							email.enviarMsgAbertura(aluno, avaliacao);
						}
						
						//Seta o status da avaliação para "Aberta"
						avaliacao.setSituacao("A");
						repositorio.atualizar(avaliacao);
					}
					else
						throw new InfnetException("Avaliação " + avaliacao.getCodigo() + " não pôde ser aberta, pois a turma não possui alunos cadastrados.");
				}
				else
					throw new InfnetException("Avaliação " + avaliacao.getCodigo() + " não pôde ser aberta, pois não possui turma cadastrada.");
			}
		} catch (InfnetException e){
			throw e;
		} catch (Exception e){
			throw new InfnetException(e.getMessage());
		}
	}
	
	public AvaliacaoAluno criarAvaliacaoAluno(String id) throws InfnetException{
		try {
			//decripta o querystring e verifica se é válido
			id = Seguranca.decriptar(id);
			if (id.indexOf(":") == -1 || id.split(":").length != 2) 
				throw new InfnetException("Parâmetros Inválidos.");
			else {
				//Testa se existe aluno para o ID
		    	String idAluno = id.split(":")[0];
		    	Aluno aluno = repositorio.obter(Aluno.class, new Long(idAluno));
		    	if (aluno == null)
		    		throw new InfnetException("Código de aluno inválido.");
		    	else {		    	
		    		//Testa se existe avaliação para o ID
		    		String idAvaliacao = id.split(":")[1];
		    		Avaliacao avaliacao = repositorio.obter(Avaliacao.class, new Long(idAvaliacao));
		    		if (avaliacao == null)
		    			throw new InfnetException("Código de avaliação inválido.");
		    		else {
		    			//verifica situação
				    	if (!avaliacao.getSituacao().equals("A"))  
					    	throw new InfnetException("Avaliação " + avaliacao.getCodigo() + " ainda não foi aberta pelo sistema.");
				    	else {
				    		//Verifica se a avaliação já foi preenchida pelo aluno
			    			Map<String, Object> param = new HashMap<String, Object>();
			    			param.put("avaliacao", avaliacao);
			    			param.put("aluno", aluno);
			    			List<AvaliacaoAluno> avaliacaoAlunos = repositorio.listarWithNamedQuery(AvaliacaoAluno.class, "AvaliacaoAluno.pesquisarPorAvaliacaoEAluno", param);
			    			
			    			if (avaliacaoAlunos != null && avaliacaoAlunos.size() > 0)
			    				//retorna avaliação preenchida 
			    				return avaliacaoAlunos.get(0);
			    			else { 
			    				//Verifica prazo
			    				if (avaliacao.getDataTermino().before(new Date()))
					    			throw new InfnetException("O prazo para preenchimento da avaliação " + avaliacao.getCodigo() + " foi encerrado.");
					    		else {
							    	//Cria o objeto AvaliacaoAluno e devolve para a interface
							    	AvaliacaoAluno avaliacaoAluno = new AvaliacaoAluno();
							    	avaliacaoAluno.setAluno(aluno);
							    	avaliacaoAluno.setAvaliacao(avaliacao);
							    	
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
				    		}
				    	}
		    		}
		    	}
			}
		} 
		catch (InfnetException e){
			throw e;
		} 
		catch (Exception e){
			throw new InfnetException(e.getMessage());
		}
	}
	
	public void submeterAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno) throws InfnetException{
		if (avaliacaoAluno.getId() != null) 
			throw new InfnetException("Avaliação já foi submetida.");
		else {
			avaliacaoAluno.setDataPreenchimento(new Date());
			repositorio.adicionar(avaliacaoAluno);
		}
	}
	
	public void processarAvaliacoes() throws InfnetException, FileNotFoundException{
		
		System.out.println("XXXXXXXXXXXXXX processar avaliações");
		
		try {
			Parametros parametros;
			String nomeArq = "I:/SAI/";
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("false", false);
			List<AvaliacaoAluno> avaliadas = repositorio.listarWithNamedQuery(AvaliacaoAluno.class, "AvaliacaoAluno.pesquisarNaoProcessadas", param);
					
			System.out.println("O que temos???" + avaliadas.size());
			for (AvaliacaoAluno avaliacaoAluno : avaliadas) {
				List<String> linhas = new ArrayList<String>();
				List<Parametros> parametrosList = repositorio.listar(Parametros.class);
				if (parametrosList != null && parametrosList.size() > 0) {
					parametros = parametrosList.get(0);
					if (parametros != null && !parametros.getDiretorioArquivoAvaliacao().isEmpty()){
						nomeArq = parametros.getDiretorioArquivoAvaliacao() + "/"; 
					}
				}
				linhas.add(new String("Código da Avaliação;Turma;Professor;Curso;Bloco;Módulo;Questionário;"));
				System.out.println("Ta de boa..." + avaliadas);
				//avaliacao.setEmailEnviado(false);
				if (!avaliacaoAluno.getEmailEnviado()){					
					System.out.println("manda o email para o viado" + avaliacaoAluno.getAluno().getNome());
					email.enviarMsgConfirmaRecebAval(avaliacaoAluno);
					try{
						avaliacaoAluno.setEmailEnviado(true);
					}
					catch (Exception e){
							throw new InfnetException(e.getMessage());
					}
									
				}
				
				if (!avaliacaoAluno.getArquivoGerado()){
					
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
								if (rq instanceof RespostaQuestaoObjetiva && rq.getRespostaTopico().getAvaliacaoAluno().getAluno().equals(avaliacaoAluno.getAluno())){
									linhas.add(new String(qtq.getOrdem() + ";" + qtq.getQuestao().getTexto() + ";" + 
														  ((RespostaQuestaoObjetiva) rq).getAlternativa().getTexto()));														
								} else if (rq.getRespostaTopico().getAvaliacaoAluno().getAluno().equals(avaliacaoAluno.getAluno())){
									linhas.add(new String(qtq.getOrdem() + ";" + qtq.getQuestao().getTexto() + ";" + 
														  ((RespostaQuestaoDissertativa) rq).getTexto()));
								}							
							}						
						}					
					}				
					
				}
				repositorio.atualizar(avaliacaoAluno);
				GerarArqCSV arq = new GerarArqCSV();
				if (arq.criaCSVFile(nomeArq, linhas)) avaliacaoAluno.setArquivoGerado(true);
				else System.out.println("O Arquivo não foi criado!");
				
			}
		} catch (InfnetException e){
			throw e;
		} catch (Exception e){
			System.out.println("Exceção causada na tentativa de processar avaliações!");
			throw new InfnetException(e.getMessage());
		}
		
		System.out.println("XXXXXXXXXXXXXX TERMINOU processar avaliações");
	}
}
