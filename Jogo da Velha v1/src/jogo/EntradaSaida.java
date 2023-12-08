package jogo;
import javax.swing.JOptionPane;

public class EntradaSaida {
	
	public static int solicitaInteiro(String msg){
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}
	
	public static String solicitarString(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	public static void mostraTexto(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}