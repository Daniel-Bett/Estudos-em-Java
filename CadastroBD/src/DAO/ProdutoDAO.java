package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.ProdutoDTO;

public class ProdutoDAO {
	Connection conn;
	PreparedStatement pstm;
	public void cadastrarDAO(ProdutoDTO produto) {
		
		conn = new ConexaoDAO().conectarBD();
		
		try {
			String comando = "Insert into produtos (nome, fornecedor, quantidade, preco) values (?,?,?,?)";
			
			pstm = conn.prepareStatement(comando);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getFornecedor());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setDouble(4, produto.getPreco());
			
			pstm.execute();
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ProdutoDAO "+e);
			
		}
		
		
	}
}
