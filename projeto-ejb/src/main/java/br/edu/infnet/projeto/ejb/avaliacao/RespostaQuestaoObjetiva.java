package br.edu.infnet.projeto.ejb.avaliacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("O")
public class RespostaQuestaoObjetiva extends RespostaQuestao {
	private static final long serialVersionUID = -5803254679952076473L;
	
	@ManyToOne
    @JoinColumn(name = "id_alternativa", referencedColumnName = "id_alternativa")
	private Alternativa alternativa;

	public RespostaQuestaoObjetiva() {
		super();
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
}
