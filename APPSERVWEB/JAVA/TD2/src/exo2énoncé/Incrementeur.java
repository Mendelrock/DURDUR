package exo2énoncé;
public final class Incrementeur implements Runnable {

	private static Object cpt = 1;

	private String name;
	public Incrementeur(String name) {
		this.name = name;
	}

	public static int getValeur() {
		return (int) cpt;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (cpt){
				int c = (int) cpt;
				System.out.println("valeur à incrémenter (round " + i + ") : " + c + " par " + name);
				c = c + 1;
				System.out.println("valeur calculée (round " + i + ") par " + name + " est : " + cpt);
				cpt = c;
			}
		}
	}
}