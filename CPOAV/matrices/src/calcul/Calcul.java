package calcul;

public class Calcul {
	// sous ce seuil la matrice devrait etre creuse
	private IMatrice m;

	public Calcul(int hauteur, int largeur, IFMatrice f) {
		m = f.create(hauteur, largeur);
	}

	public void set(int x, int y, int valeur) {
		m.set(x, y, valeur);
	}

	public int get(int x, int y) {
		return m.get(x, y);
	}
	
	public IMatrice getMatrice(){
		return m;
	}

	public void optimiser() {
		m.optimiser();
	}
}
