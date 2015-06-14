package br.java_web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InserirContatoJDBC {

	public void inserir(Contato contato){
		//pegando a conexao com o mysql
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexaoJDBC();
		
		//codigo sql de insercao
		String sql= "INSERT INTO contatos "
				+ "(nome, endereco, nascimento, celular) " 
				+ "values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			
			//criando nove java.sql.Date
			Date d = new Date(contato.getNascimento().getTime());
			
			stmt.setDate(3, d);
			stmt.setString(4, contato.getCelular());
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Contato inserido com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
