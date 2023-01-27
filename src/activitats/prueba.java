package activitats;

import java.io.IOException;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fil fil1 = new Fil();
	}
}
	class Fil implements Runnable {
		private Thread f;
		
		public Fil() {
			f = new Thread (this);
			f.start();
		
		}

		@Override
		public void run() {
		    var processBuilder = new ProcessBuilder();
		    Process process;
			try { 
				processBuilder.command("mspaint.exe");
				process = processBuilder.start();
				long pid = process.pid();
				System.out.println("PID paint " + pid);
			} catch (IOException e) {
				System.out.println("error" + e);
			}
		}
		
		
	}


