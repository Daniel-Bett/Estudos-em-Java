package VIEW;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.ProdutoDAO;
import DTO.ProdutoDTO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaCadastro {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtFornecedor;
	private JTextField txtQuantidade;
	private JTextField txtPreco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaCadastro() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nomeProduto = new JLabel("Nome do Produto:");
		nomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeProduto.setBounds(10, 11, 117, 14);
		frame.getContentPane().add(nomeProduto);
		
		JLabel fornecedor = new JLabel("Nome do Fornecedor:");
		fornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fornecedor.setBounds(10, 63, 131, 14);
		frame.getContentPane().add(fornecedor);
		
		JLabel quantidade = new JLabel("Quantidade:");
		quantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		quantidade.setBounds(10, 112, 101, 14);
		frame.getContentPane().add(quantidade);
		
		JLabel preco = new JLabel("Preço:");
		preco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		preco.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(preco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(50, 227, 123, 23);
		frame.getContentPane().add(btnCadastrar);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 36, 215, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setBounds(10, 88, 215, 20);
		frame.getContentPane().add(txtFornecedor);
		txtFornecedor.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(10, 137, 215, 20);
		frame.getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(10, 182, 215, 20);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
	}
	
	private void cadastrar() {
		try {
			String nome, fornecedor;
			int quantidade;
			double preco;
			
			nome = txtNome.getText();
			fornecedor = txtFornecedor.getText();
			quantidade = Integer.parseInt(txtQuantidade.getText());
			preco = Double.parseDouble(txtPreco.getText());
			
			ProdutoDTO produtoDto = new ProdutoDTO();
			
			produtoDto.setFornecedor(fornecedor);
			produtoDto.setNome(nome);
			produtoDto.setPreco(preco);
			produtoDto.setQuantidade(quantidade);
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.cadastrarDAO(produtoDto);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERRO:"+ e);
		}
	}
}
