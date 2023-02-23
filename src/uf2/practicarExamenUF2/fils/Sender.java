package uf2.practicarExamenUF2.fils;


public class Sender implements Runnable{
	
	private static Packet paquet;
	private static String info;
	static String infos[] = new String [] {"informacio privada 1 ","informacio privada 2","informacio3","informacio4","informacio5","fi"};

	public Sender (Packet paquet, String infos[]){
		this.paquet=paquet;
		this.info=info;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Packet paquet = new Packet();
		Recibir recibir = new Recibir(paquet);
		Sender enviar = new Sender (paquet, infos);
				
		Thread t1 = new Thread(recibir, "Rebre");
		Thread t2 = new Thread(enviar, "Enviar");
		
		t1.start();
		t2.start();
		
	}
	@Override
	public void run() {
		for (String info:infos) {
				try {
					// el productor crida a posar nom i li pasa un nom
					paquet.enviaPaquet(info);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}
			
}
