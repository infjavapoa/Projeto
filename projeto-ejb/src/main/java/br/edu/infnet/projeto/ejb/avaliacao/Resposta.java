package br.edu.infnet.projeto.ejb.avaliacao;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopicoQuestao;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_resposta", discriminatorType=DiscriminatorType.STRING)
public abstract class Resposta extends BaseEntity<Long> {
	private static final long serialVersionUID = -7038950037199526739L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_resposta")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "id_avaliacao_aluno", referencedColumnName = "id_avaliacao_aluno")
	private AvaliacaoAluno avaliacaoAluno;
    @ManyToOne
    @JoinColumn(name = "id_questionario_topico_questao", referencedColumnName = "id_questionario_topico_questao")
	private QuestionarioTopicoQuestao questionarioTopicoQuestao;
    
	public Resposta() {
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
	public QuestionarioTopicoQuestao getQuestionarioTopicoQuestao() {
		return questionarioTopicoQuestao;
	}
	public void setQuestionarioTopicoQuestao(
			QuestionarioTopicoQuestao questionarioTopicoQuestao) {
		this.questionarioTopicoQuestao = questionarioTopicoQuestao;
	}
}
