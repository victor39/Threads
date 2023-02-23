package uf2.practicarExamenUF2.fils.consumidorNumeros;


public class Consumidor implements Runnable{
	
	private Contenedor conte;
	//private boolean rebuts
	public Consumidor (Contenedor paquet){
		this.conte=paquet;
	}

	@Override
	public void run() {
		int info;
		int contador=0;
		while (contador < 5) {
			try {
				//agafo informacio del paquet 
				info = conte.rebrePaquet();
				System.out.println("obrint  : " + info);
				Thread.sleep(100);
				
				contador++;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		System.exit(contador);
	}
	

}
