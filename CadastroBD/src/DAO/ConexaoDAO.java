package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection conectarBD() {
		Connection conn = null;
		
		try {
			String urlSql = "jdbc:mysql://localhost:3306/bancoteste?autoReconnect=true&useSSL=false&user=root&password=";
			conn = DriverManager.getConnection(urlSql);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro conexaoDAO "+e);
		}
		
		return conn;
	}
	
	
}
