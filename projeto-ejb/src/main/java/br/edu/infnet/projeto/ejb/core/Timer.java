package br.edu.infnet.projeto.ejb.core;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoEJB;

@Stateless
public class Timer {
	@EJB
	AvaliacaoEJB avaliacaoEJB;
	
	//A cada 30 segundos
    //@Schedule(second="*/30", minute="*",hour="*", persistent=false)
	public void abrirAvaliacoes(){
	    avaliacaoEJB.abrirAvaliacoes();
	}
	
	//A cada 30 segundos
	//@Schedule(second="*/30", minute="*",hour="*", persistent=false)
	public void processarAvaliacoes(){
		avaliacaoEJB.processarAvaliacoes();
	}
}
