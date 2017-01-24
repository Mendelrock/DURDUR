package exo2compteur;

public class AppliArret {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Compteur compte= new Compteur();
		compte.lancer(); // lancement du compteur en paralelle
		new Arreteur(compte).lancer();
	}
}
