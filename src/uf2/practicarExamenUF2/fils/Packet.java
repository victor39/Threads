package uf2.practicarExamenUF2.fils;

public class Packet {
	
	 private String paquet;
	 private boolean tincPaquet = false;
	 
	 public synchronized String rebrePaquet() throws InterruptedException {
	        //Si no tinc paquet -> espera -> blocked
	        while (!tincPaquet) {
	            System.out.println(Thread.currentThread().getName() + " - esperant paquet ");
	            wait();
	        }

	        //Tinc paquet -> notify -> es pot rebre
	        tincPaquet = false;
	        notify();
	        return paquet;
	        
	    }
	 public synchronized void enviaPaquet(String contingut) throws InterruptedException {
	        //Si tinc paquet -> espera -> blocked
	        while (tincPaquet) {
	            System.out.println(Thread.currentThread().getName() + " - esperant enviar");
	            wait();
	        }
	        //No tinc paquet entro i omplo amb el contingut 
	        this.paquet=contingut;
	        tincPaquet=true;
	        // aqui entra i desperta 
	        notify(); 
	    }
	 
	 

}
