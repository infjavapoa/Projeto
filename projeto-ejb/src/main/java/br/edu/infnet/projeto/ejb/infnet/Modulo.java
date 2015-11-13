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
public class Modulo extends BaseEntity<Long> {
	private static final long serialVersionUID = 1277883405272530368L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_modulo")
	private Long id;
	@Column(name="nm_modulo")
	private String nome;
    @ManyToOne
    @JoinColumn(name = "id_bloco", referencedColumnName = "id_bloco")
	private Bloco bloco;
	@OneToMany(mappedBy="modulo", targetEntity=Turma.class)
	private List<Turma> turmas = new ArrayList<Turma>();
    
	public Modulo() {
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
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
