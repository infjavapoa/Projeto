package br.edu.infnet.projeto.ejb.questionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
@Table(name="questionario_topico_questao")
public class QuestionarioTopicoQuestao extends BaseEntity<Long> {
	private static final long serialVersionUID = 6365086666794727846L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questionario_topico_questao")
	private Long id;
    @ManyToOne
    @JoinColumn(name = "id_questao", referencedColumnName = "id_questao")
	private Questao questao;
    @ManyToOne
    @JoinColumn(name = "id_questionario_topico", referencedColumnName = "id_questionario_topico")    
	private QuestionarioTopico questionarioTopico;
    private Integer ordem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	public QuestionarioTopico getQuestionarioTopico() {
		return questionarioTopico;
	}
	public void setQuestionarioTopico(QuestionarioTopico questionarioTopico) {
		this.questionarioTopico = questionarioTopico;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
}