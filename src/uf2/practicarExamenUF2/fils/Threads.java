package uf2.practicarExamenUF2.fils;

import java.util.Scanner;

public class Threads implements Runnable {
	
		public static Scanner lector = new Scanner(System.in);
		private int tipo;
		private boolean bol=true;
		
	 public Threads(int tipo) {
			 this.tipo = tipo;
	    }
	
	 
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Threads(1));
		Thread t2 = new Thread(new Threads(2));

		System.out.println("Engegants fils ");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.join();
		t2.join();
	}
	@Override
	public void run() {
		        while (bol) {
		            switch (tipo) {
		                case 1:
		                    //numeros
		                    for (int i = 1; i <= 30; i++) {
		                        System.out.println(i);
		                        bol=false;
		                
		                    }
		                    System.out.println("-------------------------");
		                    break;
		                case 2:
		                    //letras
		                    for (char c = 'a'; c <= 'z'; c++) {
		                        System.out.println(c);
		                        bol=false;
		                    }
		                    System.out.println("-------------------------");
		                    break;
		            }
		        }
	}

}
