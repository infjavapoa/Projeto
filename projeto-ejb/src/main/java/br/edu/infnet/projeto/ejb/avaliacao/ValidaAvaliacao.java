package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.infnet.projeto.ejb.core.Repositorio;

@Stateless
public class ValidaAvaliacao {
	
	//Quando retornar verdadeiro é porque foi VÁLIDO
	@EJB
	private Repositorio repositorio;
	private Avaliacao aval;
	private Avaliacao old = null;
	private Boolean aberta = false;
	Date dataAtual = new Date();
	
	public void valida(Boolean nova) throws AvaliacaoInvalidaException{
		
		System.out.println("********************************************************************");
		
		if (!nova){ 
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa");
			this.setOld(repositorio.obter(Avaliacao.class, aval.getId()));
			System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBbb");
			if (old != null && old.getDataInicio() != null )
				dataAtual = new Date();
				//this.setAberta(old.getDataInicio().before(dataAtual));
				if (old.getSituacao() != null) 
					this.setAberta(old.getSituacao().equals("A"));
				else 
					this.setAberta(false);
				System.out.println("old: " + old.getDataInicio() + "Atual: " + dataAtual);
				System.out.println("old: " + old.getDataInicio() + "Atual: " + dataAtual);
			    if (this.getAberta() &&!(aval.getCodigo().equals(old.getCodigo()) && 
			    	  aval.getObjetivo().equals(old.getObjetivo()) &&
			    	  aval.getQuestionario().equals(old.getQuestionario()) &&
			    	  aval.getTurma().equals(old.getTurma()))){
				throw new AvaliacaoInvalidaException("Não é permitida a alteração de Avaliações Abertas!");
			}
		}
		
		System.out.println("CHECAF dsfisdjfaso ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZz");
		
		//Validações
		if (old == null) validaCodigo();		
		System.out.println("CHECAF COFIGO  ZZZZZZZZZZZZZZZZZZZZZz");		
		validaTurma();
		validaQuestionanio();
		validaObjetivo();
		validaInicio();
		validaFinal();
		
	}	
	
	public void valida() throws AvaliacaoInvalidaException{
		
		System.out.println("**************************** EXCLUSão FIO ****************************************");
		
		if (aval.getSituacao().equals("A")){			
			throw new AvaliacaoInvalidaException("Não é possivel excluir uma avaliação Aberta!");
		}
		
	}	
	
	public void validaCodigo() throws AvaliacaoInvalidaException{ 
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("codigo", aval.getCodigo());
		
		Avaliacao existe = null;
		
		try {
			existe = repositorio.obterWithNamedQuery(Avaliacao.class, "Avaliacao.pesquisarSeExiste", param);			
		} catch (Exception ex) {
			//vai dar merda quando não achar, mas não consegui tratar... o erro aqui é o bom!!!
		} finally {			
			if ((aval.getCodigo() == null || aval.getCodigo().equals(""))){			
			throw new AvaliacaoInvalidaException("Informe um Código de Avaliação válido!");
		} 
	}
		if (existe != null){
			throw new AvaliacaoInvalidaException("Já existe uma Avaliação com este código!");
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
	
	public void validaInicio() throws AvaliacaoInvalidaException{ 
		if (this.getAberta() && !aval.getDataInicio().equals(old.getDataInicio())){
			throw new AvaliacaoInvalidaException("Não é possivel alterar a Data de Início de uma Avaliação Aberta!");
		}
		if (!this.getAberta() && aval.getDataInicio() == null && aval.getDataTermino() != null){
			throw new AvaliacaoInvalidaException("Não é possivel informar a Data de Término sem a informação da Data de Início!");
		}		
	}
	
	public void validaFinal() throws AvaliacaoInvalidaException{
		dataAtual = new Date();
		System.out.println("DATA ATUAL............................: " + dataAtual);
		
		if ((aval.getDataInicio() != null && aval.getDataTermino() == null) ||
			(aval.getDataInicio() == null && aval.getDataTermino() != null))	{
			throw new AvaliacaoInvalidaException("Você deve informar o período completo!");
		}
		if (aval.getDataTermino() != null){
			if (aval.getDataTermino().before(dataAtual)){
				throw new AvaliacaoInvalidaException("Você não pode informar uma Data de Término menor que hoje e agora!");
			}		
			if (aval.getDataTermino().before(aval.getDataInicio())){
				throw new AvaliacaoInvalidaException("Você não pode informar uma Data de Término menor que a Data de Início!");
			}
		}
		if (old != null){
			if (old.getDataTermino() != null && aval.getDataTermino() != null){
				if (old != null && old.getDataTermino().before(dataAtual) && !old.getDataTermino().equals(aval.getDataTermino())){
					throw new AvaliacaoInvalidaException("Você não pode alterar a Data de Término pois ela já passou e a avaliação esta fechada pelo período!");			
				}
			} else if (old.getDataTermino() != null) {
				throw new AvaliacaoInvalidaException("Você não pode alterar a Data de Término pois ela já passou e a avaliação esta fechada pelo período!");
			}
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
	public Avaliacao getOld() {
		return old;
	}
	public void setOld(Avaliacao old) {
		this.old = old;
	}
	public Boolean getAberta() {
		return aberta;
	}
	public void setAberta(Boolean aberta) {
		this.aberta = aberta;
	}	
	

}
