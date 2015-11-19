package br.edu.infnet.projeto.ejb.parametros;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_param")
	private Long id;
	@Column(name="msg_abertura")
	private String msgAbertura;
	@Column(name="msg_confirma_email")
	private String msgConfirmacao;
	@Column(name="dir_arq_avaliacao")
	private String diretorioArquivoAvaliacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsgAbertura() {
		return msgAbertura;
	}
	public void setMsgAbertura(String msgAbertura) {
		this.msgAbertura = msgAbertura;
	}
	public String getMsgConfirmacao() {
		return msgConfirmacao;
	}
	public void setMsgConfirmacao(String msgConfirmacao) {
		this.msgConfirmacao = msgConfirmacao;
	}
	public String getDiretorioArquivoAvaliacao() {
		return diretorioArquivoAvaliacao;
	}
	public void setDiretorioArquivoAvaliacao(String diretorioArquivoAvaliacao) {
		this.diretorioArquivoAvaliacao = diretorioArquivoAvaliacao;
	}
}
