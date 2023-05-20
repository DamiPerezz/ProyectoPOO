package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Diccionario {

	public static String LeerArchivo(String DiccionarioFile) {
		String linea = "";
		try {
			File fichero = new File(DiccionarioFile);
			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				linea = sc.nextLine(); // para q recorre uno a uno cada linea del archivo
			}
			sc.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return linea;
	}

	public static ArrayList<String> añadirListapalabras(String DiccionarioFile) { // este metodo añade contenido del
																					// archivo a un arraylist
		ArrayList<String> listaPalabras = new ArrayList<>();

		try {
			File fichero = new File(DiccionarioFile);
			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {

				String linea = sc.nextLine();
				String[] separador = linea.split(";");
				listaPalabras.add(Arrays.toString(separador));
			}

			sc.close();

		} catch (Exception e) {
			System.out.println("no se puede leer el archivo" + e.getMessage());
		}

		if (listaPalabras.isEmpty()) {
			return null; // por si no encuentre palabras en el archivo
		}
		return listaPalabras;

	}

}
