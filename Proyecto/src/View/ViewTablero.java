package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	public static void main(String [] args) {
		
		ViewTablero m = new ViewTablero();  
		
	}
	
	public ViewTablero() {
		
		IniciarVentana();
		
	}
	
	public  void IniciarVentana() {
		
		marco= new JFrame();
		marco.setSize(400,600);
		marco.setResizable(false);
		
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(5,5));
		
		valores = new JLabel[5][5];
		
		for (int i=0;i<valores.length;i++) {
			for(int j=0;j<valores[0].length;j++) {
				
			valores[i][j] = new JLabel("-");	
			valores[i][j].setPreferredSize(new Dimension(50,50));
			
			panel.add(valores[i][j]);
			
			}
			
		}
		
		marco.setLayout(new BorderLayout());
		marco.add(panel,BorderLayout.NORTH);
		
		boton = new JButton ("Introducir palabra");
		controlador = new ControlTablero(this); 
		boton.addActionListener(controlador);
		
		marco.add(boton, BorderLayout.SOUTH);
		
		marco.pack();
		boton.setVisible(true);
		marco.setVisible(true);
		panel.setVisible(true);
		
		
		
		
		
	}
	
}
