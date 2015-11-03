package br.edu.infnet.projeto.ejb.questao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class QuestaoObjetiva extends Questao {
	private static final long serialVersionUID = 5266938109177610203L;
	
	public QuestaoObjetiva() {
		super();
	}
	
	public QuestaoObjetiva(Long id, String texto) {
		super();
		super.setId(id);
		super.setTexto(texto);
		super.setTipoQuestao("O");
	}
	
	@Override
	public String toString(){
		return "Objetiva";
	}
}
