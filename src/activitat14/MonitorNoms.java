package activitat14;

public class MonitorNoms {

    private boolean tincNom = false;
    private String nom;

    public synchronized String treuNom() throws InterruptedException {
        //Si no tinc nom -> espera -> blocked
    	
        while (!tincNom) {
            System.out.println(Thread.currentThread().getName() + " - wait treuNom");
            wait();
        }

        //Tinc nom -> notify -> es pot posar nom
        tincNom = false;
        notify();
        return nom;
    }

    public synchronized void posaNom(String nom) throws InterruptedException {
        //Si tinc nom -> espera -> blocked
        while (tincNom) {
            System.out.println(Thread.currentThread().getName() + " - wait posaNom");
            wait();
        }

        //No tinc nom -> notify -> es pot posar nom
        this.nom=nom;
        tincNom=true;
        notify();
    }
}

