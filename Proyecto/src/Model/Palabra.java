package Model;

public class Palabra {

	
	public String palabra;
	public int dificultad;
	//static ArrayList<String> listaPalabras = new ArrayList <String> ();
	
	
	
	public Palabra(String palabra, int dificultad) {
		super();
		this.palabra = palabra;
		this.dificultad = dificultad;
	}


	public String getPalabra() {
		return palabra;
	}


	public int getDificultad() {
		return dificultad;
	}


	
	
	
	
}	
