package uf2.practicarExamenUF2.fils.tictac;

public class comHilos {

	public static void main(String[] args) {
		ticTac tt=new ticTac();
		minHilo mh1=minHilo.crearEIniciar("Tic",tt);
		minHilo mh2=minHilo.crearEIniciar("Tac",tt);
		
		try {
			mh1.hilo.join();
			mh2.hilo.join();
		}catch (InterruptedException exc){
			System.out.println("Hilo principal interrumpido.");
		}
	}

}
