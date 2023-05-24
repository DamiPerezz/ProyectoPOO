package Control;
import java.io.File;
import java.io.FileWriter;
import Control.*;
import Model.*;
import View.PantallaInicio;
//import View.ViewTablero;
import View.ViewTablero;

public class Sistema {
	///public static Diccionario diccionario = new Diccionario();
		public static void IniciarSistema() {
			PantallaInicio menuPrincipal = new PantallaInicio();
			ControlVentanaInicio controladorPrincipal = new ControlVentanaInicio(menuPrincipal);
			menuPrincipal.controlador = controladorPrincipal;
			menuPrincipal.Iniciar();
			
		}

		public static void main(String[] args) {
						//CREA PARTIDA		
			
						IniciarSistema();
						
			//Crear nueva ventana
			//ViewTablero tableroView = new ViewTablero();
//			ControlTablero controladorTablero = new ControlTablero(tableroView);
//			tableroView.controlador= controladorTablero;
//			
//			
//			Usuario iker = new Usuario("iker");
//			Partida partida1 = new Partida(iker); 
//			System.out.println(partida1.getPalabraCorrecta());
//			//Partida partida2 = new Partida();
//		Usuario dami = new Usuario("Damian");
//			Partida partida2 = new Partida(dami); 
//			System.out.println(partida2.getPalabraCorrecta());
			
//			System.out.println(partida1.getPalabraCorrecta());
//			System.out.println(partida2.getPalabraCorrecta());
//			
//			
////			System.out.print(diccionario);
//			System.out.print(diccionario.sacarPalabras("../hola.txt"));
////			System.out.println(diccionario.getListaPalabra());
//			
			//ViewTablero tablero1 = new ViewTablero();
			
			
		}
			
		

//		String DiccionarioFile = "../hola.txt";
//
//		Diccionario.LeerArchivo(DiccionarioFile);
//		ArrayList<String> listaPalabras = Diccionario.añadirListapalabras(DiccionarioFile);
//		
//		//esto lo he puesto para asegurarme que los metodos estan funcionando y que se guardan en el arraylist
//		if (listaPalabras != null) { // para que saque las palabras del archivo
//			System.out.println("Palabras en el diccionario:");
//			for (String palabra : listaPalabras) {
//				System.out.println(palabra);
//			}
//		} else {
//			System.out.println("No hay palabras en el diccionario");
//		}
	
}
