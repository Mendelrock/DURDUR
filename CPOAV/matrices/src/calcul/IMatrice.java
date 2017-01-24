package calcul;

public interface IMatrice {
	
	int getLargeur();

	int getHauteur();

	void set(int x, int y, int value);

	int get(int x, int y);

	double getTauxRemplissage();
	
	IMatrice optimiser();

}