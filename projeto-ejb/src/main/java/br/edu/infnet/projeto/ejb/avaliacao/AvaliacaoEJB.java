package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.edu.infnet.projeto.ejb.core.Email;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.infnet.Aluno;

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
			for (Aluno aluno : alunos) {
				email.enviarMsgAbertura(aluno);
			}
			
			//Seta o status da avaliação para "Aberta"
			avaliacao.setSituacao("A");
			repositorio.atualizar(avaliacao);
		}
	}
	
	public void processarAvaliacoes(){
		System.out.println("processar avaliações");
	}
}
