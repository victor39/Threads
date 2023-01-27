package uf2.practicarExamenUF2.fils;


public class ContadorFils implements  Runnable{
	
	 private int contador ;
	 private String nameFil;
	 private int max ;
	
	public ContadorFils(String nombre, int limite) {
		this.contador=0;
		this.nameFil=nombre;
		this.max=limite;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
	
		ContadorFils contador = new ContadorFils ("contador1 ", 30);
		ContadorFils con2 = new ContadorFils("contador 2 " , 10);

		
		Thread t1 = new Thread (contador);
		t1.start();
		t1.join();
		
		
		Thread t2 = new Thread (con2);
		t2.start();
		t2.join();
	
	
		
	}
	@Override 
	public void run() {
		while(contador <= max ) {
			try {
				System.out.println(nameFil + contador);
				contador++;
				Thread.sleep(1);
				;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
	
		}
	}



	

}
