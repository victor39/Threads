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
	public synchronized void posarDiners(float diners) {
		float s1 = getSaldo();
		float s2 = s1+diners;
		System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "+" + diners + "=" + s2);
		setSaldo(s2);
	}
	
	public synchronized void treureDiners(float diners) {
		float s1 = getSaldo();
		float s2 = s1-diners;
		System.out.println(Thread.currentThread().getName() + " " + this.toString() + " " + s1 + "-" + diners + "=" + s2);
		setSaldo(s2);
	}	
	

}
