package br.edu.infnet.model.domain;

public class Usuario {
	private String nome; 
	private String email; 
	private String senha;
	
	public Usuario(String nome,String email ) {
		this.nome = nome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		return String.format("Usu�rio: %s Email: %s Senha: %s \n",
				nome, email, senha);
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
