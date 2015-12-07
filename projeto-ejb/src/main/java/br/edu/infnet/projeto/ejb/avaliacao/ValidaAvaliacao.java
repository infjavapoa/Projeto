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
						
		//Validações
		validaCodigo();
		validaTurma();
		validaQuestionanio();
		validaObjetivo();
		
		//retorno ok
		return this.getValido();		
	}	
	
	public void validaCodigo() throws AvaliacaoInvalidaException{ 
		if (aval.getCodigo() == null || aval.getCodigo().equals("")){			
			throw new AvaliacaoInvalidaException("Informe um Código de Avaliação válido!");
		}		
	}
	
	public void validaTurma() throws AvaliacaoInvalidaException{ 
		if (aval.getTurma() == null){
			throw new AvaliacaoInvalidaException("Informe uma Turma para a Avaliação!");
		}		
	}
	
	public void validaQuestionanio() throws AvaliacaoInvalidaException{ 
		if (aval.getQuestionario() == null){
			throw new AvaliacaoInvalidaException("Informe um Questionário para a Avaliação!");
		}		
	}
	
	public void validaObjetivo() throws AvaliacaoInvalidaException{ 
		if (aval.getObjetivo() == null || aval.getObjetivo().equals("")){
			throw new AvaliacaoInvalidaException("Informe um Objetivo para a Avaliação!");
		}		
	}
	
	public void validaException(Exception ex){		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro desconhecido: " + ex.getCause().toString()));		
	}
	
	public void validaExceptionAval(Exception ex){		
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
