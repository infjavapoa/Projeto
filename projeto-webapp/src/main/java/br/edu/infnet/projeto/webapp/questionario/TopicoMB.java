package br.edu.infnet.projeto.webapp.questionario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.infnet.projeto.ejb.core.InfnetException;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioEJB;
import br.edu.infnet.projeto.ejb.questionario.Topico;

@ManagedBean
@ViewScoped
public class TopicoMB {
	@EJB
    private Repositorio repositorio;
	@EJB
    private QuestionarioEJB questionarioEJB;
	
    private Topico topico;
    private List<Topico> listaTopicos;
    
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
	
	public void atualizaView(){
		topico = new Topico();
		listaTopicos = repositorio.listar(Topico.class);
	}
    
    public List<Topico> getListaTopicos() {
		return listaTopicos;
	}

	public void salvar() {
    	try {
    		questionarioEJB.salvarTopico(topico);
    		atualizaView();
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    }
	
	public void remover(Topico t) {
    	try {
    		questionarioEJB.removerTopico(t);
    		atualizaView();
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    }
}
