package br.edu.infnet.projeto.webapp.parametros;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.parametros.Parametros;





@ManagedBean
@ViewScoped
public class ParametrosMB {
	
	@EJB
    private Repositorio repositorio;
	private Parametros parametros;
	
	
    private List<Parametros> listaParametros;
	
	@PostConstruct
	public void init() {
	   	atualizaView();
	}
	
	public Parametros getParametros() {
		return parametros;
	}
	public void setParametros(Parametros parametros) {
		this.parametros = parametros;
	}
	
	public void atualizaView(){
		
		
		if (parametros == null)
		    parametros = new Parametros();
					
		listaParametros = repositorio.listar(Parametros.class);
		if (listaParametros.size() == 1 )
			   parametros = listaParametros.get(0);
		
		
	}
    
    public List<Parametros> getListaParametros() {
		return listaParametros;
	}
	
	public void salvar()  {
		try {
			if (parametros.getId() == null)
				repositorio.adicionar(parametros);
			else
				repositorio.atualizar(parametros);
			atualizaView();
			FacesContext context = FacesContext.getCurrentInstance();
            /*context.addMessage(":parametros:msg", new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção", "Alteração realizada com sucesso."));*/
            context.addMessage(null, new FacesMessage("Successo",  "Alteração realizada com sucesso.") );
		}
		catch (Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));		

			
		}
				
	
	}
	

	
}
