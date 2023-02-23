package uf2.practicarExamenUF2.fils.tictac;

public class ticTac {

	String estado; // contiene el estado del reloj
	
	synchronized void tic(boolean corriendo){
		if (!corriendo){//Detiene el reloj
			estado="ticmarcado";
			notify(); //notifica a los hilos en espera
			return;
		}
		System.out.print("Tic ");
		estado="ticmarcado";//establece el estado actual a marcado
		notify(); //deja que tac() se ejecute, tic() notifica a tac()
		try {
			while (!estado.equals("tacmarcado"))
				wait(); //tic() espera a que se complete tac()
		}catch (InterruptedException exc){
			System.out.println("Hilo interrumpido.");
		}
	}
	synchronized void tac(boolean corriendo){
		if (!corriendo){//Detiene el reloj
			estado="tacmarcado";
			notify(); //notifica a los hilos en espera
			return;
		}
		System.out.println("Tac");
		estado="tacmarcado";//establece el estado actual a marcado
		notify();//deja que tic() se ejecute, tac() notifica a tic()
		try {
			while (!estado.equals("ticmarcado"))
				wait(); //tac() espera a que se complete tic()
		}catch (InterruptedException exc){
			System.out.println("Hilo interrumpido.");
		}
	}
}

