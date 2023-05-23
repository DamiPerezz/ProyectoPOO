package Model;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Partida {
	
	
	
	public Partida(Usuario u) {
		super();
		this.user=u;
		// TODO Auto-generated constructor stub
		palabraCorrecta = Tablero.getPalabraRandom();
		tablero = new Tablero();
		tablero.setContadorIntentos(0);
		codPartida=0;
	}

	private Tablero tablero;
	private Usuario user;
	private String palabraCorrecta;
	//Para el codigo de partida necesito un ejemplo de partida forzado,
	//Usare un metodo que lea la ultima partida y le añada un 1
	private int codPartida;
	
	public String getPalabraCorrecta() {
		
		return palabraCorrecta;
	}
	public Partida SacarPartidaDeFichero(){
		//Formato codPartida;palabraCorrecta;user;Tablero.contadorIntentos;Estado
		File fichero = new File("../registroPartidas.txt");
		String resp = "";
		try {
			Scanner lector = new Scanner(fichero);
			while(lector.hasNextLine()) {
				resp=lector.nextLine();
			}
		}catch(Exception ex) {
			ex.getMessage();
		}
		
		//Construimos la instancia
		
		
		return p;
	}

	public void GuardarPartidaEnFichero(char estadoANI) {
		//Formato codPartida;palabraCorrecta;user;Tablero.contadorIntentos;Estado
		if (estadoANI == 'A' ||estadoANI == 'N' ||estadoANI == 'I') {

			//Aquí me he quirao con la conversion al String ;p
			String partidaTXT = String.valueOf(codPartida) + ";" + palabraCorrecta + ";" + user.getNombre() + ";" + String.valueOf(tablero.getContadorIntentos()) + ";" + String.valueOf(estadoANI); 
			
			File fichero = new File("../registroPartidas.txt");
			try {

				FileWriter escritor = new FileWriter(fichero,true);
				escritor.write("Probando probando" + "\n");
				//escritor.write(partidaTXT + "\n");
				
			}catch(Exception ex) {
				ex.getMessage();
			}
			
			
			
		}else {
			//Excepcion de datos incorrectos
		}
		
		
		
	}
	
	
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
