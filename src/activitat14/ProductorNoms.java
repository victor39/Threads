package activitat14;

public class ProductorNoms implements Runnable{
	
	
	private MonitorNoms monitor;
	private String [] noms;

	public ProductorNoms(String[] noms, MonitorNoms monitor) {
		this.noms = noms;
		this.monitor=monitor;
	}
		
	@Override
	public void run() {
		for (String nom:noms) {
			try {
				// el productor crida a posar nom i li pasa un nom
				monitor.posaNom(nom);
				Thread.sleep(100);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

