package exo2compteur;

import java.util.Scanner;

public class Arreteur implements Runnable {

	public Arreteur(Compteur compteur) {
		this.compteur = compteur;
	}
	
	private Compteur compteur;
	
	@Override
	public void run() {
		Scanner clavier = new Scanner(System.in);
		clavier.next(); // attente de la saisie clavier
		this.compteur.fin();
		clavier.close();
	}
	
	public void lancer() {
		new Thread(this).start();
	}

}
