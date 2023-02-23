package uf2.practicarExamenUF2.fils.tictac;

public class minHilo implements Runnable {
	
	Thread hilo;
	ticTac ttob;
	
	minHilo(String nombre, ticTac tt){
		hilo=new Thread(this,nombre);
		ttob=tt;
	}
	public static minHilo crearEIniciar(String nombre, ticTac tt){
		minHilo miNHilo=new minHilo(nombre,tt);
		miNHilo.hilo.start(); //Inicia el hilo
		return miNHilo;
	}
	public void run(){
		if (hilo.getName().compareTo("Tic")==0){
			for (int i=0; i<6; i++) ttob.tic(true);
			ttob.tic(false);
		}else {
			for (int i=0; i<6;i++) ttob.tac(true);
			ttob.tac(false);
		}
	}


}
