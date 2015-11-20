package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.infnet.projeto.ejb.avaliacao.Alternativa;
import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoAluno;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.infnet.Aluno;

@ManagedBean
@ViewScoped
public class ResponderAvaliacaoMB {
	
	@EJB
	Repositorio repositorio;
	AvaliacaoAluno avaliacaoAluno;
	List<Alternativa> alternativas;
	
    @PostConstruct
    public void init() {
    	String idAvaliacao = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAvaliacao");
    	String idAluno = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idAluno");
    	avaliacaoAluno = new AvaliacaoAluno();
    	avaliacaoAluno.setAluno(repositorio.obter(Aluno.class, new Long(idAluno)));
    	avaliacaoAluno.setAvaliacao(repositorio.obter(Avaliacao.class, new Long(idAvaliacao)));
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
}
