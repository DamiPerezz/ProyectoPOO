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
	public JFrame pantallaFinal;
	public JLabel mensajeFinalPerder;
	public JLabel mensajeFinalGanar;
	
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
	
	public  void IniciarVentana() {
		
		//controlador = new ControlTablero(this); 
		
		marco= new JFrame();
		marco.setSize(400,600);
		marco.setResizable(false);
		
		pantallaFinal= new JFrame();
		pantallaFinal.setSize(200,200);
		pantallaFinal.setResizable(false);
		
		
		mensajeFinalPerder = new JLabel("Has perdido");
		mensajeFinalPerder.setPreferredSize(new Dimension(50,50));
		mensajeFinalGanar = new JLabel("Ole campeon!!");
		mensajeFinalGanar.setPreferredSize(new Dimension(50,50));
		
		pantallaFinal.add(mensajeFinalPerder);
		pantallaFinal.add(mensajeFinalGanar);
		
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
	
}
