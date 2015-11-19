package br.edu.infnet.projeto.ejb.infnet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Turma extends BaseEntity<Long> {
	private static final long serialVersionUID = -2191517009190792630L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turma")
	private Long id;
	@Column(name="nr_turma")
	private Integer nro;
	private String nome;
	@Column(name="dt_inicio")
	private Date dtInicio;
	@Column(name="dt_fim")
	private Date dtFim;
    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id_professor")
	private Professor professor;
    @ManyToMany
    @JoinTable(name = "turma_aluno", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_aluno"))
    private List<Aluno> alunos;
    @ManyToOne
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
	private Modulo modulo;
	@OneToMany(mappedBy="turma", targetEntity=Avaliacao.class)
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
    
	public Turma() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNro() {
		return nro;
	}
	public void setNro(Integer nro) {
		this.nro = nro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
}
