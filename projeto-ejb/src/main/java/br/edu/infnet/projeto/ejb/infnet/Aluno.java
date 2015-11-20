package br.edu.infnet.projeto.ejb.infnet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoAluno;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Aluno extends BaseEntity<Long> {
	private static final long serialVersionUID = -7018863884091006025L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_aluno")
	private Long id;
	@Column(name="nm_aluno")
	private String nome;
	private String email;
	private String genero;
	@Column(name="nr_matricula")
	private Integer matricula;
	private String cpf;
	@ManyToMany(mappedBy="alunos")
	private List<Turma> turmas = new ArrayList<Turma>();
	@OneToMany(mappedBy="aluno", targetEntity=AvaliacaoAluno.class)
	private List<AvaliacaoAluno> avaliacaoAlunos = new ArrayList<AvaliacaoAluno>();
	
	public Aluno() {
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
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public List<AvaliacaoAluno> getAvaliacaoAlunos() {
		return avaliacaoAlunos;
	}
	public void setAvaliacaoAlunos(List<AvaliacaoAluno> avaliacaoAlunos) {
		this.avaliacaoAlunos = avaliacaoAlunos;
	}
}
