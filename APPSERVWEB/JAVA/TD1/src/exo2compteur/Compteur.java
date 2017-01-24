package exo2compteur;

public final class Compteur implements Runnable {
	
	public Compteur() {
		fin = false;
	}

	private boolean fin ;
	
	public void run() {
		int cpt = 0;
		System.out.println("Depart");
		while (! fin){
			cpt++;
			System.out.println(cpt);
		}
		System.out.println("Fin : " + cpt);
	}

	public void fin() {
		this.fin = true;
	}

	public void lancer() {
		new Thread(this).start();
	}

}
