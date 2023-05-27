package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Estadistica;
import View.VentanaEstadisticas;

public class ControladorEstadisticas implements ActionListener{

	private VentanaEstadisticas ventana;
	private Estadistica stats;
	
	
	
	public ControladorEstadisticas(VentanaEstadisticas ventana) {
		super();
		this.ventana = ventana;
		this.stats = new Estadistica();
		
	}
	public VentanaEstadisticas getVentana() {
		return ventana;
	}
	public void setVentana(VentanaEstadisticas ventana) {
		this.ventana = ventana;
	}
	public Estadistica getStats() {
		return stats;
	}
	public void setStats(Estadistica stats) {
		this.stats = stats;
	}



	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}
