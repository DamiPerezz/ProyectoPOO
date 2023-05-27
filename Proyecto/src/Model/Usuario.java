package Model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	
	private String nombre;
	//private int porcentaje;
	private int partidasJugadas;
	private ArrayList<Usuario> TotalUsuarios;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPartidasJugadas() {
		return partidasJugadas;
	}
	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	
	public Usuario(String nombre) {
		super();
		this.TotalUsuarios = CargarUsuarios();
		ArrayList<Usuario> nuevosUsuarios = new ArrayList<Usuario>(this.TotalUsuarios);
		if(ComprobarExistenciaUsuario(this.TotalUsuarios,nombre)==true) {
			for (Usuario u: this.TotalUsuarios) {
				if(u.getNombre().equals(nombre)) {
					this.nombre=u.getNombre();
					this.partidasJugadas = u.getPartidasJugadas()+1;
					nuevosUsuarios.remove(u);
					break;
				}
			}
		}else {
			this.nombre=nombre;
			this.partidasJugadas=1;
			
		}
		this.TotalUsuarios=nuevosUsuarios;
		
		
		
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre, int partidasJugadas) {
		super();
		this.nombre=nombre;
		this.partidasJugadas=partidasJugadas;
		
	}
	
	public void Añadir1AlNPartida (Usuario u) {
		this.partidasJugadas++;
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
	public void GuardarUsuario(Usuario u) {
		
		
		this.TotalUsuarios.add(u);
		
		try {
			FileWriter fichero = new FileWriter("listaUsuarios.txt",true);
			for(Usuario us: this.TotalUsuarios) {
				fichero.write(us.nombre + ":" + us.partidasJugadas + ":" + "\n");
			}
			
			
			
			fichero.close();
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		
	}
	public boolean ComprobarExistenciaUsuario(ArrayList<Usuario> TotalUsuarios, String username) {
		boolean ans=false;
		for(Usuario u: TotalUsuarios) {
			if(u.getNombre().equals(username)) {
				ans=true;
				
			}	
		}
		
		return ans;
	}
	public String toString() {
		
		return "Nombre de Usuario:" + this.nombre + "\n" + "Partidas Jugadas:" + this.partidasJugadas; 
	}
	
}


