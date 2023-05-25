package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

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
			Usuario user = new Usuario (CargarUsuario());
			Partida partida = CargarPartida();
			partida.setUser(user);
			System.out.println("Probando, probando");
		}
		
		
		
		
		if(e.getSource()==ventana.crearpartidaButton) {
			 String nombre = JOptionPane.showInputDialog("Introduce tu Nombre:");
			 if(nombre == "" || nombre == " " ||nombre == null) {
				 System.exit(0);
			 }
			 Usuario user1 = new Usuario(nombre);
			 Partida partida1 = new Partida(user1); 
			 
		}
		if(e.getSource()==ventana.salirButton) {
			 System.exit(0);
		}
		
		
	}
	public Partida CargarPartida() {
		File fichero = new File("../resgistroPartidas.txt");
		String ultimaPartida = "";
		try {
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				ultimaPartida = sc.nextLine();
			}
					
		}catch(Exception ex) {
			ex.getMessage();
		}
		//2;fenix;Paco;4;A
		String[] variables = ultimaPartida.split(";");
		//CODIGO PARTIDA
		char cod = variables[0].charAt(0);
		int codPartida = Character.getNumericValue(cod);
		//PALABRA CORRECTA
		String palabraCorrecta = variables[1];
		//NOMBRE USUARIO
		String usuario = variables[2];
		
		char intentos = variables[3].charAt(0);
		int contadorIntentos = Character.getNumericValue(cod);
		char estado = variables[4].charAt(0);
		int numIndex=0;
		for(int i=5;i<variables.length;i++) {
			numIndex++;
		}
		String[] palabraTablero = new String [numIndex];
		for(int i=0;i<numIndex;i++) {
			palabraTablero[i] = variables[4+numIndex];
		}
		
//		String[] palabraTablero= new String[5];
//		for(int i=5;i<9;i++) {
//			for (int j=0;j<4;j++) {
//				palabraTablero[j] = variables[i];
//			}
//		}
		Usuario u = new Usuario (usuario);
		
		Partida p = new Partida (u, palabraCorrecta,codPartida);
		
		p.setArrayTablero(palabraTablero);
		p.setContadorIntentos(contadorIntentos);
		p.setArrayTablero(palabraTablero);
		
		
		return p;
		
	}
	public String CargarUsuario() {
		File fichero = new File("../resgistroPartidas.txt");
		String ultimaPartida = "";
		try {
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				ultimaPartida = sc.nextLine();
			}
					
		}catch(Exception ex) {
			ex.getMessage();
		}
		//2;fenix;Paco;4;A
		String[] variables = ultimaPartida.split(";");
		//CODIGO PARTIDA
		char cod = variables[0].charAt(0);
		int codPartida = Character.getNumericValue(cod);
		//PALABRA CORRECTA
		String palabraCorrecta = variables[1];
		//NOMBRE USUARIO
		String usuario = variables[2];
		
		
	
		return usuario;
		
	}
}
