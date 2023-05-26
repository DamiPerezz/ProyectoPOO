package View;

import javax.swing.*;

import Control.ControlVentanaInicio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame{
	
	public ControlVentanaInicio controlador;
	public JButton crearpartidaButton;
	public JButton cargarPartidaButton;
	public JButton salirButton;

    
    public JButton getSalirButton() {
		return salirButton;
	}

	public void setSalirButton(JButton salirButton) {
		this.salirButton = salirButton;
	}

	public void Iniciar() {
	    // Crear la ventana
	    JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300, 675);

	    // Crea el panel
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout());
	    frame.getContentPane().add(panel);

	    JLabel textoBienvenida = new JLabel("Bienvenido a Wordle!");
	    textoBienvenida.setPreferredSize(new Dimension(150, 100));

	    // Crea los botones
	    crearpartidaButton = new JButton("Crear Partida");
	    crearpartidaButton.setPreferredSize(new Dimension(150, 150));
	    crearpartidaButton.addActionListener(controlador);

	    cargarPartidaButton = new JButton("Cargar Partida");
	    cargarPartidaButton.setPreferredSize(new Dimension(150, 150));
	    cargarPartidaButton.addActionListener(controlador);

	    salirButton = new JButton("Salir");
	    salirButton.setPreferredSize(new Dimension(150, 150));
	    salirButton.addActionListener(controlador);

	    // Añadir funcionalidad a los botones

	    // Añade los botones al panel
	    panel.add(textoBienvenida);
	    panel.add(crearpartidaButton, FlowLayout.CENTER);
	    panel.add(cargarPartidaButton, FlowLayout.CENTER);
	    panel.add(salirButton, FlowLayout.LEADING);

	    // Muestra la ventana
	    frame.setVisible(true);
	}


	public JButton getCargarPartidaButton() {
		return this.cargarPartidaButton;
	}

	public void setCargarPartidaButton(JButton cargarPartidaButton) {
		this.cargarPartidaButton = cargarPartidaButton;
	}

	public JButton getCrearpartidaButton() {
		return crearpartidaButton;
	}

	public void setCrearpartidaButton(JButton crearpartidaButton) {
		this.crearpartidaButton = crearpartidaButton;
	}
}



