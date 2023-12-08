import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Jogo extends JFrame {
	private static final long serialVersionUID = 1L;
	final int JOGADOR1 = 1;
	final int JOGADOR2 = 2;
	
	private int rodadas=0;
	private int jogadorVez= JOGADOR1;
	
	private ImageIcon iconCirculo = new ImageIcon(getClass().getResource("c.png"));
	private ImageIcon iconX = new ImageIcon(getClass().getResource("xx.png"));
	private JPanel pTela = new JPanel(new GridLayout(3,3,10,10));
	private JLabel lInformacao = new JLabel("Jogador "+JOGADOR1);
	private Bloco[] blocos = new Bloco[9];

	public Jogo() {
		configurarJanela();
		configurarTela();		
	}
	
	public void mudarVez() {
		if(jogadorVez==JOGADOR1) {
			setJogadorVez(JOGADOR2);
			lInformacao.setText("Jogador "+JOGADOR2);
		}else {
			setJogadorVez(JOGADOR1);
			lInformacao.setText("Jogador "+JOGADOR1);
		}
	}
	
	public void configurarJanela() {
		setTitle("Jogo da velha do Bett");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void configurarTela() {
		add(BorderLayout.CENTER,pTela);
		add(BorderLayout.NORTH,lInformacao);
		pTela.setBackground(Color.DARK_GRAY);
		lInformacao.setFont(new Font("Arial",Font.BOLD,30));
		lInformacao.setForeground(new Color(0,0,0));
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i =0;i<9;i++) {
			Bloco bloco = new Bloco();
			blocos[i]=bloco;
			pTela.add(bloco);
			
		}
	}
	
	public class Bloco extends JButton{

		private static final long serialVersionUID = 1L;
		int quem =0;
		public Bloco() {
			setBackground(Color.GRAY);
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(quem == 0) {
						if(jogadorVez==JOGADOR1) {
							setIcon(iconX);
							quem = JOGADOR1;
						}else {
							setIcon(iconCirculo);
							quem = JOGADOR2;
						}
						if(testarVitoria(jogadorVez)) {
							JOptionPane.showMessageDialog(null, "Parabens jogador"+jogadorVez);
							System.exit(0);
						}
						setRodadas(rodadas+1);
						mudarVez();
						if(rodadas==9) {
							JOptionPane.showMessageDialog(null, "IIIIIHHH, deu velha");
							System.exit(0);
						}
					}
				}
			});
		}
	}
	
	public void setRodadas(int rodadas) {
		this.rodadas=rodadas;
	}
	public void setJogadorVez(int jogadorVez) {
		this.jogadorVez = jogadorVez;
	}
	public boolean testarVitoria(int player) {
		if(blocos[0].quem==player && blocos[1].quem==player && blocos[2].quem==player) {
			return true;
		}
		if(blocos[3].quem==player && blocos[4].quem==player && blocos[5].quem==player) {
			return true;
		}
		if(blocos[6].quem==player && blocos[7].quem==player && blocos[8].quem==player) {
			return true;
		}
		if(blocos[0].quem==player && blocos[4].quem==player && blocos[8].quem==player) {
			return true;
		}
		if(blocos[2].quem==player && blocos[4].quem==player && blocos[6].quem==player) {
			return true;
		}
		if(blocos[0].quem==player && blocos[1].quem==player && blocos[2].quem==player) {
			return true;
		}
		if(blocos[0].quem==player && blocos[3].quem==player && blocos[6].quem==player) {
			return true;
		}
		if(blocos[1].quem==player && blocos[4].quem==player && blocos[7].quem==player) {
			return true;
		}
		if(blocos[2].quem==player && blocos[5].quem==player && blocos[8].quem==player) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		new Jogo();
	}

}
