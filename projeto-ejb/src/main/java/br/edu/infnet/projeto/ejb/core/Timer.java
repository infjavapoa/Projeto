package br.edu.infnet.projeto.ejb.core;

import java.io.FileNotFoundException;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoEJB;

@Stateless
public class Timer {
	@EJB
	AvaliacaoEJB avaliacaoEJB;
		
	//A cada 30 segundos
    @Schedule(second="*/30", minute="*",hour="*", persistent=false)
	public void abrirAvaliacoes(){
    	try {
    		avaliacaoEJB.abrirAvaliacoes();
    	}
    	catch (InfnetException e){
    		e.printStackTrace();
    	}
	}
	
	//A cada 30 segundos
	@Schedule(second="*/30", minute="*",hour="*", persistent=false)
	public void processarAvaliacoes() throws FileNotFoundException{
		try {
			System.out.println("Ta na Timer processar");
			avaliacaoEJB.processarAvaliacoes();
		}
		catch (FileNotFoundException fne){
			fne.printStackTrace();
		}
    	catch (InfnetException e){
    		e.printStackTrace();
    	}
		
	}
}
