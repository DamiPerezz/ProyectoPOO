package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.*;
import View.ErrorFrame;
import View.VentanaEstadisticas;
import View.ViewTablero;

public class ControlTablero implements ActionListener {
	
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
	public void ActualizarTablero(int contadorPrograma, String palabraUser) throws Excepcioness {
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
				ventana.valores[contadorPrograma][i].setText(String.valueOf(letras[i]).toUpperCase());
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
			//ventana.noLetras.setVisible(true);
			String mensajeError = "La palabra tiene que tener 5 digitos";
	        new ErrorFrame(mensajeError).setVisible(true);
	        throw new Excepcioness(mensajeError);

//			Prompt de longitud incorrecta
		}
		//Le pasa la palabra y el PC
		//Dependiendo del PC cambia los valores de los JLabels asociados 
		
		ComprobarFinDePartida(palabraUser);
		
		
	}
	public void ComprobarFinDePartida(String palabraUser) {
		
		if(partida.getContadorIntentos()>4) {
			if(t.comprobarPalabra(palabraUser,partida.getPalabraCorrecta()).equals("xxxxx")) {
				ventana.pantallaFinalG.setVisible(true);
				
			}
			else {
				partida.hasPerdido();
				ventana.setmensajeFinalPerder(partida.getPalabraCorrecta());
				ventana.pantallaFinalP.setVisible(true);
			}
			
			
		}
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		
		if(e.getSource() == ventana.boton) {
			String input = JOptionPane.showInputDialog("Introduce palabra");
			try {
				ActualizarTablero(partida.getContadorIntentos(), input.toLowerCase());
			} catch (Excepcioness ec) {
				ec.printStackTrace();
			}
		}
		if(e.getSource() == ventana.estadisticas) {
			
			VentanaEstadisticas statsWindow = new VentanaEstadisticas();
			ControladorEstadisticas statsControl = new ControladorEstadisticas(statsWindow);
			statsWindow.setControlador(statsControl);
			statsWindow.Iniciar();
			
		}
			
		if(e.getSource() == ventana.salir) {
			System.exit(0);
		}
		if(e.getSource() == ventana.guardarPartida) {
			partida.GuardarPartidaEnFichero('I');
			System.exit(0);
		}
		
	}
}

