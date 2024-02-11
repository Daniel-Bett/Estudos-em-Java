package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DAO.UsuarioDAO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclEntry;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.UsuarioDTO;

public class FrmLoginVIEW extends JFrame {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
					FrmLoginVIEW window = new FrmLoginVIEW();
					window.frame.setVisible(true);
					
			}
		} );
	}

	public FrmLoginVIEW() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 229, 196);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(10, 11, 87, 31);
		frame.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 36, 193, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(10, 61, 71, 14);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 83, 193, 20);
		frame.getContentPane().add(txtSenha);
		
		JButton btnLogin = new JButton("Entrar");
		
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				logar();
			}
			
		});
		
		btnLogin.setBounds(96, 114, 107, 31);
		frame.getContentPane().add(btnLogin);
	}
	
	
	private void logar() {
		try {
			
			String usuario, senha;
			usuario = txtUsuario.getText();
			senha = txtSenha.getText();
			
			UsuarioDTO objUser= new UsuarioDTO();
			objUser.setNome_usuario(usuario);
			objUser.setSenha_usuario(senha);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			ResultSet rsDAO = usuarioDAO.autentificacaoUsuario(objUser);
			
			if (rsDAO.next()) {
				FrmTelaPrincipalVIEW objeto = new FrmTelaPrincipalVIEW();
				objeto.frame.setVisible(true);
				
				frame.dispose();
				
			}else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
			}
			
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null,"Erro USUARIODAO:"+ e2);
		}
		
	}

}

