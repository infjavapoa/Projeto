package br.edu.infnet.projeto.webapp.questionario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.ReorderEvent;

import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questionario.Questao;
import br.edu.infnet.projeto.ejb.questionario.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.questionario.Questionario;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopico;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopicoQuestao;
import br.edu.infnet.projeto.ejb.questionario.Topico;

@ManagedBean
@ViewScoped
public class QuestionarioMB {
	@EJB
    private Repositorio repositorio;
    private Questionario questionario;
    private List<Questionario> listaQuestionarios;
    private Topico topico;
    private Questao questao;
    
    @PostConstruct
    public void init() {
    	atualizaView();
    }
    
    public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	
    public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Questionario getQuestionario() {
		return questionario;
	}
    
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	
	public void atualizaView(){
		topico = new Topico();
		questao = new QuestaoObjetiva();
		questionario = new Questionario();
		listaQuestionarios = repositorio.listar(Questionario.class);
	}
    
    public List<Questionario> getListaQuestionarios() {
		return listaQuestionarios;
	}

	public void salvar() {
		if (questionario.getId() == null)
			repositorio.adicionar(questionario);
		else
			repositorio.atualizar(questionario);
		atualizaView();
    }
	
	public void remover() {
		repositorio.remover(questionario);
		atualizaView();
    }
	
	public List<Topico> listarTopicos(String texto){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("texto","%"+texto+"%");
		return repositorio.listarWithNamedQuery(Topico.class, "Topico.pesquisarPorTexto", parametros);
	}
	
	public List<Questao> listarQuestoes(String texto){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("texto","%"+texto+"%");
		return repositorio.listarWithNamedQuery(Questao.class, "Questao.pesquisarPorTexto", parametros);
	}
	
	public void adicionarQuestionarioTopico(){
		questionario.adicionaQuestionarioTopico(topico);
		topico = new Topico();
	}
	
	public void adicionarQuestionarioTopicoQuestao(QuestionarioTopico qt){
		qt.adicionaQuestionarioTopicoQuestao(questao);
		questao = new QuestaoObjetiva();
	}
	
	public void removerTopico(QuestionarioTopico qt) {
		questionario.removeQuestionarioTopico(qt);
    }
	
	public void removerQuestao(QuestionarioTopico qt, QuestionarioTopicoQuestao qtq) {
		qt.removeQuestionarioTopicoQuestao(qtq);
    }
	
    public void onRowTopicoReorder(ReorderEvent event) {
    	
    }
}
