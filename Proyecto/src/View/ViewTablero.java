package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.ControlTablero;

public class ViewTablero extends JFrame {
	
	public JFrame marco;
	public JTable tablero;
	public JButton boton;
	public JLabel valores[][];
	public ControlTablero controlador;
	private JMenuBar barramenu;
	private JMenu opciones;
	public JMenuItem salir;
	public JMenuItem guardarPartida;
	public JFrame pantallaFinalG;
	public JFrame pantallaFinalP;
	public JLabel mensajeFinalPerder= new JLabel();
	public JLabel mensajeFinalGanar;
	public JLabel mensajeNoLetras;
	public JFrame noLetras;
	public JMenu nombreUsuario;
	public JMenuItem estadisticas;
//	public static void main(String [] args) {
//		
//		ViewTablero m = new ViewTablero();  
//		
//	}
	
//	public ViewTablero() {
//		
//		IniciarVentana();
//		
//	}
	public void setmensajeFinalPerder(String palabraCorrecta) {
		mensajeFinalPerder = new JLabel("Has perdido, la palabra correcta era: "+ palabraCorrecta);
		pantallaFinalP.add(mensajeFinalPerder);
	}
	public  void IniciarVentana() {
		
		//controlador = new ControlTablero(this); 
		
		marco= new JFrame();
		marco.setSize(400,600);
		marco.setResizable(false);
		
		pantallaFinalP= new JFrame();
		pantallaFinalP.setSize(300,200);
		pantallaFinalP.setResizable(false);
		
		pantallaFinalG= new JFrame();
		pantallaFinalG.setSize(200,200);
		pantallaFinalG.setResizable(false);
		
		noLetras= new JFrame();
		noLetras.setSize(250,200);
		noLetras.setResizable(false);
		
		
		//mensajeFinalPerder = new JLabel("error");//("Has perdido, la palabra correcta era:"+ );
		mensajeFinalPerder.setPreferredSize(new Dimension(50,50));
		mensajeFinalGanar = new JLabel("                  Ole campeon!!");
		mensajeFinalGanar.setPreferredSize(new Dimension(50,50));
		mensajeNoLetras = new JLabel("  Introduce una palabra con 5 letras");
		mensajeNoLetras.setPreferredSize(new Dimension(50,50));
		
		
		pantallaFinalG.add(mensajeFinalGanar);
		noLetras.add(mensajeNoLetras);
		
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(5,5));
		
		
		//Añade barra de opciones
		barramenu = new JMenuBar();
		
		//OPCIONES DE PARTIDA
		opciones = new JMenu("Opciones");
		barramenu.add(opciones);
		salir = new JMenuItem("Salir");
		opciones.add(salir);
		salir.addActionListener(controlador);
		estadisticas = new JMenuItem("Stats");
		opciones.add(estadisticas);
		estadisticas.addActionListener(controlador);
		guardarPartida = new JMenuItem("Guardar y Salir");
		guardarPartida.addActionListener(controlador);
		opciones.add(guardarPartida);
		marco.setJMenuBar(barramenu);
		//NOMBREUSUARIO
				nombreUsuario = new JMenu(controlador.partida.getUser().getNombre());
				nombreUsuario.setPreferredSize(new Dimension(50,50));
				barramenu.add(nombreUsuario, BorderLayout.WEST);
				nombreUsuario.setVisible(true);
				
		barramenu.setVisible(true);
		
		
		valores = new JLabel[5][5];
		
		for (int i=0;i<valores.length;i++) {
			for(int j=0;j<valores[0].length;j++) {
				
			valores[i][j] = new JLabel("-");	
			valores[i][j].setPreferredSize(new Dimension(50,50));
			
			panel.add(valores[i][j]);
			
			}
			
		}
		
		marco.setLayout(new BorderLayout());
		marco.add(panel,BorderLayout.CENTER);
		
		boton = new JButton ("Introducir palabra");
		
