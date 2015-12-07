package br.edu.infnet.projeto.ejb.avaliacao;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Stateless
public class ValidaAvaliacao {
	
	//Quando retornar verdadeiro é porque foi VÁLIDO	
	private Avaliacao aval;
	private Boolean valido = true;
	
	public Boolean valida() throws AvaliacaoInvalidaException{
		
		System.out.println("VAAAAALIIIIIDAAAAAAAAAAAAAAAAA");
		
		//Validações
		validaCodigo();
		
		//retorno ok
		return this.getValido();		
	}	
	
	public void validaCodigo() throws AvaliacaoInvalidaException{ 
		System.out.println("ta no meu cara");
		if (aval.getCodigo() == null || aval.getCodigo().equals("")){
			System.out.println("tava nullo");
			throw new AvaliacaoInvalidaException("Saldo Insuficiente tente um valor menor");
		}
		if (aval.getCodigo().equals("Licker")){
			System.out.println("colocou licker");
			throw new AvaliacaoInvalidaException("O código não pode ser Licker meu veio");
		}
	}
	
	public void validaException(Exception ex){		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro desconhecido: " + ex.getCause().toString()));		
	}
	
public void validaExceptionAval(Exception ex){
		
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro desconhecido: " + ex.getCause().toString()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage() ));
	}

	public Avaliacao getAval() {
		return aval;
	}
	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}
	public Boolean getValido() {
		return valido;
	}
	public void setValido(Boolean valido) {
		this.valido = valido;
	}	

}
