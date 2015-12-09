package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.infnet.Turma;
import br.edu.infnet.projeto.ejb.questionario.Questionario;

@Entity
@NamedQueries(@NamedQuery(name="Avaliacao.pesquisarNaoAbertas" , query="SELECT a FROM Avaliacao a WHERE a.situacao = 'F' and a.dataInicio <= :dataAtual"))
@NamedQuery(name="Avaliacao.pesquisarSeExiste" , query="SELECT a FROM Avaliacao a WHERE a.codigo = :codigo")
public class Avaliacao extends BaseEntity<Long> {
	private static final long serialVersionUID = -6220351357437865318L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avaliacao")
	private Long id;
	@Column(name="cod_avaliacao")
	private String codigo;
	private String objetivo;
	private String situacao;
	@Column(name="data_inicio")
	private Date dataInicio;
	@Column(name="data_termino")
	private Date dataTermino;
    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id_turma")
	private Turma turma;
    @ManyToOne
    @JoinColumn(name = "id_questionario", referencedColumnName = "id_questionario")
	private Questionario questionario;
	@OneToMany(mappedBy="avaliacao", targetEntity=AvaliacaoAluno.class)
	private List<AvaliacaoAluno> avaliacaoAlunos = new ArrayList<AvaliacaoAluno>();
	
	public Avaliacao() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public List<AvaliacaoAluno> getAvaliacaoAlunos() {
		return avaliacaoAlunos;
	}
	public void setAvaliacaoAlunos(List<AvaliacaoAluno> avaliacaoAlunos) {
		this.avaliacaoAlunos = avaliacaoAlunos;
	}
}
