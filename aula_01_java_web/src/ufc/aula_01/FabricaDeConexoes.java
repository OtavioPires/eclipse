package ufc.aula_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	
	public Connection getConexao(){
		String url = "jdbc:mysql://200.129.39.250/java_web";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("conectado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
