package br.java_web;

import java.util.Date;

public class Contato {
	
	private Long id;
	private String nome;
	private String endereco;
	private Date nascimento;
	private String celular;
	
	public Contato(){
		
	}
		
	public Contato(String nome, String endereco, Date nascimento,
			String celular) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.nascimento = nascimento;
		this.celular = celular;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", nascimento=" + nascimento + ", celular="
				+ celular + "]";
	}
	
}
