package uf2.practicarExamenUF2.fils.consumidorNumeros;

import java.util.Random;

import uf2.practicarExamenUF2.fils.Packet;
import uf2.practicarExamenUF2.fils.Recibir;
import uf2.practicarExamenUF2.fils.Sender;

public class Productor implements Runnable{
	
	// generar numero aleatorio
	 private final Random aleatorio;
	private static Contenedor conte;
	
	public Productor (Contenedor contenedor){
		this.conte=contenedor;
		aleatorio = new Random();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Contenedor paquet = new Contenedor();
		Consumidor consumidor = new Consumidor (paquet);
		Productor productor = new Productor(paquet);
				
		Thread t1 = new Thread(productor, "Enviar");
		Thread t2 = new Thread(consumidor, "Rebre");
		
		t1.start();
		t2.start();
		
	}
	@Override
	public void run() {
		while(true) {
			
			int poner = aleatorio.nextInt(100);
				try {
					// el productor crida a posar nom i li pasa un nom
					conte.enviaPaquet(poner);
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}
	

}
