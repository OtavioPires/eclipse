package br.java_web;


import java.util.Date;

public class JDBCExemplo {
	
	public static void main(String[] args) {
		Date d = new Date();
		Contato c = new Contato("Otavio", "Av Abolicao", d, "9840 1699");
		InserirContatoJDBC inserir = new InserirContatoJDBC();
		inserir.inserir(c);
	}
}
