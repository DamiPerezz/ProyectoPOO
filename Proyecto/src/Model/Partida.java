package Model;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Control.ControlTablero;
import View.*;


public class Partida {
	
	
	//CREAR PARTIDA NUEVA///////////////////////////////////////////////
	public Partida(Usuario u,int dificultad) {
		super();
		this.setUser(u);
		// TODO Auto-generated constructor stub
		palabraCorrecta = Tablero.getPalabraRandom(this,dificultad);
		//tablero = new Tablero();
		//tablero.setContadorIntentos(0);
		codPartida= SacarCodigoUltimaPartida() +1;
		this.contadorIntentos=0;
		//VISTA Y CONTROL///////////////////////////////////////////////
		this.ventana = new ViewTablero();
		
		this.controlador = new ControlTablero(ventana);
		ventana.controlador = controlador;
		controlador.partida=this;
		ventana.IniciarVentana();
		System.out.println(palabraCorrecta);
			}
	
	
	
	public Partida(Usuario u, String palabraCorrect, int cod,String ArrayTablero[], int counter) {
		this.setUser(u);
		this.palabraCorrecta= palabraCorrect;
		this.codPartida= cod;
		//CONTROL Y VISTA
		this.contadorIntentos = counter;
		this.ventana = new ViewTablero();
		this.controlador = new ControlTablero(ventana);
		ventana.controlador = controlador;
		controlador.partida=this;
		this.arrayTablero = ArrayTablero;
		ventana.CargarVentana();
		System.out.println(palabraCorrecta);
		
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
			
			String[] longitud =	this.getArrayTablero();
			int l= 0;
			for(int i=0;i<longitud.length;i++) {
				if(longitud[i] == null) {
					l++;
				}
			}
			
			String arrToString = "";
			String[] arrayT = new String [5-l];
			for (int i=0;i<arrayT.length; i++) {
				arrayT[i] = this.arrayTablero[i];
				arrToString = arrToString + arrayT[i] + ";";
			}
			 
			String partidaTXT = String.valueOf(codPartida) + ";" + palabraCorrecta + ";" + getUser().getNombre() + ";" + String.valueOf(this.getContadorIntentos()) + ";" + String.valueOf(estadoANI) + ";"+ arrToString; 
			
			
			//File fichero = new File("D:\\Escritorio\\Asignaturas primero universidad\\partidasRegistro.txt");
			try {

				FileWriter escritor = new FileWriter("../resgistroPartidas.txt",true);
				escritor.write(partidaTXT + "\n");
				escritor.close();
				//escritor.write(partidaTXT + "\n");
				
			}catch(Exception ex) {
				ex.getMessage();
			}
			
			
			
		}else {
			//Excepcion de datos incorrectos
		}	
	}
	
	public Partida CargarPartida() throws Excepcioness {
		File fichero = new File("../resgistroPartidas.txt");
		String ultimaPartida = "";
		try {
			Scanner sc = new Scanner(fichero);
			while(sc.hasNextLine()) {
				ultimaPartida = sc.nextLine();
			}
			if (ultimaPartida != null) {
                Scanner lineaScanner = new Scanner(ultimaPartida);
                String ultimaLinea = lineaScanner.next();
                lineaScanner.close();
            }
					
		}catch(Exception ex) {
			ex.getMessage();
		}
		//2;fenix;Paco;4;A
		String[] ultimaLinea = ultimaPartida.split(";");
		//CODIGO PARTIDA
		char cod = ultimaLinea[0].charAt(0);
		int codPartida = Character.getNumericValue(cod);
		//PALABRA CORRECTA
		String palabraCorrecta = ultimaLinea[1];
		//NOMBRE USUARIO
		String usuario = ultimaLinea[2];
		
		char intentos = ultimaLinea[3].charAt(0);
		int contadorIntentos = Character.getNumericValue(cod);
		char estado = ultimaLinea[4].charAt(0);
		if(estado=='A' || estado=='N') {
			
			throw new Excepcioness("La ultima partida esta finalizada, crea un nueva partida");
			
		}
		String[] palabraTablero= new String[5];
		for(int i=5;i<9;i++) {
			for (int j=0;j<4;j++) {
				
				palabraTablero[j] = ultimaLinea[i];
			}
		}
		Usuario u = new Usuario (usuario);
		
		Partida p = new Partida (u, palabraCorrecta,codPartida,palabraTablero,contadorIntentos);
		
		p.setArrayTablero(palabraTablero);
		p.setContadorIntentos(contadorIntentos);
		
		
		
		return p;
		
	}



	public void hasGanado() {
		ventana.mensajeFinalPerder.setVisible(false);
		ventana.mensajeFinalGanar.setVisible(true);
		ventana.pantallaFinalG.setVisible(true);
		GuardarPartidaEnFichero('A');
		user.GuardarUsuario(this.user);
	}
	public void hasPerdido() {
//		ventana.mensajeFinalPerder.setVisible(true);
//		ventana.mensajeFinalPerder.setVisible(false);
//		ventana.pantallaFinalP.setVisible(true);
		GuardarPartidaEnFichero('N');
		user.GuardarUsuario(this.user);
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
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
	
	public int SacarCodigoUltimaPartida() {
		File fichero = new File("../resgistroPartidas.txt");
		int codigo = 0;
		String ultimaLinea= "";
		
		try {
			Scanner lector= new Scanner(fichero);
			
			 while (lector.hasNextLine()) {
	                ultimaLinea = lector.nextLine();
	            }

	            // Extraer el primer número de la última línea
			 
	            if (ultimaLinea != null) {
	                Scanner lineaScanner = new Scanner(ultimaLinea);
	                char numChar = lineaScanner.next().charAt(0);
	                codigo = Character.getNumericValue(numChar);
	                lineaScanner.close();
	            }
		}catch(Exception ex) {
			ex.getMessage();
		}
		
		
		
		return codigo;
	}
	
}
