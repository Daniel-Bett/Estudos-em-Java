package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class ConectarDAO {
	
	public Connection conectaBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/bancoteste?autoReconnect=true&useSSL=false&user=root&password=";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "conectarDAO" + erro);
		}
		
		
		
		
		return conn;
		
	}
}
