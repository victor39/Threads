package activitats;

public class ThreadExample  extends Thread{
	
	public ThreadExample (String nom) {
		super(nom);
		
	}
	
	@Override
	public void run() {
			try {
				for (int i = 0; i <6 ; i++) {
					this.getName();
					System.out.println(this.getName() + ":" + i);
			}
				Thread.sleep(1);
			
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(this.getName());
			}
			
		}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		Thread filPare = new Thread(new Runnable() {
             public void run() { 
            	 
                 ThreadExample t1 = new ThreadExample ("fil1");
                 ThreadExample t2 = new ThreadExample ("fil2");
                 ThreadExample t3 = new ThreadExample ("fil3");

                 System.out.println("Engegant fils");

                 try {
                    
                     t1.start();
                   
                     System.out.println("\n");
                     t2.start();
                   
                     System.out.println("\n");
                     t3.start();
                     t3.join();
                     System.out.println("\n");

                 } catch (InterruptedException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
                 
                 System.out.println("Fils Engegats");
                 
             }

         });
         filPare.start();
	}
	
}
