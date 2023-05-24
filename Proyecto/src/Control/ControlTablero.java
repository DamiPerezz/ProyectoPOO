package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ViewTablero;

public class ControlTablero implements ActionListener{
	
	private ViewTablero ventana;
	
//	public void setP(Partida p) {
//		this.p = p;
//	}

	private String palabraCorrecta;
	public Partida partida;
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
			partida.guardarPalabra(palabraUser);  //manda la palabra al tablero para almacenarla
			partida.incrementarContador();
			//PISTAS//////////////////////////////////////////////////////////////////////////////////////
			String pistas = t.comprobarPalabra(palabraUser,partida.getPalabraCorrecta());
			for(int i=0;i<palabraUser.length();i++) {	//cambia el color de cada letra
				ventana.valores[contadorPrograma][i].setForeground(t.seleccionarColor(pistas.charAt(i)));;
			}
			if(pistas.equals("xxxxx")){
				
				partida.hasGanado();
			}
			
		}
		else {
			System.out.print("Error: Se ha introducido una palabra que no tiene 5 dígitos :(");
//			Prompt de longitud incorrecta
		}
		//Le pasa la palabra y el PC
		//Dependiendo del PC cambia los valores de los JLabels asociados 
		
		ComprobarFinDePartida();
		
		
	}
	public void ComprobarFinDePartida() {
		
		if(partida.getContadorIntentos()>4) {
			ventana.pantallaFinal.setVisible(true);
			
		}
		
	}
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == ventana.boton) {
			String input = JOptionPane.showInputDialog("Introduce palabra");
			ActualizarTablero(partida.getContadorIntentos(), input);
			
			
			
		}
		if(e.getSource() == ventana.salir) {
			System.exit(0);
		}
		if(e.getSource() == ventana.guardarPartida) {
			System.exit(0);
		}
		
	}
}

