package Model;
import java.util.ArrayList;
import java.util.Scanner;


public class Partida {
	
	private Usuario user;
	
	public static Usuario SeleccionarUsuario() {
		Usuario user = new Usuario();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre de usuario");
		String username=teclado.next();
		//Carga los usuarios del fichero de listaUsuarios
		ArrayList<Usuario>TotalUsuarios= user.CargarUsuarios();
		//Primero comprueba si existe un usuario con ese nombre, si existe recorre la lista y asigna a nuestro usuario ese usuario
		if (user.ComprobarExistenciaUsuario(TotalUsuarios, username) == true) {
			for(Usuario u: TotalUsuarios) {
				if(u.getNombre().equals(username)) {
					user = u;
				}
			}
		} //Si no existe un usuario que se llame de esa forma lo crea en el momento 
		else {
			user.setNombre(username);
			user.setPartidasJugadas(0);
		}
		
		
		return user;
	}
	
	
	
}
