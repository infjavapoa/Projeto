package br.edu.infnet.projeto.webapp.avaliacao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ResponderAvaliacaoMB {
    public String getTeste(){
    	return "teste";
    }
    
    @PostConstruct
    public void init() {
    	String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    	System.out.println(id);
    }
}
