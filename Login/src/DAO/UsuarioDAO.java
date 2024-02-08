package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import DTO.UsuarioDTO;

public class UsuarioDAO {
	Connection conn;
	
	public ResultSet autentificacaoUsuario(UsuarioDTO usuarioDTO) {
		
		conn = new ConectarDAO().conectaBD();
		
		try {
			String sql= "select * from usuarios where usuario= ? and senha=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuarioDTO.getNome_usuario());
			pstm.setString(2, usuarioDTO.getSenha_usuario());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro UsuarioDAO"+ e);
			return null;
		}
		
	}
}
