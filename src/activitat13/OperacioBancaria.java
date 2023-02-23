package activitat13;

public class OperacioBancaria  implements Runnable {
	/* qui ha de fer el semafor ( el syncronize a de ser el banc , perque si ho posem a posarDiners ho fara al fil1 
	 i per tant no tendria sentit , aixi ha de ser el banc qui dongui el permis quan acabi la transaccio
	 per aixo fem un sincronize amb l'objecte banc , si el semafor esta en vermell , aquest no pot entrar  */
	
	   float diners;
	   Banc banc;
		
		public  OperacioBancaria(float diners, Banc banc2) {
			// TODO Auto-generated constructor stub
			this.diners= diners;
			this.banc = banc2;
		}
		
		@Override
		public  void run() {
			
			// aqui decidimos que funcion hacer , si el diner es inferior fa un treure si no , un posar
			if (diners < 0){
				banc.treureDiners(-diners);
			}
			else banc.posarDiners(diners);
		}


	public static void main(String[] args) throws InterruptedException {
			Banc banc = new Banc(1000);
			float[] operacions = {100, -200, -300, 200, 500, -100, -400, 500};
	
			for (float op: operacions) {
		// instanciamos el hilo con la clase que estamos usando , con el constructor pasamos el banco y el dinero
		//aixi fem tot els fils que calgui i cadascun fara la operacio
				Thread t1 = new Thread(new OperacioBancaria(op,banc));
				t1.start();
			}
			
		
	}


}
