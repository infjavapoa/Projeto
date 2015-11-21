package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.event.ChangeEvent;

import org.primefaces.event.SelectEvent;

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.infnet.Turma;
import br.edu.infnet.projeto.ejb.questionario.Questionario;

@ManagedBean
@ViewScoped
public class AvaliacaoMB {
	
	@EJB
    private Repositorio repositorio;
	
	private Avaliacao aval; 
	
	//turma
	private Turma turma;
	private Turma selTurma;
    private List<Turma> selTurmas;

	//questionario
    private Questionario questionario;
    private List<Questionario> listaQuestionarios;
	
    @PostConstruct
    public void init() {
    	atualizaView();
    }
        
    public Avaliacao getAval() {
		return aval;
	}

	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTopico(Turma turma) {
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
    }
 
    public List<Turma> getSelectedTurmas() {
        return selTurmas;
    }
 
    
    
    public void setSelectedTurmas(List<Turma> selectedTurmas) {
        this.selTurmas = selectedTurmas;
        this.aval.setTurma(selTurma);
        atualizaView();
    }
    
    public void onChange(ChangeEvent event){
    	
    	FacesMessage msg = new FacesMessage("Turma informada" );
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    	
    	Turma t = new Turma();
    	t.setId((long) 1);
    	t.setNome("Teste de Turma");
    	this.setSelTurma(t);
    	//repositorio.obter(Turma, id);    	
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Turma selecionada", ((Turma) event.getObject()).getId().toString() );
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        //this.setListaTurmas(this.getListaTurmas());
    }
	
	public Questionario getQuestionario() {
		return questionario;
	}
    
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	
    public List<Questionario> getListaQuestionarios() {
		return listaQuestionarios;
	}
    
    public void atualizaView(){
		turma = new Turma();
		questionario = new Questionario();
		aval = new Avaliacao();
		listaQuestionarios = repositorio.listar(Questionario.class);
		this.setListaTurmas(repositorio.listar(Turma.class));
	}
    
    


}
