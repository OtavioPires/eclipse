package br.ufc.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.ufc.model.Contato;

@Repository
public class ContatoDAO {

	private Connection conn;

	@Autowired
	public ContatoDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserir(Contato contato) {
		

		// construindo o SQL de inserção
		String sql = "INSERT INTO contatos "
				+ "(nome,endereco,nascimento,celular) "
				+ "values (?,?,?,?)";
		try {
			//preparando o statement, para evitar SQL injection
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());

			//transformando as datas (util->sql)
			Date date = new Date(contato.getNascimento().getTime());
			stmt.setDate(3, date);
			stmt.setString(4, contato.getCelular());

			//executando o sql e fechando as conexões
			stmt.execute();
			stmt.close();
			System.out.println("contato inserido!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void atualizar(Contato contato) {

		
		
		String sql = "UPDATE contatos SET nome = ?," +
					 "endereco = ?, nascimento = ?, celular = ? " +
					 "WHERE id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());

			//transformando as datas (util->sql)
			Date date = new Date(contato.getNascimento().getTime());
			stmt.setDate(3, date);
			stmt.setString(4, contato.getCelular());
			
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			System.out.println("contato atualizado!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "SELECT id,nome,endereco,nascimento,celular" +
				" FROM contatos";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				Contato c = new Contato();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setEndereco(rs.getString(3));
				c.setNascimento(rs.getDate(4));
				c.setCelular(rs.getString(5));
				contatos.add(c);
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return contatos;
	}

	public void excluir(Contato contato) {

		
		String sql = "DELETE FROM contatos WHERE id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Contato get(Contato contato){
		Contato c = null;
		
		String sql = "SELECT * FROM contatos WHERE id=?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				c = new Contato();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setEndereco(rs.getString(3));
				c.setNascimento(rs.getDate(4));
				c.setCelular(rs.getString(5));
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return c;
	}
	
	
}









