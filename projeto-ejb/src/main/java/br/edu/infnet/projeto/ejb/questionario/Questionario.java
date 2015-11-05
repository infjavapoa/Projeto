package br.edu.infnet.projeto.ejb.questionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Questionario extends BaseEntity<Long> {
	private static final long serialVersionUID = 8291323679754678858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questionario")
	private Long id;
	private String nome;
	@OneToMany(mappedBy="questionario", orphanRemoval=true, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<QuestionarioTopico> questionarioTopicos = new ArrayList<QuestionarioTopico>();

	public Questionario() {
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
	public List<QuestionarioTopico> getQuestionarioTopicos() {
		return questionarioTopicos;
	}
	public void setgetQuestionarioTopicos(List<QuestionarioTopico> questionarioTopicos) {
		this.questionarioTopicos = questionarioTopicos;
	}
	public void adicionaQuestionarioTopico(Topico topico){
		QuestionarioTopico qt = new QuestionarioTopico();
		qt.setTopico(topico);
		qt.setQuestionario(this);
		qt.setOrdem(questionarioTopicos.size()+1);
		this.questionarioTopicos.add(qt);
	}
	public void removeQuestionarioTopico(QuestionarioTopico qt){
		this.questionarioTopicos.remove(qt);
	}
}
