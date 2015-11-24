package br.edu.infnet.projeto.ejb.avaliacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class RespostaQuestaoDissertativa extends RespostaQuestao {
	private static final long serialVersionUID = 6255530996405264370L;
	
	private String texto;
	
	public RespostaQuestaoDissertativa() {
		super();
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