		boton.addActionListener(controlador);
		
		marco.add(boton, BorderLayout.SOUTH);
		
		marco.pack();
		boton.setVisible(true);
		marco.setVisible(true);
		panel.setVisible(true);
		
		
		
		
		
	}
public  void CargarVentana() {
		
		//controlador = new ControlTablero(this); 
		
		marco= new JFrame();
		marco.setSize(400,600);
		marco.setResizable(false);
		
		pantallaFinalP= new JFrame();
		pantallaFinalP.setSize(200,200);
		pantallaFinalP.setResizable(false);
		
		pantallaFinalG= new JFrame();
		pantallaFinalG.setSize(200,200);
		pantallaFinalG.setResizable(false);
		
		noLetras= new JFrame();
		noLetras.setSize(250,200);
		noLetras.setResizable(false);
		
		
		mensajeFinalPerder = new JLabel("Has perdido");
		mensajeFinalPerder.setPreferredSize(new Dimension(50,50));
		mensajeFinalGanar = new JLabel("Ole campeon!!");
		mensajeFinalGanar.setPreferredSize(new Dimension(50,50));
		mensajeNoLetras = new JLabel("Introduce una palabra con 5 letras");
		mensajeNoLetras.setPreferredSize(new Dimension(50,50));
		
		pantallaFinalP.add(mensajeFinalPerder);
		pantallaFinalG.add(mensajeFinalGanar);
		noLetras.add(mensajeNoLetras);
		
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(5,5));
		
		
		//Añade barra de opciones
		barramenu = new JMenuBar();
		opciones = new JMenu("Opciones");
		barramenu.add(opciones);
		salir = new JMenuItem("Salir");
		opciones.add(salir);
		salir.addActionListener(controlador);
		guardarPartida = new JMenuItem("Guardar y Salir");
		guardarPartida.addActionListener(controlador);
		opciones.add(guardarPartida);
		marco.setJMenuBar(barramenu);
		barramenu.setVisible(true);
		
		valores = new JLabel[5][5];
		
//		for (int i=0;i<valores.length;i++) {
//			for(int j=0;j<valores[0].length;j++) {
//				
//			valores[i][j] = new JLabel("-");	
//			valores[i][j].setPreferredSize(new Dimension(50,50));
//			
//			panel.add(valores[i][j]);
//			
//			}
//		}
//		
		////////////PARA ACTUALZIAR TABLERO AL CARGAR PARTIDA CON LAS PALABRAS////////
		
		String[] palabrasT = controlador.partida.getArrayTablero();
		
		int linea = controlador.partida.getContadorIntentos();
		char[][] letras = new char[palabrasT.length][5];
		int z=0;
		int y=5;
		for(int i=0;i<palabrasT.length;i++) {
			if(palabrasT[i]==null) {
				y--;
			}		
		}
		for(int i=0;i<y;i++) {
			for(int j=0;j<5;j++) {
				letras[i][j] = palabrasT[i].charAt(j);
				valores[i][j] = new JLabel(String.valueOf(letras[i][j]));
				valores[i][j].setPreferredSize(new Dimension(50,50));
				panel.add(valores[i][j]);
			}
			z++;
		}
		for (z=z;z<valores.length;z++) {
			for(int j=0;j<valores[0].length;j++) {
				
			valores[z][j] = new JLabel("-");	
			valores[z][j].setPreferredSize(new Dimension(50,50));
			
			panel.add(valores[z][j]);
			
			}
		}
		
		marco.setLayout(new BorderLayout());
		marco.add(panel,BorderLayout.CENTER);
		
		boton = new JButton ("Introducir palabra");
		
		boton.addActionListener(controlador);
		
		marco.add(boton, BorderLayout.SOUTH);
		
		marco.pack();
		boton.setVisible(true);
		marco.setVisible(true);
		panel.setVisible(true);
		
		
		
		
		
	}
	
}
