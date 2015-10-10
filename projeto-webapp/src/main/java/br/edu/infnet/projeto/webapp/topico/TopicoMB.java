package br.edu.infnet.projeto.webapp.topico;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import br.edu.infnet.projeto.ejb.topico.Topico;
import br.edu.infnet.projeto.ejb.topico.TopicoBean;

@ManagedBean
@ViewScoped
public class TopicoMB {
    @EJB
    private TopicoBean topicoBean;
    
    private Topico topico;
    private List<Topico> topicos;
    
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
	
    public List<Topico> getTopicos() {
		return topicos;
	}

	public String adicionar() {
		topicoBean.adicionar(topico);
		atualizaView();
		return "";
    }
	
	private void atualizaView(){
		topico = new Topico();
		topicos = topicoBean.listar();
	}
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Topico) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Topico) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
