package br.edu.infnet.projeto.ejb.questao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.edu.infnet.projeto.ejb.topico.Topico;

@Entity
@DiscriminatorValue("O")
public class QuestaoObjetiva extends Questao {
	private static final long serialVersionUID = 5266938109177610203L;
	
	public QuestaoObjetiva() {
		super();
	}
	
	public QuestaoObjetiva(Long id, String texto, Topico topico) {
		super();
		super.setId(id);
		super.setTexto(texto);
		super.setTopico(topico);
		super.setTipoQuestao("O");
	}
	
	@Override
	public String toString(){
		return "Objetiva";
	}
}
