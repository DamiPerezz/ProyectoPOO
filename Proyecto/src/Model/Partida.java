package Model;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Control.ControlTablero;
import View.*;


public class Partida {
	
	
	//CREAR PARTIDA NUEVA///////////////////////////////////////////////
	public Partida(Usuario u) {
		super();
		this.user=u;
		// TODO Auto-generated constructor stub
		palabraCorrecta = Tablero.getPalabraRandom(this);
		//tablero = new Tablero();
		//tablero.setContadorIntentos(0);
		codPartida=0;
		this.contadorIntentos=0;
		//VISTA Y CONTROL///////////////////////////////////////////////
		this.ventana = new ViewTablero();
		
		this.controlador = new ControlTablero(ventana);
		ventana.controlador = controlador;
		controlador.partida=this;
		ventana.IniciarVentana();
		System.out.println(palabraCorrecta);
			}
	
	
	
	public Partida(Usuario u, String palabraCorrect, int cod) {
		this.user = u;
		this.palabraCorrecta= palabraCorrect;
		this.codPartida= cod;
		
	}
	

	//private Tablero tablero;
	private Usuario user;
	private String palabraCorrecta;
	private int contadorIntentos;
	private String[] arrayTablero = new String[5];
	//Para el codigo de partida necesito un ejemplo de partida forzado,
	//Usare un metodo que lea la ultima partida y le añada un 1
	private int codPartida;
	private Diccionario diccionario = new Diccionario();
	private ViewTablero ventana;
	private ControlTablero controlador;
	
	public Diccionario getDiccionario() {
		return diccionario;
	}
	
	public String[] getArrayTablero() {
		return arrayTablero;
	}
	public void setArrayTablero(String[] arrayTablero) {
		this.arrayTablero = arrayTablero;
	}
	public int getContadorIntentos() {
		return contadorIntentos;
	}
	public void setContadorIntentos(int contadorIntentos) {
		this.contadorIntentos = contadorIntentos;
	}
	public String getPalabraCorrecta() {
		
		return palabraCorrecta;
	}
	
	public void guardarPalabra(String palabraUser) {
		arrayTablero[this.contadorIntentos] = palabraUser;
		
	}
	
	public void incrementarContador() {
		this.contadorIntentos ++;
	}
	
//	public static ArrayList<Palabra> getDiccionario(){
//		ArrayList<Palabra> diccionario = Diccionario.getListaPalabra();
//		return diccionario;
//	}
	
	/*
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
	*/

	public void GuardarPartidaEnFichero(char estadoANI) {
		//Formato codPartida;palabraCorrecta;user;Tablero.contadorIntentos;Estado
		if (estadoANI == 'A' ||estadoANI == 'N' ||estadoANI == 'I') {

			//Aquí me he quirao con la conversion al String ;p
			
			String[] arrayT =  this.getArrayTablero();
			String partidaTXT = String.valueOf(codPartida) + ";" + palabraCorrecta + ";" + user.getNombre() + ";" + String.valueOf(this.getContadorIntentos()) + ";" + String.valueOf(estadoANI) + ";"+ arrayT[0]+ ";"+ arrayT[1]+ ";"+ arrayT[2]+ ";"+ arrayT[3]+ ";"+ arrayT[4]; 
			
			File fichero = new File("../../registroPartidas.txt");
			try {

				FileWriter escritor = new FileWriter(fichero,true);
				escritor.write(partidaTXT);
				//escritor.write(partidaTXT + "\n");
				
			}catch(Exception ex) {
				ex.getMessage();
			}
			
			
			
		}else {
			//Excepcion de datos incorrectos
		}	
	}
	
	public Partida CargarPartida() {
		File fichero = new File("../registroPartidas.txt");
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
		String[] palabraTablero= new String[5];
		for(int i=5;i<9;i++) {
			for (int j=0;j<4;j++) {
				palabraTablero[j] = variables[i];
			}
		}
		Usuario u = new Usuario (usuario);
		
		Partida p = new Partida (u, palabraCorrecta,codPartida);
		
		p.setArrayTablero(palabraTablero);
		p.setContadorIntentos(contadorIntentos);
		p.setArrayTablero(palabraTablero);
		
		
		return p;
		
	}



	public void hasGanado() {
		ventana.mensajeFinalPerder.setVisible(false);
		ventana.mensajeFinalGanar.setVisible(true);
		ventana.pantallaFinal.setVisible(true);
		GuardarPartidaEnFichero('A');
		
	}
	
	//Metodo por consola, no usar
//	public static Usuario SeleccionarUsuario() {
//		Usuario user = new Usuario();
//		Scanner teclado = new Scanner(System.in);
//		System.out.println("Introduce tu nombre de usuario");
//		String username=teclado.next();
//		//Carga los usuarios del fichero de listaUsuarios
//		ArrayList<Usuario>TotalUsuarios= user.CargarUsuarios();
//		//Primero comprueba si existe un usuario con ese nombre, si existe recorre la lista y asigna a nuestro usuario ese usuario
//		if (user.ComprobarExistenciaUsuario(TotalUsuarios, username) == true) {
//			for(Usuario u: TotalUsuarios) {
//				if(u.getNombre().equals(username)) {
//					user = u;
//				}
//			}
//		} //Si no existe un usuario que se llame de esa forma lo crea en el momento 
//		else {
//			user.setNombre(username);
//			user.setPartidasJugadas(0);
//		}
//		
//		
//		return user;
//	}
	
	
	
}
