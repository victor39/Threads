package activitat14;


public class Main {
	
	static MonitorNoms monitor = new MonitorNoms();
	static String nom[] = new String [] {"jose","antonio","jesus","ignasi","marc","fi"};
	static ConsumidorNoms consumidor = new ConsumidorNoms (monitor);
	static ProductorNoms productor = new ProductorNoms(nom,monitor);

	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(consumidor, "Consumidor");
		Thread t2 = new Thread(productor, "Productor");
		
		t1.start();
		t2.start();
	}
}