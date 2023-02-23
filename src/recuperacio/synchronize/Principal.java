package recuperacio.synchronize;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			boolean sincronizado = true;

			Contador c = new Contador(!sincronizado);
			HiloContador h1 = new HiloContador(1, 10, c);
			HiloContador h2 = new HiloContador(2,  5, c);

			h1.start();
			h2.start();

			h1.join();
			h2.join();

			System.out.println("Fin del programa");
		} catch (InterruptedException ex) { }
	}

}
