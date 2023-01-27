package uf2.practicarExamenUF2.fils;

public class FilsCorredor extends Thread{
	
	 final static int META= 30;
	 private String nameCorredor;
	 private int distancia ;
	 int comprovar= 0;
	
	public FilsCorredor(String nombre, int distancia) {
		this.nameCorredor=nombre;
		this.distancia=distancia;
	}

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Preparant corredors : ");
		
		FilsCorredor corredor = new FilsCorredor("Jose", 0);
		Thread t1 = new Thread (corredor);
		t1.start();
		System.out.println(corredor.nameCorredor);
		
		FilsCorredor corredor2 = new FilsCorredor("Juan", 0);
		Thread t2 = new Thread (corredor2);
		t2.start();
		System.out.println(corredor2.nameCorredor);
		
	}
	public int num () {
		int random = (int) (Math.random()*2+1);
		return distancia += random;
	}
	
	@Override 
	public void run() {
		while(true) {
            try {
                if(num()==1) {distancia+=num();}
                System.out.println("Corredor "+nameCorredor+" Punts:"+distancia);
               
                Thread.sleep(1000);
                if(distancia >=META) {break;}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
