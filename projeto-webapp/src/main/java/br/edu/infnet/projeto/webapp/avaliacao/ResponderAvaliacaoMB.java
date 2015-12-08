package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.infnet.projeto.ejb.avaliacao.Alternativa;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoAluno;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoEJB;
import br.edu.infnet.projeto.ejb.avaliacao.RespostaQuestao;
import br.edu.infnet.projeto.ejb.avaliacao.RespostaQuestaoDissertativa;
import br.edu.infnet.projeto.ejb.avaliacao.RespostaQuestaoObjetiva;
import br.edu.infnet.projeto.ejb.core.InfnetException;
import br.edu.infnet.projeto.ejb.core.Repositorio;

@ManagedBean
@ViewScoped
public class ResponderAvaliacaoMB {
	
	@EJB
	Repositorio repositorio;
	@EJB
	AvaliacaoEJB avaliacaoEJB;
	AvaliacaoAluno avaliacaoAluno;
	List<Alternativa> alternativas;
	
    @PostConstruct
    public void init() {
    	String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    	try {
    		avaliacaoAluno = avaliacaoEJB.criarAvaliacaoAluno(id);
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    	alternativas = repositorio.listar(Alternativa.class);
    }
    
    public AvaliacaoAluno getAvaliacaoAluno() {
		return avaliacaoAluno;
	}

	public void setAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno) {
		this.avaliacaoAluno = avaliacaoAluno;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void salvar() {
    	try {
    		avaliacaoEJB.submeterAvaliacaoAluno(avaliacaoAluno);
    	}
    	catch (InfnetException ex){
    		ex.printStackTrace();
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    	}
    }
	
	public boolean instanceOfRespostaQuestaoObjetiva(RespostaQuestao rq){
		return rq instanceof RespostaQuestaoObjetiva;
	}
	
	public boolean instanceOfRespostaQuestaoDissertativa(RespostaQuestao rq){
		return rq instanceof RespostaQuestaoDissertativa;
	}
}
