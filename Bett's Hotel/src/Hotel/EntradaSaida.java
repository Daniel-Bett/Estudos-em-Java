package Hotel;
import javax.swing.JOptionPane;
public class EntradaSaida {
	
	public static String solicitarTexto(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	public static int solicitarNumero(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}
	 public static void mostraTexto(String msg) {
		 JOptionPane.showMessageDialog(null, msg);	 
	 }
	 
	 public static int solicitarConfirmacao(String msg) {
		 return JOptionPane.showConfirmDialog(null, msg);
	 }
	 
	 public static double solicitarNumeroDouble(String msg) {
			return Double.parseDouble(JOptionPane.showInputDialog(msg));
		}
}
