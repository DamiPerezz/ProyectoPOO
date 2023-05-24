package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Partida;
import Model.Usuario;
import View.PantallaInicio;

public class ControlVentanaInicio implements ActionListener {

	private PantallaInicio ventana; 
	
	
	
	public ControlVentanaInicio(PantallaInicio ventana) {
		super();
		this.ventana = ventana;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ventana.cargarPartidaButton) {
			
			
		}
		if(e.getSource()==ventana.crearpartidaButton) {
			 String nombre = JOptionPane.showInputDialog("Introduce tu Nombre:");
			 if(nombre == "" || nombre == " " ||nombre == null) {
				 System.exit(0);
			 }
			 Usuario user = new Usuario(nombre);
			 Partida partida1 = new Partida(user); 
			 
		}
		if(e.getSource()==ventana.salirButton) {
			 System.exit(0);
		}
		
		
	}
	
}
