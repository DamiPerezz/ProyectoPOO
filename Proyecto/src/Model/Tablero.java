package Model;

import java.util.ArrayList;

public class Tablero {
	
	private String[] arrayTablero;
	private char[] arrayInput;		//habrá que pasarlo a String para la comparación?
	private String palabraInput;
	private int contadorIntentos = 0;
	
	
	

	//private ArrayList<Palabra> diccionario; //Lista de todas las palabras
	
	static Diccionario D = new Diccionario();
	
	
	
	public int getContadorIntentos() {
		return contadorIntentos;
	}
	public void setContadorIntentos(int contadorIntentos) {
		this.contadorIntentos = contadorIntentos;
	}
	public Tablero() {
		super();
		
	}
	public static ArrayList<Palabra> getDiccionario(){
		ArrayList<Palabra> diccionario = D.getListaPalabra();
		return diccionario;
	}
	
	
	//Elige una palabra random del diccionario y la guarda en String palabra
	public static String getPalabraRandom() {
		int numAleatorio = (int) (Math.random() * Tablero.getDiccionario().size());
		//System.out.println(numAleatorio);
		Palabra instanciaPalabra = Tablero.getDiccionario().get(numAleatorio);
		String palabra = instanciaPalabra.getPalabra();
		return palabra;
	}
	
	public void incrementarContador() {
		this.contadorIntentos ++;
	}
	
	
	//Devuelve un string con un indicador(de el resultado de la comparación) en cada carácter Ejemplo: "xyzzy"
	private static String comprobarPalabra(String input, String palabraCorrecta) {
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

}
