package activitats;
import java.io.File;


public class DirectoryCleanerService {

	static File nomCarpeta = new File ("D:\\Documentos\\prova");
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//El programa esborrarà tots els fitxers d’un directori de forma periòdica.
		//Es configurarà el directori i la periodicitat d’execució (10’’). La configuració es farà mitjançant variables que no es puguin modificar en temps d’execució.
		//Un cop s’hagi comprovat que el programa funciona correctament, s’instal·larà com a servei de Windows.
		
		int tiempo   = 10000;
		
		
		// recorrera toda la carpeta e ira eliminando lo que encuentra 
		
		while(true) {
			
			// leer los archivos , borrarlo en un tiempo determinado 
			File[] files = nomCarpeta.listFiles();
			for (File f : files) f.delete();
			Thread.sleep(tiempo);
			
		}
		
		
	     
	}
}

