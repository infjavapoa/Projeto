package br.edu.infnet.projeto.ejb.topico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
@Table
@NamedQuery(name="Topico.pesquisarPorTexto" , query="SELECT t FROM Topico t WHERE t.texto LIKE :texto")
public class Topico extends BaseEntity<Long> {
	private static final long serialVersionUID = 8578462006534289569L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_topico")
	private Long id;
	private String texto;
	
	public Topico() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
