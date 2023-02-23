package recuperacio;

public class repasFilsIF extends Thread{


	static Double[][] arrayDimensional = new Double[4][10];

	public static void main(String[] args) throws Exception {

		repasFilsIF fil = new repasFilsIF();
		Thread filM = new Thread(fil);
		Thread filD = new Thread(fil);
		Thread filS = new Thread(fil);
		Thread filE = new Thread(fil);

		filM.setName("filMultiplicar");
		filD.setName("filDividir");
		filS.setName("filSumar");
		filE.setName("filElevar");

		filM.start();
		filD.start();
		filS.start();
		filE.start();

		filM.join();
		filD.join();
		filS.join();
		filE.join();

		for(int i = 0; i < 10; i++) {
			System.out.println(i + " -> [" + arrayDimensional[0][i] + ", " + arrayDimensional[1][i] + ", " + arrayDimensional[2][i] + ", " + arrayDimensional[3][i] + "]");
		}
	}

	public void run(){
		// hacerlo con if renombrando cada hilo primero y entrando al que quiero
		if(Thread.currentThread().getName().equalsIgnoreCase("filMultiplicar")) {
			multiplicar();
		}
		else if(Thread.currentThread().getName().equalsIgnoreCase("filDividir")) {
			dividir();
		}
		else if(Thread.currentThread().getName().equalsIgnoreCase("filSumar")) {
			sumar();
		}
		else if(Thread.currentThread().getName().equalsIgnoreCase("filElevar")) {
			elevar();
		}
	}
	public void multiplicar () {
		for(int i = 0; i < 10; i++) {
			Double num = (double) (23 * i);
			arrayDimensional[0][i] = num;
		}
	}
	public void dividir () {
		int k = 0;
		Double num = 0.0;

		for(Double i = 0.0; i < 10; i++) {			
			try {
				num = (double) (23 / k);
				if(num.isInfinite()) {
					arrayDimensional[1][k] = Double.parseDouble("Error");
				}
				else {
					arrayDimensional[1][k] = num;
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			k = k + 1;
		}	
	}
	public void sumar () {
		for(int i = 0; i < 10; i++) {
			Double num = (double) (23 + i);
			arrayDimensional[2][i] = num;
		}	
	}
	public void elevar () {
		for(int i = 0; i < 10; i++) {
			Double num = Math.pow(23, i);
			arrayDimensional[3][i] = num;
		}
	}	
}
