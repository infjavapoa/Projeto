package br.edu.infnet.projeto.ejb.questionario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Questionario extends BaseEntity<Long> {
	private static final long serialVersionUID = 8291323679754678858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questionario")
	private Long id;
	private String nome;
	@OneToMany(mappedBy="questionario")
	private List<QuestionarioQuestao> questoes;
	
	public Questionario() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
