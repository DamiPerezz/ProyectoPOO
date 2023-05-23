package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewTablero;

public class ControlTablero implements ActionListener{
	
	ViewTablero ventana;
	String palabraCorrecta;
	private Tablero t;
	
	public ControlTablero (ViewTablero win) {
		ventana = win;
		
	}
	//Metodo que actualiza el tablero con la linea que esta jungando (la primero se cuenta como 0) 
	//Y con la palabraUser de 5 palabras
	public void ActualizarTablero(int contadorPrograma, String palabraUser) {
//		Comprueba que la palabra sea correcta
//		
		if (palabraUser.length()==5) {
			//Convertirmo el String a char
			char[] letras = new char[5];	
			for(int i=0;i<palabraUser.length();i++) {
				letras[i]=palabraUser.charAt(i);
			}
			for(int i=0;i<palabraUser.length();i++) {
				ventana.valores[contadorPrograma][i].setText(String.valueOf(letras[i]));
			}
		}
		else {
//			
//			Prompt de longitud incorrecta
		}
		//Le pasa la palabra y el PC
		//Dependiendo del PC cambia los valores de los JLabels asociados 
		
		
		
		
	}
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == ventana.boton) {
			String input = JOptionPane.showInputDialog("Introduce palabra");
			ActualizarTablero(t.getContadorIntentos(), input);
			
		}
		
	
		
	}
}

