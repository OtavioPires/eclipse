package br.ufc.model;


import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

public class Contato {

	private Long id;
	@NotNull @Size(min=10)
	private String nome;
	private String endereco;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date nascimento;
	private String celular;
	
	public Contato() {
		
	}
	public Contato(String nome, String endereco, 
					Date data, String celular) {

		this.nome = nome;
		this.endereco = endereco;
		this.nascimento = data;
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
	public void setNascimento(Date data) {
		this.nascimento = data;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", data=" + nascimento + ", celular=" + celular + "]";
	}
	
	
	
}
