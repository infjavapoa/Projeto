package br.edu.infnet.projeto.ejb.questionario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.core.InfnetException;
import br.edu.infnet.projeto.ejb.core.Repositorio;

@Stateless
public class QuestionarioEJB {
	
	@EJB
	Repositorio repositorio;

	public void salvarTopico(Topico topico) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("texto", topico.getTexto());
		List<Topico> topicos = repositorio.listarWithNamedQuery(Topico.class, "Topico.pesquisarPorTexto", param);
		if (topico.getTexto() == null || topico.getTexto().isEmpty()) 
			throw new InfnetException("Favor, informar um texto para o tópico.");
		else {
			if (topicos.size() > 0 && !topicos.get(0).getId().equals(topico.getId())) 
				throw new InfnetException("Já existe tópico cadastrado com mesmo texto.");
			else {
				if (topico.getId() == null)
					repositorio.adicionar(topico);
				else
					repositorio.atualizar(topico);
			}
		}
	}
	
	public void removerTopico(Topico topico) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", topico.getId());
		List<Questionario> questionarios = repositorio.listarWithNamedQuery(Questionario.class, "Questionario.pesquisarPorTopico", param);
		if (questionarios.size() > 0)
			throw new InfnetException("Não é possível excluir este tópico, pois ele já foi adicionado em questionários.");
		else
			repositorio.remover(topico);
	}
	
	public void salvarQuestao(Questao questao) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("texto", questao.getTexto());
		List<Questao> questoes = repositorio.listarWithNamedQuery(Questao.class, "Questao.pesquisarPorTexto", param);
		if (questao.getTexto() == null || questao.getTexto().isEmpty()) 
			throw new InfnetException("Favor, informar um texto para a questão.");
		else {
			if (questoes.size() > 0 && !questoes.get(0).getId().equals(questao.getId())) 
				throw new InfnetException("Já existe questão cadastrada com mesmo texto.");
			else {
				//Atualiza o tipo da questão
				if (questao.getTipoQuestao().equals("O"))
					questao = new QuestaoObjetiva(questao.getId(), questao.getTexto());
				else
					questao = new QuestaoDissertativa(questao.getId(), questao.getTexto());
				
				if (questao.getId() == null) 
					repositorio.adicionar(questao);
				else
					repositorio.atualizar(questao);
			}
		}
	}
	
	public void removerQuestao(Questao questao) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", questao.getId());
		List<Questionario> questionarios = repositorio.listarWithNamedQuery(Questionario.class, "Questionario.pesquisarPorQuestao", param);
		if (questionarios.size() > 0)
			throw new InfnetException("Não é possível excluir esta questão, pois ela já foi adicionada em questionários.");
		else
			repositorio.remover(questao);
	}
	
	public void salvarQuestionario(Questionario questionario) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nome", questionario.getNome());
		List<Questionario> questionarios = repositorio.listarWithNamedQuery(Questionario.class, "Questionario.pesquisarPorNome", param);
		if (questionario.getNome() == null || questionario.getNome().isEmpty()) 
			throw new InfnetException("Favor, informar um nome para o questionário.");
		else {
			if (questionario.getQuestionarioTopicos() == null || questionario.getQuestionarioTopicos().size() == 0) 
				throw new InfnetException("Favor, adicionar pelo menos um tópico ao questionário.");
			else {
				for (QuestionarioTopico qt : questionario.getQuestionarioTopicos()) {
					if (qt.getQuestionarioTopicoQuestoes() == null || qt.getQuestionarioTopicoQuestoes().size() == 0) 
						throw new InfnetException("Favor, adicionar pelo menos uma questão ao tópico \"" + qt.getTopico().getTexto() + "\"");
				}
			
				if (questionarios.size() > 0 && !questionarios.get(0).getId().equals(questionario.getId())) 
					throw new InfnetException("Já existe questionário cadastrado com mesmo nome.");
				else {
					if (questionario.getId() == null) 
						repositorio.adicionar(questionario);
					else
						repositorio.atualizar(questionario);
				}
			}
		}
	}
	
	public void removerQuestionario(Questionario questionario) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", questionario.getId());
		List<Avaliacao> avaliacoes = repositorio.listarWithNamedQuery(Avaliacao.class, "Avaliacao.pesquisarPorQuestionario", param);
		if (avaliacoes.size() > 0)
			throw new InfnetException("Não é possível excluir este questionário, pois ele já foi utilizado em avaliações.");
		else
			repositorio.remover(questionario);
	}
}
