package br.ufc;

import java.util.Date;

public class Aluno {

	private Long id;
	private String matricula;
	private String nome;
	private Date nascimento;
	private String email;
	
	public Aluno() {
		
	}
	
	public Aluno(String matricula, String nome, Date nascimento,
			String email) {

		this.matricula = matricula;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", nome="
				+ nome + ", nascimento=" + nascimento + ", email=" + email
				+ "]";
	}
	
}

