package Model;

import java.awt.Color;
import java.util.ArrayList;

public class Tablero {
	
	//private String[] arrayTablero = new String[5];
	private char[] arrayInput;		//habrá que pasarlo a String para la comparación?
	private String palabraInput;
	//private int contadorIntentos;
	
	
	

	//private ArrayList<Palabra> diccionario; //Lista de todas las palabras
	
	//static Diccionario D = new Diccionario();
	
	
	
//	public String[] getArrayTablero() {
//		return arrayTablero;
//	}
//	public void setArrayTablero(String[] arrayTablero) {
//		this.arrayTablero = arrayTablero;
//	}
//	public int getContadorIntentos() {
//		return contadorIntentos;
//	}
//	public void setContadorIntentos(int contadorIntentos) {
//		this.contadorIntentos = contadorIntentos;
//	}
	public Tablero() {
		super();
		
		
	}
//	public static ArrayList<Palabra> getDiccionario(){
//		ArrayList<Palabra> diccionario = Diccionario.getListaPalabra();
//		return diccionario;
//	}
//	public void guardarPalabra(String palabraUser) {
//		arrayTablero[this.contadorIntentos] = palabraUser;
//		
//	}
	
	//Elige una palabra random del diccionario y la guarda en String palabra
	public static String getPalabraRandom(Partida p) {
		int numAleatorio = (int) (Math.random() * p.getDiccionario().getListaPalabras().size());
		//System.out.println(numAleatorio);
		Palabra instanciaPalabra = p.getDiccionario().getListaPalabras().get(numAleatorio);
		String palabra = instanciaPalabra.getPalabra();
		return palabra;
	}
	
//	public void incrementarContador() {
//		this.contadorIntentos ++;
//	}
	
	
	//Devuelve un string con un indicador(de el resultado de la comparación) en cada carácter Ejemplo: "xyzzy"
	public static String comprobarPalabra(String input, String palabraCorrecta) {
		  String pistas = "";
		  
		  
		  for (int x = 0; x < input.length(); x++) {
			  
		    // Si acierta tanto la letra como el lugar se indica con un "x"
		    if (input.charAt(x) == palabraCorrecta.charAt(x)) {
		      pistas += "x";
		      continue;
		    }

		    // Si adivina uno de las letras pero no el lugar se indica con un "y"
		    int indiceCaracter = palabraCorrecta.indexOf(input.charAt(x)); //Busca el caracter en el string para comprobar si existe

		    if (indiceCaracter != -1) {
		      pistas += "y";
		      continue;
		    }
		    // Si ninguna se cumple,se indica con un "z"
		    pistas += "z";
		  }
		  return pistas;
		}
	
	public Color seleccionarColor(char l) {
		Color color = null;
		if (l == 'x') {			//Letra acertada
			color = Color.green;
		}
		if (l == 'y') {			//Letra existente (en otra posición)
			color = Color.orange;
		}
		if (l == 'z') {			//Fatal error (letra fallada)
			color = Color.red;
		}
		
		return color;
	}

}
