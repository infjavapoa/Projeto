package br.edu.infnet.projeto.ejb.infnet;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Bloco extends BaseEntity<Long> {
	private static final long serialVersionUID = 7376436258490659133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bloco")
	private Long id;
	@Column(name="nm_bloco")
	private String nome;
    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
	private Curso curso;
	@OneToMany(mappedBy="bloco", targetEntity=Modulo.class)
	private List<Modulo> modulos = new ArrayList<Modulo>();
	
	public Bloco() {
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
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
}
