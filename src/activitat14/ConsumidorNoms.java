package activitat14;

public class ConsumidorNoms implements Runnable {
	
	private MonitorNoms monitor;
	
		public ConsumidorNoms(MonitorNoms monitor) {
			this.monitor= monitor;
		}
	
		@Override
		public void run() {
			String nom ;
			while (true) {
				try {
					//agafo el nom
					nom = monitor.treuNom();
					System.out.println("Hola " + nom);
					Thread.sleep(100);
					if (nom.equalsIgnoreCase("fi")) break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	



