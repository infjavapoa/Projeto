package br.edu.infnet.projeto.ejb.login;

import br.edu.infnet.projeto.ejb.seguranca.CriptografiaSenha;

public class Login {
	
	private String codigo;
	private String senha;
	private String nome;
	
	public Login() {
		super();
	}
	
	public Login(String codigo, String senha, String nome) {
		super();
		this.codigo = codigo;
		this.senha = senha;
		this.nome = nome;
		System.out.println("...fazendo a mão pelo construtor de login...");
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
		System.out.println("...fazendo a mão pelo setCodigo...");
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = CriptografiaSenha.Criptografar(senha);
		System.out.println("...fazendo a mão pelo setSenha...");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.senha = CriptografiaSenha.Criptografar(nome);
		System.out.println("...fazendo a mão pelo setNome...");
	}
	

}
