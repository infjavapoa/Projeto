package br.edu.infnet.projeto.ejb.avaliacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.edu.infnet.projeto.ejb.core.BaseEntity;

@Entity
public class Resposta extends BaseEntity<Long> {
	private static final long serialVersionUID = -7038950037199526739L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_resposta")
	private Long id;
	
	public Resposta() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
