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
import javax.persistence.OneToMany;
import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.infnet.Aluno;

@Entity
public class AvaliacaoAluno extends BaseEntity<Long> {
	private static final long serialVersionUID = -6195488479326972221L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avaliacao_aluno")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "id_avaliacao", referencedColumnName = "id_avaliacao")
	private Avaliacao avaliacao;
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
	private Aluno aluno;
    private Date dataPreenchimento;
    @OneToMany(mappedBy="avaliacaoAluno", targetEntity=Resposta.class)
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	public AvaliacaoAluno() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}
	public void setDataPreenchimento(Date dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
}
