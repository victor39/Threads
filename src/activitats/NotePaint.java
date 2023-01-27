package activitats;

import java.io.IOException;

public class NotePaint  extends Thread{
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		ProcessBuilder pro = new ProcessBuilder("mspaint.exe");
	
		Process proces = null;
		Process proces2 = null;
		
	
				pro.command("mspaint.exe");
				proces = pro.start();
				pro.command("notepad.exe");
				proces2 = pro.start();
				long pid = proces.pid();
				System.out.println("PID paint " + pid);
				long pid2 = proces2.pid();
				System.out.println("PID paint " + pid2);
		
	    while(true) {
	    
	    	if((!proces.isAlive() == true || !proces2.isAlive() == true)) {
	    		proces.destroy();
	    		proces2.destroy();
	    		Thread.sleep(0,5);
	    		break;
	    	}
    		Thread.sleep(0,5);
	     
	    }
	   
	}

}
