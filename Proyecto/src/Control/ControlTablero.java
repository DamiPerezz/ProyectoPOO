package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewTablero;

public class ControlTablero implements ActionListener{
	
	ViewTablero ventana;
	String palabraCorrecta;
	Partida p;
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
			//VENTANA////////////////////////////////////////////////////////////////////////////////////
			//Convertirmo el String a char
			char[] letras = new char[5];	
			for(int i=0;i<palabraUser.length();i++) {	//pasa la String palabraUser a un char[] letras
				letras[i]=palabraUser.charAt(i);
				//Incrementamos contador
				
			}
			for(int i=0;i<palabraUser.length();i++) {	//coloca cada letra en su sitio en la ventana
				ventana.valores[contadorPrograma][i].setText(String.valueOf(letras[i]));
			}
			t.guardarPalabra(palabraUser);  //manda la palabra al tablero para almacenarla
			t.incrementarContador();
			//PISTAS//////////////////////////////////////////////////////////////////////////////////////
			String pistas = t.comprobarPalabra(palabraUser,p.getPalabraCorrecta());
			for(int i=0;i<palabraUser.length();i++) {	//cambia el color de cada letra
				ventana.valores[contadorPrograma][i].setForeground(t.seleccionarColor(pistas.charAt(i)));;
			}
			
			
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

