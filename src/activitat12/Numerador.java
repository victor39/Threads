package activitat12;

public class Numerador {
	
	private int num= 0 ;
	
		private int getNumero() {
			return num;
		}

		private void setNumero(int num) {
			this.num= num;
		}


		public int getNumeroSeguent() {
			synchronized(this){
				num += 1;
				System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + num);
				return num;
			}
			
		
		}
	
	
}
