package br.edu.infnet.projeto.ejb.questionario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class QuestaoDissertativa extends Questao {
	private static final long serialVersionUID = 6945408147022083372L;

	public QuestaoDissertativa() {
		super();
	}
	
	public QuestaoDissertativa(Long id, String texto) {
		super();
		super.setId(id);
		super.setTexto(texto);
		super.setTipoQuestao("D");
	}
}
