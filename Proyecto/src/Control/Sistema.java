package Control;
import Model.Diccionario;
import java.io.*;

public class Sistema {
	public static Diccionario diccionario;
		
	public static void main(String [] args) {
	
	
	String DiccionarioFile = "../hola.txt";
	
	System.out.println(Diccionario.LeerArchivo(DiccionarioFile));
	
	}
}
