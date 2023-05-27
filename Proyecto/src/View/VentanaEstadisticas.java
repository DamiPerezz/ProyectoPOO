package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Control.ControladorEstadisticas;

public class VentanaEstadisticas extends JFrame {

	private ControladorEstadisticas controlador;
	private JLabel jugadorMasJugon; 
	private JFrame marco;
	
	
	public ControladorEstadisticas getControlador() {
		return controlador;
	}
	public void setControlador(ControladorEstadisticas controlador) {
		this.controlador = controlador;
	}
	public void Iniciar() {
		
		marco = new JFrame("Estadisticas");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setSize(300, 200);
		
		jugadorMasJugon = new JLabel("Jugador mas Jugón -->	 " + controlador.getStats().getJugadorMasJugon().getNombre() + " " +  controlador.getStats().getJugadorMasJugon().getPartidasJugadas());
		
		marco.add(jugadorMasJugon);
		marco.setVisible(true);
		
		
		
		
		
		
	}
	
	
}
