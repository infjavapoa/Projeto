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
	@Column(name="assunto_msg_abertura")
	private String assuntoMsgAbertura;
	@Column(name="msg_confirmacao")
	private String msgConfirmacao;
	@Column(name="assunto_msg_confirmacao")
	private String assuntoMsgConfirmacao;
	@Column(name="tag_nome_aluno")
	private String tagNomeAluno;
	@Column(name="tag_link")
	private String tagLink;
	@Column(name="tag_data_fim")
	private String tagDataFim;
	@Column(name="tag_modulo")
	private String tagModulo;
	@Column(name="url_servidor")
	private String urlServidor;
	@Column(name="nome_aplicacao")
	private String nomeAplicacao;
	@Column(name="nome_formulario_avaliacao")
	private String nomeFormularioAvaliacao;	
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
	public String getAssuntoMsgAbertura() {
		return assuntoMsgAbertura;
	}
	public void setAssuntoMsgAbertura(String assuntoMsgAbertura) {
		this.assuntoMsgAbertura = assuntoMsgAbertura;
	}
	public String getMsgConfirmacao() {
		return msgConfirmacao;
	}
	public void setMsgConfirmacao(String msgConfirmacao) {
		this.msgConfirmacao = msgConfirmacao;
	}
	public String getAssuntoMsgConfirmacao() {
		return assuntoMsgConfirmacao;
	}
	public void setAssuntoMsgConfirmacao(String assuntoMsgConfirmacao) {
		this.assuntoMsgConfirmacao = assuntoMsgConfirmacao;
	}
	public String getTagNomeAluno() {
		return tagNomeAluno;
	}
	public void setTagNomeAluno(String tagNomeAluno) {
		this.tagNomeAluno = tagNomeAluno;
	}
	public String getTagLink() {
		return tagLink;
	}
	public void setTagLink(String tagLink) {
		this.tagLink = tagLink;
	}
	public String getTagDataFim() {
		return tagDataFim;
	}
	public void setTagDataFim(String tagDataFim) {
		this.tagDataFim = tagDataFim;
	}
	public String getTagModulo() {
		return tagModulo;
	}
	public void setTagModulo(String tagModulo) {
		this.tagModulo = tagModulo;
	}
	public String getUrlServidor() {
		return urlServidor;
	}
	public void setUrlServidor(String urlServidor) {
		this.urlServidor = urlServidor;
	}
	public String getNomeAplicacao() {
		return nomeAplicacao;
	}
	public void setNomeAplicacao(String nomeAplicacao) {
		this.nomeAplicacao = nomeAplicacao;
	}
	public String getNomeFormularioAvaliacao() {
		return nomeFormularioAvaliacao;
	}
	public void setNomeFormularioAvaliacao(String nomeFormularioAvaliacao) {
		this.nomeFormularioAvaliacao = nomeFormularioAvaliacao;
	}
	public String getDiretorioArquivoAvaliacao() {
		return diretorioArquivoAvaliacao;
	}
	public void setDiretorioArquivoAvaliacao(String diretorioArquivoAvaliacao) {
		this.diretorioArquivoAvaliacao = diretorioArquivoAvaliacao;
	}
}
