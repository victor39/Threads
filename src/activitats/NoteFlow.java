package activitats;

import java.util.ArrayList;
import java.util.Random;

public class NoteFlow {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//Si el nombre de processos engegats és parell cal engegar de forma aleatòria entre 1 i 4 Notepad.
		//Si el nombre de processos engegats és senar cal tancar tots els Notepad.
		//Els processos Notepad podran ser engegats pel mateix programa o de forma externa des del sistema operatiu.
		//Quan hi hagi més de 5 processos Notepad engegats tancarà tots els Notepad i terminarà.
		
		
		Random rnd = new Random();
		int numero = (int)(Math.random()*4+1);
		System.out.println("numero aleatorio :" + numero);
		
		ArrayList <ProcessHandle> notList = new ArrayList<ProcessHandle>();
		
		ProcessBuilder processBuilder = new ProcessBuilder();
	
		Process proces = null;
		
		while(true){
            ProcessHandle.allProcesses().forEach(process -> {
                if(process.info().toString().toLowerCase().contains("notepad.exe")) {
                    notList.add(process); 
                     }
                });

            break;

        }
		// mirar tamany del array de programes 
		int tamany = notList.size();
		
		if(tamany >= 5) {
			ProcessHandle.allProcesses().forEach(process -> {
        		if(process.info().toString().toLowerCase().contains("notepad.exe")) {
                process.destroy();
               
                 }
			});
		}else {
			System.out.println("tamaño del array " + tamany);
		
			if(notList.size() % 2 == 0 ) {
            System.out.println("par");
            	for (int i = 0 ; i <numero; i++) {
            		processBuilder.command("notepad.exe");
            		proces = processBuilder.start();
            		
            	}

			}else {
				System.out.println("impar");
	        	ProcessHandle.allProcesses().forEach(process -> {
	        		if(process.info().toString().toLowerCase().contains("notepad.exe")) {
	                process.destroy();
	                 }
	            });
	        }		
		}
	}
	
}
