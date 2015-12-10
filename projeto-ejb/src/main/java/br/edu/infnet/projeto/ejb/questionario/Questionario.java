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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
@NamedQueries({
@NamedQuery(name="Questionario.pesquisarPorTopico" , 
			query="SELECT q FROM Questionario q, QuestionarioTopico qt "
				+ "WHERE qt MEMBER OF q.questionarioTopicos "
				+ "AND qt.topico.id = :id"),
@NamedQuery(name="Questionario.pesquisarPorQuestao" , 
			query="SELECT q FROM Questionario q, QuestionarioTopico qt, QuestionarioTopicoQuestao qtq "
				+ "WHERE qt MEMBER OF q.questionarioTopicos "
				+ "AND qtq MEMBER OF qt.questionarioTopicoQuestoes "
				+ "AND qtq.questao.id = :id"),
@NamedQuery(name="Questionario.pesquisarPorNome" , query="SELECT q FROM Questionario q WHERE q.nome LIKE :nome")
})
public class Questionario extends BaseEntity<Long> {
	private static final long serialVersionUID = 8291323679754678858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questionario")
	private Long id;
	private String nome;
	@OneToMany(mappedBy="questionario", orphanRemoval=true, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("ordem")  
	private List<QuestionarioTopico> questionarioTopicos = new ArrayList<QuestionarioTopico>();
	@OneToMany(mappedBy="questionario", targetEntity=Avaliacao.class)
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
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
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
}
