package br.edu.infnet.projeto.ejb.questao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class QuestaoDissertativa extends Questao {
	private static final long serialVersionUID = 5266938109177610203L;
	
}
