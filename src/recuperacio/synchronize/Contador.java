package recuperacio.synchronize;

public class Contador {
	private boolean sincronizado;

	public Contador(boolean sincronizado) {
		this.sincronizado = sincronizado;
	}

	public boolean isSincronizado() {
		return sincronizado;
	}

	public synchronized void mostrarNumerosSincronizado(int id, int n) {
		System.out.println("Inicio hilo " + id);
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}
		System.out.println("Fin Hilo " + id);
	}

	public void mostrarNumerosNoSincronizado(int id, int n) {
		System.out.println("Inicio hilo " + id);
		for (int i = 0; i <= n; i++) {
			System.out.println(i);
		}
		System.out.println("Fin hilo " + id);
	}

}
