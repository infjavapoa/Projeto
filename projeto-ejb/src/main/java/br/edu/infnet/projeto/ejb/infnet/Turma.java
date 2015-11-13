package br.edu.infnet.projeto.ejb.infnet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
	private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
	private Modulo modulo;    
    
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
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
