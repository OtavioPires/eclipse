package br.java_web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	
	public Connection getConexaoJDBC(){
		
		String url = "jdbc:mysql://200.129.39.252/java_web";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("conectado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	
	}
}
