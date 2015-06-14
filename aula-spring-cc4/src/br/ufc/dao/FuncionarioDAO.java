package br.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.ufc.model.Funcionario;

@Repository
public class FuncionarioDAO {

	private Connection conn;
	
	@Autowired
	public FuncionarioDAO(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Funcionario getFuncionarioByLogin(Funcionario f){
	
		
		String sql = "SELECT id,nome,login,senha" +
					" FROM funcionarios " +
					" WHERE login LIKE ?";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, f.getLogin());
			f = null;
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				f = new Funcionario();
				f.setId(rs.getLong(1));
				f.setNome(rs.getString(2));
				f.setLogin(rs.getString(3));
				f.setSenha(rs.getString(4));
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return f;
	}
}
