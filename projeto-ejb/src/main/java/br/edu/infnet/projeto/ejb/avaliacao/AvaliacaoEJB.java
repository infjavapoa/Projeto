package br.edu.infnet.projeto.ejb.avaliacao;

import javax.ejb.Stateless;

@Stateless
public class AvaliacaoEJB {
	public void abrirAvaliacoes(){
		System.out.println("abrir avaliações");
	}
	
	public void processarAvaliacoes(){
		System.out.println("processar avaliações");
	}
}
