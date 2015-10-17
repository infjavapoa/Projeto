package br.edu.infnet.projeto.ejb.questao;

import java.io.Serializable;

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

import br.edu.infnet.projeto.ejb.topico.Topico;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_questao", discriminatorType=DiscriminatorType.STRING)
public abstract class Questao implements Serializable {
	private static final long serialVersionUID = -956748118567401811L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_questao")
	private Long id;
	private String texto;
	@Column(name = "tipo_questao", insertable = false, updatable = false)
    private String tipoQuestao;
	@ManyToOne(optional=false)
    @JoinColumn(name="id_topico",referencedColumnName="id_topico")
	private Topico topico;
	
	public Questao() {
		super();
		topico = new Topico();
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Topico getTopico() {
		return topico;
	}
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
}
