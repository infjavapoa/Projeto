package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.infnet.Turma;
import br.edu.infnet.projeto.ejb.questionario.Questionario;

@ManagedBean
@ViewScoped
public class AvaliacaoMB {
	
	@EJB
    private Repositorio repositorio;
	
	private Avaliacao aval;
	private List<Avaliacao> listaAvals;
	
	//turma
	private Turma turma;
	private Turma selTurma;
    private List<Turma> selTurmas;
    private List<Turma> filtroTurmas;
    
    //questionario
  	private Questionario questionario;
  	private Questionario selQuestionario;
    private List<Questionario> selQuestionarios;
    private List<Questionario> filtroQuestionarios;
	
	@PostConstruct
    public void init() {
    	atualizaView();
    }
	
	//Avaliacao
	public Avaliacao getAval() {
		return aval;
	}
	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}
	public List<Avaliacao> getListaAvals() {
		return listaAvals;
	}
	public void setListaAvals(List<Avaliacao> listaAvals) {
		this.listaAvals = listaAvals;
	}
	
	//INICIO TURMA
    public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}	
	public List<Turma> getListaTurmas(){		
		return repositorio.listar(Turma.class);		
	}	
	public void setListaTurmas(List<Turma> listaTurmas) {
	}
	public Turma getSelTurma() {
        return selTurma;
    }
    public void setSelTurma(Turma selectedTurma) {
        this.selTurma = selectedTurma;
        this.aval.setTurma(selectedTurma);
    }
    public List<Turma> getSelectedTurmas() {
        return selTurmas;
    }
    public List<Turma> getFiltroTurmas() {
        return filtroTurmas;
    }
    public void setFiltroTurmas(List<Turma> filtroTurmas) {
        this.filtroTurmas = filtroTurmas;
    }
    public void setSelectedTurmas(List<Turma> selectedTurmas) {
        this.selTurmas = selectedTurmas;
        atualizaView();
    }
    public void onRowTurSelect(SelectEvent event) {
        //FacesMessage msg = new FacesMessage("Turma selecionada", ((Turma) event.getObject()).getId().toString() );
        //FacesContext.getCurrentInstance().addMessage(null, msg);        
        //this.setListaTurmas(this.getListaTurmas());
    }
    //FINAL TURMA

    
  //INICIO QUESTIONARIO
    public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public List<Questionario> getListaQuestionarios(){		
		return repositorio.listar(Questionario.class);		
	}	
	public void setListaQuestionarios(List<Questionario> listaQuestionarios) {
	}
	public Questionario getSelQuestionario() {
        return selQuestionario;
    }
    public void setSelQuestionario(Questionario selectedQuestionario) {
        this.selQuestionario = selectedQuestionario;
        this.aval.setQuestionario(selectedQuestionario);
    }
    public List<Questionario> getSelectedQuestionario() {
        return selQuestionarios;
    }
    public List<Questionario> getFiltroQuestionarios() {
        return filtroQuestionarios;
    }
    public void setFiltroQuestionarios(List<Questionario> filtroQuestionarios) {
        this.filtroQuestionarios = filtroQuestionarios;
    }
    public void setSelectedQuestionarios(List<Questionario> selectedQuestionarios) {
        this.selQuestionarios = selectedQuestionarios;
        atualizaView();
    }	
    public void onRowQuestSelect(SelectEvent event) {
        //FacesMessage msg = new FacesMessage("Turma selecionada", ((Turma) event.getObject()).getId().toString() );
        //FacesContext.getCurrentInstance().addMessage(null, msg);        
        //this.setListaTurmas(this.getListaTurmas());
    }
    //FINAL TURMA
    
	public void atualizaView(){
		aval = new Avaliacao();
		listaAvals = repositorio.listar(Avaliacao.class);
		
		//turma 
		this.selTurmas = this.getListaTurmas();
		this.filtroTurmas = this.selTurmas;
		
		//turma 
		this.selQuestionarios = this.getListaQuestionarios();
		this.filtroQuestionarios = this.selQuestionarios;
		
	}
	
	//Persistir
	public void salvar() {
		if (aval.getId() == null)
			repositorio.adicionar(aval);
		else
			repositorio.atualizar(aval);
		atualizaView();
    }

}
