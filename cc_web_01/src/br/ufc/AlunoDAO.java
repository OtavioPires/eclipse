package br.ufc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
	
	private FabricaDeConexoes fc;
	
	public AlunoDAO() {
		fc = new FabricaDeConexoes();
		
	}

	public void inserir(Aluno aluno) {
		//criando a conexao
		Connection conn = fc.getConexao();
		
		//SQL de insercao
		String sql = "INSERT INTO alunos"
				+ "(matricula,nome,nascimento,email)"
				+ "values (?,?,?,?)";
		
		//prepared statement evita sql injection
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			
			//transformando data de util para sql
			Date date = new Date(aluno.getNascimento().getTime());
			stmt.setDate(3, date);
			
			stmt.setString(4, aluno.getEmail());
			
			//executando o sql e fechando as conexoes
			stmt.execute();
			stmt.close();
			conn.close();
			
			System.out.println("Contato inserido!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Aluno> listar() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = this.fc.getConexao();
		String sql = "SELECT * FROM alunos";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Aluno a = new Aluno();
				a.setId(rs.getLong(1));
				a.setMatricula(rs.getString(2));
				a.setNome(rs.getString(3));
				a.setNascimento(rs.getDate(4));
				a.setEmail(rs.getString(5));
				alunos.add(a);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	
}
