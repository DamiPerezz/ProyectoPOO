package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Estadistica {
	//Constructor que carga datos
	public Estadistica() {
		
		this.TotalUsuarios= CargarUsuarios();
		this.JugadorMasJugon= SacarJugadorMasJugon();
		
	}
	public ArrayList<Usuario> CargarUsuarios() {
		
		File fichero= new File("listaUsuarios.txt");
		String text="";
		try {
			Scanner sc = new Scanner(fichero);
			
			while(sc.hasNextLine()) {
				
				text= sc.next();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//Pasar de String a instancias 
		
		String users[] = text.split(";");
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		for (int i=0;i<users.length;i++) {
			
			String[] info= users[i].split(":");
			Usuario u = new Usuario(info[0],Integer.parseInt(info[1]));
			usuarios.add(u);
			
		}
		
		return usuarios;
		
		
	}

	//Estadistica para usuarios
	private ArrayList<Usuario> TotalUsuarios;
	private Usuario JugadorMasJugon;
	private Usuario JugadorMayorPorcentajeAdiv;
	private Usuario JugadorMenorPorcentajeAdiv;
	//Para el JugadorMasJugon
	public Usuario getJugadorMasJugon() {
		return JugadorMasJugon;
	}
	public void setJugadorMasJugon(Usuario jugadorMasJugon) {
		JugadorMasJugon = jugadorMasJugon;
	}
	public Usuario SacarJugadorMasJugon() {
		Usuario JugadorPRO = new Usuario("null",0);
	
		for (Usuario u:this.TotalUsuarios) {
			if(u.getPartidasJugadas()>JugadorPRO.getPartidasJugadas()) {
				JugadorPRO.setNombre(u.getNombre());
				JugadorPRO.setPartidasJugadas(u.getPartidasJugadas());
			}
			
			//En el caso de que dos jugadores tengan el mismo numero de partidas 
			//El sistema escojera al usuario de forma aleatoria
			if(u.getPartidasJugadas()==JugadorPRO.getPartidasJugadas()) {
				Random random = new Random();
		        int numRandom = random.nextInt(2) + 1;
		        if(numRandom==1) {
		        	JugadorPRO.setNombre(u.getNombre());
					JugadorPRO.setPartidasJugadas(u.getPartidasJugadas());
		        }
			}
		}
		
		return JugadorPRO;
	}
	//Para el Porcentaje de adivinación
	
	public int RelacionesDePorcentaje(int intentos) {
		
		int porcentaje=0;
		if (intentos<5 && intentos>0) {
			
			switch(intentos) {
			
			case 1:
				porcentaje=100;
			case 2:

				porcentaje=80;
			case 3:

				porcentaje=60;
			case 4:

				porcentaje=40;
			case 5:

				porcentaje=20;
			}
			
		}else {
			System.out.println("Numero de intentos invalido, revisar fichero");
		}
		
		return porcentaje;
	}
	public Usuario JugadorMasAdivinacion() {
		int porcentajeMayor =0;
		Usuario topG = new Usuario ("topG", 0);
		for(Usuario u:this.TotalUsuarios) {
			int porcentajeU= SacarPorcentajes(u);
			if(porcentajeU>porcentajeMayor) {
			topG.setNombre(u.getNombre());
			topG.setPartidasJugadas(u.getPartidasJugadas());
			porcentajeMayor = porcentajeU;
			}
		}
		return topG;
	}
	public int SacarPorcentajes(Usuario u) {
		//Este metodo va leyendo el fichero linea por linea y haciendo splits
		//Si encuentra una línea en la que sea el nombre del usuario igual que el caracter index [2]
		//Agrega uno a la variable auxiliar de partida encontradas y suma el porcentaje asignado
		//al numero relacionado con el porcentaje de ese numero de intentos
		File fichero = new File("../resgistroPartidas.txt");
		String ultimaPartida = "";
		int npart=0;
		int porcentaje=0;
		try {
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				ultimaPartida = sc.nextLine();
				String[] ultimaLinea = ultimaPartida.split(";");
				if(ultimaLinea[2]==u.getNombre()) {
					npart++;
					char intentos = ultimaLinea[3].charAt(0);
					int contadorIntentos = Character.getNumericValue(intentos);
					porcentaje=(porcentaje + RelacionesDePorcentaje(contadorIntentos))/npart;
				}	
			}		
		}catch(Exception ex) {
			ex.getMessage();
	}
		return porcentaje;	
	}
}