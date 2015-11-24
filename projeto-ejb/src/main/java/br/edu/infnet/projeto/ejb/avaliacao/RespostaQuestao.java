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
import javax.persistence.Table;

import br.edu.infnet.projeto.ejb.core.BaseEntity;
import br.edu.infnet.projeto.ejb.questionario.QuestionarioTopicoQuestao;

@Entity
@Table(name="resposta_questao")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_resposta", discriminatorType=DiscriminatorType.STRING)
public abstract class RespostaQuestao extends BaseEntity<Long> {
	private static final long serialVersionUID = -7038950037199526739L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_resposta_questao")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "id_resposta_topico", referencedColumnName = "id_resposta_topico")
	private RespostaTopico respostaTopico;
    @ManyToOne
    @JoinColumn(name = "id_questionario_topico_questao", referencedColumnName = "id_questionario_topico_questao")
	private QuestionarioTopicoQuestao questionarioTopicoQuestao;
    
	public RespostaQuestao() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RespostaTopico getRespostaTopico() {
		return respostaTopico;
	}
	public void setRespostaTopico(RespostaTopico respostaTopico) {
		this.respostaTopico = respostaTopico;
	}
	public QuestionarioTopicoQuestao getQuestionarioTopicoQuestao() {
		return questionarioTopicoQuestao;
	}
	public void setQuestionarioTopicoQuestao(
			QuestionarioTopicoQuestao questionarioTopicoQuestao) {
		this.questionarioTopicoQuestao = questionarioTopicoQuestao;
	}
}
