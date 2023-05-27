package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Control.ControladorEstadisticas;

public class VentanaEstadisticas extends JFrame {

	private ControladorEstadisticas controlador;
	private JLabel jugadorMasJugon; 
	private JLabel jugadorMayorAdivinacion;
	private JLabel jugadorMenorAdivinacion;
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
		marco.setSize(450, 200);
		
		
		//JUGADOR CON MAYOR NUMERO DE PARTIDAS JUGADAS
		jugadorMasJugon = new JLabel("  Jugador mas Jugón -->	 " + controlador.getStats().getJugadorMasJugon().getNombre() + " , " + "Partidas Jugadas: " + controlador.getStats().getJugadorMasJugon().getPartidasJugadas());
		
		marco.add(jugadorMasJugon, BorderLayout.NORTH); 
		//marco.add(jugadorMasJugon);
		marco.setVisible(true);
		
		
		//JUGADOR CON MAYOR % DE ADIVINACION
		jugadorMayorAdivinacion= new JLabel ("  Jugador con Mayor Porcentaje de Adivinación -->    " + controlador.getStats().JugadorMasAdivinacion().getNombre() + " , " + "Porcentaje: " + controlador.getStats().getPorcentajeMayorUsu()+ "%");
		
		marco.add(jugadorMayorAdivinacion, BorderLayout.CENTER); 
		//marco.add(jugadorMayorAdivinacion);
		marco.setVisible(true);
		
		//JUGADOR CON MENOR % DE ADIVINACION
		//int porcentaje = controlador.getStats().JugadorMenorAdivinacion();

		jugadorMenorAdivinacion= new JLabel ("  Jugador con Menor Porcentaje de Adivinación -->    " + controlador.getStats().JugadorMenorAdivinacion().getNombre() + " , " +  "Porcentaje: " + controlador.getStats().getPorcentajeMenorUsu()+ "%");
		
		marco.add(jugadorMenorAdivinacion, BorderLayout.WEST); 
		//marco.add(jugadorMayorAdivinacion);
		marco.setVisible(true);
	
		
	}
	
	
}
