package Control;
import Model.*;
//import View.ViewTablero;

public class Sistema {
	public static Diccionario diccionario = new Diccionario();
	

		public static void main(String[] args) {
			
			/*//////////////////////////////////////////////////////////////////////////////
			Partida partida1 = new Partida(); 
			Partida partida2 = new Partida();
			
			System.out.println(partida1.getPalabraCorrecta());
			System.out.println(partida2.getPalabraCorrecta());
			*///////////////////////////////////////////////////////////////////////////////
			
//			System.out.print(diccionario);
			System.out.print(diccionario.sacarPalabras("../hola.txt"));
//			System.out.println(diccionario.getListaPalabra());
			
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
