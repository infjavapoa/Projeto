package br.edu.infnet.projeto.ejb.questionario;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_questao", discriminatorType=DiscriminatorType.STRING)
@NamedQuery(name="Questao.pesquisarPorTexto" , query="SELECT q FROM Questao q WHERE q.texto LIKE :texto")
public abstract class Questao extends BaseEntity<Long> {
	private static final long serialVersionUID = 8291323679754678858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questao")
	private Long id;
	private String texto;
	@Column(name = "tipo_questao", insertable = false, updatable = false)
    private String tipoQuestao="O";
	
	public Questao() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoQuestao() {
		return tipoQuestao;
	}
	public void setTipoQuestao(String tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
