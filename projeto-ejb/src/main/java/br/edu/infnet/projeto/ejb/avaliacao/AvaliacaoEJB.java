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
		System.out.println("processar avaliações");
	}
}
