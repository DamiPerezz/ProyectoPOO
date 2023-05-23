package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewTablero;

public class ControlTablero implements ActionListener{
	
	ViewTablero ventana;
	Tablero t = new Tablero();
	String palabraCorrecta;
	
	public ControlTablero (ViewTablero win) {
		ventana = win;
		
	}

	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == ventana.boton) {
			String input = JOptionPane.showInputDialog("Introduce palabra");
			
		}
		
	}
}

