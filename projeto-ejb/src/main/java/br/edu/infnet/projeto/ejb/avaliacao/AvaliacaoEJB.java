package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.infnet.projeto.ejb.core.Email;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.core.Seguranca;
import br.edu.infnet.projeto.ejb.infnet.Aluno;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("false", false);
		List<AvaliacaoAluno> avaliadas = repositorio.listarWithNamedQuery(AvaliacaoAluno.class, "AvaliacaoAluno.pesquisarNaoProcessadas", param);
		System.out.println("O que temos???" + avaliadas.size());
		for (AvaliacaoAluno avaliacao : avaliadas) {
			
			System.out.println("Ta de boa..." + avaliadas);
			//avaliacao.setEmailEnviado(false);
			if (!avaliacao.getEmailEnviado()){
				System.out.println("manda o email para o viado" + avaliacao.getAluno().getNome());
				email.enviarMsgConfirmaRecebAval(avaliacao);				
				avaliacao.setEmailEnviado(true);				
			}
			
			if (!avaliacao.getArquivoGerado()){
				
			}
			
			//Manda e-mail para cada aluno que pertence à turma avaliada
			//for (Aluno aluno : alunos) {				
				//email.enviarMsgAbertura(aluno, avaliacao);
			//}
			
			//Seta o status da avaliação para "Aberta"
			//avaliacao.setSituacao("A");
			repositorio.atualizar(avaliacao);
		}
		System.out.println("XXXXXXXXXXXXXX TERMONOU processar avaliações");
	}
}
