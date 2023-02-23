package recuperacio;

public class simularCarreraAnimals extends Thread {

	String nombre;
	final int META = 30;

	public simularCarreraAnimals (String nombre) {
		this.nombre=nombre;
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		simularCarreraAnimals liebre = new simularCarreraAnimals("liebre");
		Thread fil1 = new Thread(liebre);
		
		simularCarreraAnimals gato = new simularCarreraAnimals("gato");
		Thread fil2 = new Thread(gato);
		
		fil1.start();
		fil2.start();

	}
	
	@Override 
	public void run(){
		for(int i=1;i<= 30;i++){
			System.out.print(i+ " mt ");
		}
		System.out.println("\n Llego a la meta " + nombre);
		System.exit(META);
	}
	

}
