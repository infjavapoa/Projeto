package br.edu.infnet.projeto.ejb.avaliacao;

public class AvaliacaoInvalidaException extends Exception{

	private static final long serialVersionUID = 1L;

	public AvaliacaoInvalidaException (String msg) {		
		super(msg);
		System.out.println("fez a exceção:" + msg);
	}
	
}
