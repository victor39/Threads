package recuperacio;

import java.util.Scanner;

public class multiplicarFILS implements Runnable {

	public static Scanner lector = new Scanner(System.in);
	boolean bol = true;
	private int tipo;
	private Double[][] resul;


	public  multiplicarFILS(Double resul[][], int tipo) {
		this.resul=resul;
		this.tipo=tipo;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		// matriz amb 10 numeros en aquest cas 
		Double[][] resul = new Double [4][10];
		

		// primer sumar
		multiplicarFILS num1 =  new multiplicarFILS(resul,1);
		// fil per sumar
		Thread filSum = new Thread(num1);

		// fil per multiplicar
		Thread fil2 = new Thread(new multiplicarFILS(resul,2));
		Thread filDividir = new Thread(new multiplicarFILS(resul,3));
		Thread filRaiz = new Thread(new multiplicarFILS(resul,4));


		filSum.start();
		fil2.start();
		filDividir.start();
		filRaiz.start();

		filSum.join();
		fil2.join();
		filDividir.join();
		filRaiz.join();

		// resultat 
		for (int i = 0; i < 10 ; i++) { 
			System.out.println("-> "+ i +  "[" + resul[0][i] +", "  + resul[1][i] +", " +  resul[2][i] + ", " +  resul[3][i] + "]" );
		}
	}

	@Override
	public void run() {
		while (bol) {
			switch (tipo) {
			case 1:
				//suma
				for (int i = 0; i < 10  ; i++) { 
					double resultat =  23 + i ;
					resul[0][i]= resultat;

				}
				bol=false;
				break;
			case 2:
				// multiplica
				for (int i = 0; i < 10  ; i++) { 
					double resultat = i * 23;
					resul[1][i]= resultat;
				}
				bol=false;
				break;
			case 3:
				// divide
				int k = 0;
				Double num = 0.0;

				for(Double i = 0.0; i < 10; i++) {			
					try {
						num = (double) (23 / k);
						if(num.isInfinite()) {
							resul[2][k] = Double.parseDouble("null");
						}
						else {
							resul[2][k] = num;
						}
					}catch(Exception e) {
						System.out.println(e);
					}
					k = k + 1;
				}	
				bol=false;
				break;
			case 4:
				// raiz
				for (int i = 0; i < 10  ; i++) { 
					double resultat =  Math.pow(23, i);
					resul[3][i]= resultat;
				} 
				bol= false;
				break;
			}
		}

	}
}
