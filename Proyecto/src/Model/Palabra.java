package Model;

public class Palabra {

	
	public static String palabra;
	public static int dificultad;
	//static ArrayList<String> listaPalabras = new ArrayList <String> ();
	
	
	
	public Palabra(String palabra, int dificultad) {
		super();
		Palabra.palabra = palabra;
		Palabra.dificultad = dificultad;
	}


	public String getPalabra() {
		return palabra;
	}


	public int getDificultad() {
		return dificultad;
	}


	
	
	
	
}	
