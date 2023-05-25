package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Diccionario {

	
	private ArrayList<Palabra> listaPalabras; //TodasPalabrasDicc(sacarPalabras("../hola.txt"), sacarDificultad("../hola.txt")); 
	
	public ArrayList<Palabra> filtrarDiccionario(int d){
		ArrayList<Palabra> diccionarioFiltrado = new ArrayList<Palabra>();
		for(Palabra p:listaPalabras) {
			if (p.dificultad==d) {
				diccionarioFiltrado.add(p);
			}
		}
		return diccionarioFiltrado;
	}
	
	public ArrayList<Palabra> getListaPalabras() {
		return listaPalabras;
	}

	public Diccionario() {
		super();
		listaPalabras = TodasPalabrasDicc(sacarPalabras("../hola.txt"), sacarDificultad("../hola.txt"));
	}
	
	public String toString () {
		for (int i=0; i<listaPalabras.size();i++) {
			System.out.println("palabra:" + listaPalabras.get(i).palabra + "dificultad:" + listaPalabras.get(i).dificultad);
		}
		
		return ("fsdafsadf");
	}

	/*
	public static void main(String [] args) {
		ArrayList<String> listaPalabras= new ArrayList<String>(); 
		String DiccionarioFile = "../hola.txt";
		Diccionario d = new Diccionario();		
	}
	*/
	
	public  String LeerArchivo(String DiccionarioFile) {
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

	
	public ArrayList<Palabra> TodasPalabrasDicc(ArrayList<String> todasPalabras, int[] todosNumeros) {
		ArrayList<Palabra> listPalabras = new ArrayList<Palabra>();
		for(int i=0;i<620;i++) {
			Palabra p = new Palabra(todasPalabras.get(i), todosNumeros[i]);
			listPalabras.add(p);
		}
		return listPalabras;
	}
		public int[] sacarDificultad(String DiccionarioFile) {
		int[] num = new int[620];  //creo que esto esta dando problemas en el Tablero.getPalabraRandom()
		
        try {
            File fichero = new File(DiccionarioFile);
            Scanner sc = new Scanner(fichero);
            ArrayList<String> palabras = new ArrayList<String>();
            ArrayList<String> listaPalabras = new ArrayList<String>();
            int j=0;
            char aux =' ';
            while (sc.hasNextLine()) {

                String linea = sc.nextLine();
                String[] separador = linea.split(";");
                 palabras.add(separador[0]);
                listaPalabras.add(Arrays.toString(separador));
                aux= separador[1].charAt(0);
                num[j] = Character.getNumericValue(aux);
                j++;
                
//                Palabra palabra= new Palabra(Arrays.toString(separador));
//                listaPalabras.add(palabra);
            }
            
            /*
            System.out.println(palabras);
            for(int n:num) {
            	System.out.println(n);
            }
            */
            
            sc.close();

        } catch (Exception e) {
            System.out.println("no se puede leer el archivo" + e.getMessage());
        }

        
        return num;


    }
	
	public  ArrayList<String> sacarPalabras(String DiccionarioFile) {

		
		ArrayList<String> listaPalabras = new ArrayList<String>();
		ArrayList<String> palabras = new ArrayList<String>();
		try {
            File fichero = new File(DiccionarioFile);
            Scanner sc = new Scanner(fichero);
            
            int[] num = new int[620];
            int j=0;
            char aux =' ';
            
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] separador = linea.split(";");
                 palabras.add(separador[0]);
                listaPalabras.add(Arrays.toString(separador));
                aux= separador[1].charAt(0);
                num[j] = Character.getNumericValue(aux);
                j++;
                
//                Palabra palabra= new Palabra(Arrays.toString(separador));
//                listaPalabras.add(palabra);
            }
            
            /*
            System.out.println(palabras);
            for(int n:num) {
            	System.out.println(n);
            }
            */
            
            sc.close();

        } catch (Exception e) {
            System.out.println("no se puede leer el archivo" + e.getMessage());
        }

        if (listaPalabras.isEmpty()) {
             // por si no encuentre palabras en el archivo
        }
        
        return palabras;

    }

	public static ArrayList<String> darPista(String DiccionarioFile) {

		ArrayList<String> pistas = new ArrayList<String>();
		ArrayList<String> listaPistas = new ArrayList<String>();
		
		char aux= ' ';
		int j=0;
		
		try {
			File fichero = new File(DiccionarioFile);
			Scanner sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] separador = linea.split("/");
//				 if (separador.length > 1) {
//		                pistas.add(separador[0]);
//		            }
				pistas.add(separador[0]);
				listaPistas.add(Arrays.toString(separador));
				aux= separador[1].charAt(0);
				j++;
				
				}
			sc.close();
		}catch (Exception e) {
			System.out.println("No se puede leer el archivo" + e.getMessage());
		}
		System.out.println("PSS. tiene pista: " + pistas.get(0));
	    return pistas;
	}
	
	
	public ArrayList<Palabra> getListaPalabra() {
		// TODO Auto-generated method stub
		return listaPalabras;
	}

}
