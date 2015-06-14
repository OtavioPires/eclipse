package br.ufc.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	
	public Connection getConexao(){
		String url = "jdbc:mysql://localhost/java_web";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("conectado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
