package exo2énoncé;

public final class Compteur implements Runnable {

	private Thread thread;

	public Compteur() {
		this.thread=new Thread(this);
	}

	public void run() {
		int cpt = 0;
		System.out.println("Depart");
		try{
			while (true){
				System.out.println(cpt++);
				Thread.sleep(1);	
			}
		}
		catch(InterruptedException e){}
		System.out.println("Fin : " + cpt);				
	}


	public void fin() {	
		//ici thread.currenThread().interrupt() serait faux
		//car le thread courant est le thread du main
		this.thread.interrupt();
	}

	public void lancer() {
		new Thread(this).start();
	}
}