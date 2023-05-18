package Model;
import Model.Palabra;
import Control.Sistema;

import java.util.Scanner;
import java.io.*;

public class Diccionario {
	
	public static String LeerArchivo(String DiccionarioFile) {
		String linea= "";
		try {
			File fichero = new File(DiccionarioFile);
			Scanner sc= new Scanner (fichero);
			
			
			while(sc.hasNextLine()) {
				linea= sc.nextLine();  //para q recorre uno a uno cada linea del archivo
				System.out.println(linea);
			}
			sc.close();
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());		
		}
		return linea;
    }
	
	}
	
	

