package br.edu.infnet.projeto.webapp.parametros;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.parametros.Parametros;



@ManagedBean
@ViewScoped
public class ParametrosMB {
	
	@EJB
    private Repositorio repositorio;
	private Parametros parametros;
	
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
		
	}
	
	public void salvar() {
		if (parametros.getId() == null)
			repositorio.adicionar(parametros);
		else
			repositorio.atualizar(parametros);
		atualizaView();
		
	
	}
	

	
}
