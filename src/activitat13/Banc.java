package activitat13;

public class Banc {
	
	
	private float saldo;
	
	
	public  Banc(float saldoTotal) {
		this.saldo=saldoTotal;
		
	}
	public  float getSaldo() {
		return saldo;
		
	}
	public   void setSaldo(float saldo) {
		this.saldo=saldo;
		
	}
	public  synchronized void  posarDiners(float diners) {
		Banc banc = new Banc(saldo);
		float s1 = banc.getSaldo();
		float s2 = s1+diners;
		banc.setSaldo(s2);
		System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "+" + diners + "=" + s2);
	}
	
	public synchronized void treureDiners(float diners) {
		Banc banc = new Banc(saldo);
		float s1 = banc.getSaldo();
		float s2 = s1-diners;
		banc.setSaldo(s2);
		System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "-" + diners + "=" + s2);
	}
	


}
