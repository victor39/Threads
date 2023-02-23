package uf2.practicarExamenUF2.fils.consumidorNumeros;

public class Contenedor {
	
	 private int contenido;
	 private boolean contenedorLleno = false;
	 
	 public synchronized int rebrePaquet() throws InterruptedException {
	        //Si no tinc contingut del contenedor -> espera -> blocked
	        while (!contenedorLleno) {
	            System.out.println(Thread.currentThread().getName() + " - esperant paquet ");
	            wait();
	        }

	        //Si tinc contingut-> notify -> es pot rebre
	        contenedorLleno = false;
	        notify();
	        return contenido;
	        
	    }
	 public synchronized void enviaPaquet(int contingut) throws InterruptedException {
	        //Si tinc paquet -> espera -> blocked
	        while (contenedorLleno) {
	            System.out.println(Thread.currentThread().getName() + " - esperant enviar");
	            wait();
	        }
	        //No tinc paquet entro i omplo amb el contingut 
	        this.contenido=contingut;
	        contenedorLleno=true;
	        // aqui entra i desperta 
	        notify(); 
	    }
	 
	 

	
	

}
