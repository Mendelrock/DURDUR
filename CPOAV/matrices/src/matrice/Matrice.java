package matrice;

import calcul.IMatrice;

public abstract class Matrice implements IMatrice{
	protected double seuilCreuse = 0.2;

	public abstract int getLargeur();
	
	public abstract int getHauteur();
	
	public abstract void set(int x, int y, int value);

	public abstract int get(int x, int y);
	
	/* (non-Javadoc)
	 * @see matrice.IMatrice#getTauxRemplissage()
	 */
	@Override
	public double getTauxRemplissage() {
		return getNbNonNuls() / (double) (getLargeur() * getHauteur());
	}

	protected abstract int getNbNonNuls();
	
	public abstract IMatrice optimiser();
}
