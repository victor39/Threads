package uf2.practicarExamenUF2.fils;

public class Recibir implements Runnable{
	
	private Packet paquet;
	//private boolean rebut;
	
	public Recibir (Packet paquet){
		this.paquet=paquet;
	}

	@Override
	public void run() {
		String info;
		while (true) {
			try {
				//agafo informacio del paquet 
				info = paquet.rebrePaquet();
				System.out.println("Paquet rebut , obrint  : " + info);
				Thread.sleep(100);
				if (info.equalsIgnoreCase("fi")) break;
				/*rebut=true;
				if (rebut==true) break;*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
