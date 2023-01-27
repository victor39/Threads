package uf2.practicarExamenUF2.Multiprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProgramacioMultiproces {

	public static void main(String[] args)throws Exception {
		
	//generar processBuilder y le añadimos la comanda 
	ProcessBuilder proces = new ProcessBuilder();
	// llamo al cmd , en la posicio c i hago ping 5 veces 
   // proces.command("cmd.exe", "/c","copy c:\\Users\\Victor\\data.txt c:\\Users\\Victor\\new.txt");
    proces.command("cmd.exe", "/c","ping -n 5 google.com");
    // redirigir la comanda a donde quiero yo 
    File ping = new File ("c:Users\\Victor\\redirectPING.txt");
    proces.redirectOutput(ping);
    
    ProcessBuilder ejecutarPrograma = new ProcessBuilder();
    String exe = "notepad.exe";
    ejecutarPrograma.command(exe);
    
	try {
		// hago un proceso con dicha comanda 
		Process process = proces.start();
		//imprimir el pid del process 
		System.out.println(process.pid());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		//guardare en el reader tot el que em pasa d'informacio el programa
		String line ; 
		// recojo los valores del process  y los imprimo 
		
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		
		// proceso 3 , redirecOutput
		ProcessBuilder redirect = new ProcessBuilder();
		redirect.command("cmd.exe","/c","date");
		File fileName = new File ("c:Users\\Victor\\provaOutPut.txt");
		
		redirect.redirectOutput(fileName);
		
		Process resultat = redirect.start();
		
		String linea2;
        while ((linea2 = reader.readLine()) != null) {
        	System.out.println(linea2);
        	
        	
        }if(process.isAlive()) {
        	ejecutarPrograma.start();
        }else{
        	
        }
        	
        
          
        int exit = process.waitFor();
		System.out.println("Exit con error codigo en :" + exit);	
		
		
	
			
	}catch(Exception e){
		System.out.println(e);
	}
	
	// genero un procesHandle para mirar si hay alguno notepad encendido si es asi lo mata 
	ProcessHandle.allProcesses().forEach(process -> {
          if(process.info().toString().toLowerCase().contains("notepad")) {
              process.destroy();
              System.out.println("fi del programa ");
          	}
          });



	}
	
	
	
	
	
	
	
}
