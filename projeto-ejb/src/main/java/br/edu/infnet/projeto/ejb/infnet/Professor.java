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
public class Professor extends BaseEntity<Long> {
	private static final long serialVersionUID = 3758858244217750242L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_professor")
	private Long id;
	@Column(name="nm_professor")
	private String nome;
	private String email;
	private String genero;
	@OneToMany(mappedBy="professor", targetEntity=Turma.class)
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Professor() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
