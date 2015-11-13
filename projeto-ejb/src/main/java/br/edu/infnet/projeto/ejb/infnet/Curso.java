package br.edu.infnet.projeto.ejb.infnet;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Curso extends BaseEntity<Long> {
	private static final long serialVersionUID = 7376436258490659133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Long id;
	@Column(name="nm_curso")
	private String nome;
	@OneToMany(mappedBy="curso", targetEntity=Bloco.class)
	private List<Bloco> blocos = new ArrayList<Bloco>();
	
	public Curso() {
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
	public List<Bloco> getBlocos() {
		return blocos;
	}
	public void setBlocos(List<Bloco> blocos) {
		this.blocos = blocos;
	}
}
