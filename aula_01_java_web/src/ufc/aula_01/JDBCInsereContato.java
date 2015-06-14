package ufc.aula_01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsereContato {

	public void inserir(Contato contato){
		
		//criando a conexão
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		
		//construindo o SQL de inserção
		String sql = "INSERT INTO contatos " +
				"(nome,endereco,nascimento,celular) " +
				"values (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			
			Date date = new Date(contato.getNascimento().getTime());
			stmt.setDate(3, date);
			stmt.setString(4, contato.getCelular());
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("contato inserido!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}





