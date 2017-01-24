package matrice;

import java.util.HashMap;
import java.util.Map;

import calcul.IMatrice;

public class MatriceCreuse extends Matrice {
	private Map<XY, Integer> elements;
	private int hauteur;
	private int largeur;

	public MatriceCreuse(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		elements = new HashMap<XY, Integer>();
	}

	/* (non-Javadoc)
	 * @see matrice.IMatrice#getLargeur()
	 */
	@Override
	public int getLargeur() {
		return largeur;
	}

	/* (non-Javadoc)
	 * @see matrice.IMatrice#getHauteur()
	 */
	@Override
	public int getHauteur() {
		return hauteur;
	}

	/* (non-Javadoc)
	 * @see matrice.IMatrice#set(int, int, int)
	 */
	@Override
	public void set(int x, int y, int value) {
		if (x < 1 || x > getHauteur() || y < 1 || y > getLargeur())
			throw new IndexOutOfBoundsException();
		XY xy = new XY(x, y);
		if (value != 0)
			elements.put(xy, value);
		else
			elements.remove(xy);
	}

	/* (non-Javadoc)
	 * @see matrice.IMatrice#get(int, int)
	 */
	@Override
	public int get(int x, int y) {
		if (x < 1 || x > getHauteur() || y < 1 || y > getLargeur())
			throw new IndexOutOfBoundsException();
		XY xy = new XY(x, y);
		if (!elements.containsKey(xy))
			return 0;
		else
			return elements.get(xy).intValue();
	}

	/* (non-Javadoc)
	 * @see matrice.IMatrice#getTauxRemplissage()
	 */
	@Override
	public double getTauxRemplissage() {
		return getNbNonNuls() / (double) (getLargeur() * getHauteur());
	}
	
	@Override
	protected int getNbNonNuls() {
		return elements.size();
	}

	private static class XY {
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || !(o instanceof XY))
				return false;
			else {
				XY xy = (XY) o;
				return (x == xy.x && y == xy.y);
			}
		}

		@Override
		public int hashCode() { // nécessaire pour être dans une HashMap
			return (x * 101) ^ y; // par exemple
		}

		private int x;
		private int y;
	}

	@Override
	public IMatrice optimiser() {
		if(getTauxRemplissage() >= seuilCreuse)
			return FMatrice.versPleine(this);
		else
			return this;
	}
}
