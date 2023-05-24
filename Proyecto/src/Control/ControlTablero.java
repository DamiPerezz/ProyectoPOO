package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewTablero;

public class ControlTablero implements ActionListener{
	
	ViewTablero ventana;
	String palabraCorrecta;
	private Tablero t = new Tablero();
	
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
				//Incrementamos contador
				
			}
			for(int i=0;i<palabraUser.length();i++) {
				ventana.valores[contadorPrograma][i].setText(String.valueOf(letras[i]));
			}
			t.incrementarContador();
		}
		else {
			System.out.print("Error: Se ha introducido una palabra que no tiene 5 dígitos :(");
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
		if(e.getSource() == ventana.salir) {
			System.exit(0);
		}
		if(e.getSource() == ventana.guardarPartida) {
			System.exit(0);
		}
		
	}
}

