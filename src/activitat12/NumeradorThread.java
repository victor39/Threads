package activitat12;

public class NumeradorThread implements Runnable{
	
		Numerador numerador;
	
		public NumeradorThread(Numerador numerador) {
			this.numerador=numerador;
			
		}
			
			
		@Override
		public void run() {
			for (int n=0; n<1000; n++) numerador.getNumeroSeguent();
			
		}
		
		public static void main(String[] args) throws InterruptedException {
			Numerador numerador = new Numerador();
			
			
			
			Thread t1 = new Thread(new NumeradorThread(numerador));
			Thread t2 = new Thread(new NumeradorThread(numerador));
			
			t1.start();
			t2.start();

			
		}

}
