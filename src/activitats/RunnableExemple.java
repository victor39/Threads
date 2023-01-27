package activitats;

public class RunnableExemple implements Runnable {
	
	@Override
		public void run() {
			// TODO Auto-generated method stub
		try {
			
			
			for (int i = 0; i <6 ; i++) {
				System.out.println( Thread.currentThread().getName()+ ":" + i);
		}
			Thread.sleep(1);
		
	
			
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  System.out.println("Engegant fils");
		Thread t1 = new Thread (new RunnableExemple() , "fil 1");
		Thread t2 = new Thread (new RunnableExemple() , "fil 2");
		Thread t3 = new Thread (new RunnableExemple(), "fil3 ");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Fils Engegats");
	}

	
}
