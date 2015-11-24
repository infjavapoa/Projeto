package br.edu.infnet.projeto.ejb.avaliacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopico;

@Entity
@Table(name="resposta_topico")
public class RespostaTopico extends BaseEntity<Long> {
	private static final long serialVersionUID = -7038950037199526739L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_resposta_topico")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "id_avaliacao_aluno", referencedColumnName = "id_avaliacao_aluno")
	private AvaliacaoAluno avaliacaoAluno;
    @ManyToOne
    @JoinColumn(name = "id_questionario_topico", referencedColumnName = "id_questionario_topico")
	private QuestionarioTopico questionarioTopico;
    @OneToMany(mappedBy="respostaTopico", cascade=CascadeType.ALL, targetEntity=RespostaQuestao.class)
	private List<RespostaQuestao> respostaQuestoes = new ArrayList<RespostaQuestao>();
    
	public RespostaTopico() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AvaliacaoAluno getAvaliacaoAluno() {
		return avaliacaoAluno;
	}
	public void setAvaliacaoAluno(AvaliacaoAluno avaliacaoAluno) {
		this.avaliacaoAluno = avaliacaoAluno;
	}
	public QuestionarioTopico getQuestionarioTopico() {
		return questionarioTopico;
	}
	public void setQuestionarioTopico(
			QuestionarioTopico questionarioTopico) {
		this.questionarioTopico = questionarioTopico;
	}
	public List<RespostaQuestao> getRespostaQuestoes() {
		return respostaQuestoes;
	}
	public void setRespostaQuestoes(List<RespostaQuestao> respostaQuestoes) {
		this.respostaQuestoes = respostaQuestoes;
	}
	public void adicionaRespostaQuestao(RespostaQuestao respostaQuestao){
		this.respostaQuestoes.add(respostaQuestao);
	}
}
