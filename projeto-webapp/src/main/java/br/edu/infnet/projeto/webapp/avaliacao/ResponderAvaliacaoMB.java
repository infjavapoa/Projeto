package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.infnet.projeto.ejb.avaliacao.Alternativa;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoAluno;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoEJB;
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
    	avaliacaoAluno = avaliacaoEJB.criarAvaliacaoAluno(id);
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
		if (avaliacaoAluno.getId() == null)
			repositorio.adicionar(avaliacaoAluno);
		else
			repositorio.atualizar(avaliacaoAluno);
    }
}
