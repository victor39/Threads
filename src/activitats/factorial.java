package activitats;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner lector = new Scanner(System.in);
		  
		long tempsInici = System.currentTimeMillis();
		long tempsFinal = 0;
		
		final int temps = 1000000000;
		boolean sortir = true;
		
		
		int opcio = 0; 
		int numero = 0;
		int contador =0;
		boolean contadorTotal = true;
		
		long resultat = 0;
		long resultatRecursiu=0;
	
		long tbTotal[] = new long [10];
		long tbRecursiu[] = new long[10];
		long suma = 0;
		
		
		while (sortir) {
			System.out.println(" Factorial :");	
			System.out.println(" Opcio 1 Factorial iteratiu");
			System.out.println(" Opcio 2 Factorial Recursiu ");
			System.out.println(" Opcio 3 per Sortir");
			
			opcio = lector.nextInt();
		
			switch(opcio) {
			  case 1:
				  System.out.println("Factorial Iteratiu  ");
				  System.out.println("Quin numero vols ?");
				  numero = lector.nextInt();
				  
				  System.out.println("iteratiu :" + factorialIteratiu(numero));
				  
				  while(contadorTotal) {
					  tempsInici = System.currentTimeMillis(); 
					  for (int i = 1 ; i < temps ; i++) {
		 
							factorialIteratiu(numero); 	
							
						}
					  	 tempsFinal  = System.currentTimeMillis() - tempsInici;
					  	 tbTotal[contador++] = tempsFinal;
					  	 
						if(contador == 10) {
							 for (int i = 0 ; i < tbTotal.length ; i++) {
								  
									suma =  tbTotal[i] + suma ;
								}
							
							contadorTotal = false;
							resultat = suma /contador;
							
						}
				  }
				  contador = 0;
				  contadorTotal = true;
				  System.out.println("La mitjana del temps emprenat es  :" + resultat + "ms");
				 
				  
			    break;
			  case 2:
				  System.out.println("Factorial Recursiu  ?");
				  System.out.println("Quin numero vols ?");
				  numero = lector.nextInt();
				  System.out.println("Recursiu :" + factorialRecursiu(numero));
				  
				  while(contadorTotal) {
					  tempsInici = System.currentTimeMillis(); 
					  for (int i = 1 ; i < temps ; i++) {
		 
							factorialRecursiu(numero); 	
							
						}
					  	 tempsFinal  = System.currentTimeMillis() - tempsInici;
					  	 tbRecursiu[contador++] = tempsFinal;
					  	 
						if(contador == 10) {
							 for (int i = 0 ; i < tbRecursiu.length ; i++) {
								  
									suma =  tbRecursiu[i] + suma ;
								}
							
							contadorTotal = false;
							resultatRecursiu = suma /contador;
							
						}
				  }
				  contador=0;
		
				  System.out.println("La mitjana del temps emprenat es  :" + resultatRecursiu + "ms\n");
				  
				  break;
			  case 3:
				  System.out.println("bye , bye ");
				  sortir = false;
				  break;
			}
		}
		
		
		
	lector.close();	
	}
	
	
	public static long factorialIteratiu(int num) {
		   int factorialIteratiu = 1;
	        for (int iNumero = 2; iNumero <= num; iNumero++) {
	            factorialIteratiu = factorialIteratiu * iNumero;
	        }
	        return factorialIteratiu;
	}
	public static long factorialRecursiu(int num) {      
		 if (num <= 1)    
			 return 1;    
		else    
			 return(num * factorialRecursiu(num-1));    
	}    

}
