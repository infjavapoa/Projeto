package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;

import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.infnet.Aluno;

@Entity
@Table(name="avaliacao_aluno")
@NamedQueries({
@NamedQuery(name="AvaliacaoAluno.pesquisarNaoProcessadas" , 
			query="SELECT anp FROM AvaliacaoAluno anp WHERE anp.emailEnviado = :false or anp.arquivoGerado = :false"),
@NamedQuery(name="AvaliacaoAluno.pesquisarPorAvaliacaoEAluno" , 
			query="SELECT aa FROM AvaliacaoAluno aa WHERE aa.avaliacao = :avaliacao and aa.aluno = :aluno")
})
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
    @Column(name="data_preenchimento")
    private Date dataPreenchimento;
    @Column (name="ind_email_enviado")
    private Boolean emailEnviado = false;
    @Column (name="ind_arq_gerado")
    private Boolean arquivoGerado = false;
    
    @OneToMany(mappedBy="avaliacaoAluno", cascade=CascadeType.ALL, targetEntity=RespostaTopico.class)
	private List<RespostaTopico> respostaTopicos = new ArrayList<RespostaTopico>();
	
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
	public Boolean getEmailEnviado() {
		return emailEnviado;
	}
	public void setEmailEnviado(Boolean emailEnviado) {
		this.emailEnviado = emailEnviado;
	}
	public Boolean getArquivoGerado() {
		return arquivoGerado;
	}
	public void setArquivoGerado(Boolean arquivoGerado) {
		this.arquivoGerado = arquivoGerado;
	}
	public List<RespostaTopico> getRespostaTopicos() {
		return respostaTopicos;
	}
	public void setRespostaTopicos(List<RespostaTopico> respostaTopicos) {
		this.respostaTopicos = respostaTopicos;
	}
	public void adicionaRespostaTopico(RespostaTopico respostaTopico){
		this.respostaTopicos.add(respostaTopico);
	}
}
