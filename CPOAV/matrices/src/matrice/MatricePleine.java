package matrice;

import java.util.Arrays;

import calcul.IMatrice;

public class MatricePleine extends Matrice {
	private int[][] tab;

	public MatricePleine(int hauteur, int largeur) {
		tab = new int[hauteur][largeur];
		for (int i = 0; i < hauteur; ++i)
			Arrays.fill(tab[i], 0);
	}

	public int getHauteur() {
		return tab.length;
	}

	public int getLargeur() {
		return tab[0].length;
	}

	@Override
	public void set(int x, int y, int valeur) {
		tab[x - 1][y - 1] = valeur;
	}

	@Override
	public int get(int x, int y) {
		return tab[x - 1][y - 1];
	}

	@Override
	public double getTauxRemplissage() {
		return getNbNonNuls() / (double) (getLargeur() * getHauteur());
	}

	@Override
	protected int getNbNonNuls() {
		int nonNuls = 0;
		for (int x = 1; x <= getHauteur(); ++x)
			for (int y = 1; y <= getLargeur(); ++y)
				if (get(x, y) != 0)
					++nonNuls;
		return nonNuls;
	}

	@Override
	public IMatrice optimiser() {
		if(getTauxRemplissage() < seuilCreuse)
			return FMatrice.versCreuse(this);
		else
			return this;
	}
}
