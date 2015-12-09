package br.edu.infnet.projeto.webapp.questionario;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.infnet.projeto.ejb.core.InfnetException;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questionario.Questao;
import br.edu.infnet.projeto.ejb.questionario.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioEJB;

@ManagedBean
@ViewScoped
public class QuestaoMB {
	@EJB
    private Repositorio repositorio;
	@EJB
    private QuestionarioEJB questionarioEJB;
	
    private Questao questao;
    private List<Questao> listaQuestoes;
    
    @PostConstruct
    public void init() {
    	atualizaView();
    }

    public Questao getQuestao() {
		return questao;
	}
    
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
    
    public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}
	
	public void atualizaView(){
		questao = new QuestaoObjetiva();
		listaQuestoes = new ArrayList<Questao>();
		listaQuestoes.addAll(repositorio.listar(Questao.class));
	}

	public void salvar() {
    	try {
    		questionarioEJB.salvarQuestao(questao);
    		atualizaView();
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    }
	
	public void remover(Questao q) {
    	try {
    		questionarioEJB.removerQuestao(q);
    		atualizaView();
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    }
}
