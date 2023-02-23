package uf2.practicarExamenUF2.fils;

public class sincronizedFils  extends Thread {

	    int nom;
	    // constructor de la clase per aagafar el num 
	    public sincronizedFils(int nom) {
	        this.nom = nom;
	    }

	    public void NUMS() throws InterruptedException {
	   //sincronizo para que primero vaya un hilo con sus numeros , despues el otro con sus numeros 
	   // si no los numeros no saldrian coordinados,  cada hilo entraria y recogeria en ese momento del for y sacaria numeros no corelativo
	        synchronized (this) {

	            for (int i = 0; i <6 ; i++) {
	                   //this.getName();
	                   System.out.println(nom + ":" + i);
	                   Thread.sleep(200);
	            }
	            //aumento en un el nom del fil , per aixi el seguent fil sera 2 
	            nom++;
	        }
	   }

	    @Override
	    public void run() {
	    	// crido a la funcio nums 
	            try {
	                NUMS();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	      }

	  public static void main(String[] args) throws InterruptedException {
	            // TODO Auto-generated method stub

	                 int num = 1;

	                 sincronizedFils p = new sincronizedFils(num);

	                 Thread t1 = new Thread(p);
	                 Thread t2 = new Thread(p);

	                 t1.start();
	                 t2.start();
	     }

}

