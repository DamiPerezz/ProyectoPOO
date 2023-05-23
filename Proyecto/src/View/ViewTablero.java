package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ViewTablero extends JFrame {
	
	public JFrame marco;
	
	public static void main(String [] args) {
		
		ViewTablero m = new ViewTablero();
		
	}
	
	public ViewTablero() {
		
		IniciarVentana();
		
	}
	
	public  void IniciarVentana() {
		
		marco = new JFrame();
		marco.setSize(450,700);
		
		JPanel panel= new JPanel();
		panel.setSize(300,300);
		marco.add(panel);
		panel.setVisible(true);
		
		char[][] ArrayTablero = new char[5][5];
		
		
		
		JTable tablero =new JTable();
		panel.add(tablero);
		tablero.setVisible(true);
		
		marco.setVisible(true);
	}
	
}
