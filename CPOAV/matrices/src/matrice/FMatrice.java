package matrice;

import calcul.IFMatrice;
import calcul.IMatrice;

public class FMatrice implements IFMatrice {
	
	@Override
	public IMatrice create(int hauteur, int largeur){
		return new MatriceCreuse(hauteur, largeur);
	}
	
	public static MatriceCreuse versCreuse(MatricePleine m) {
		MatriceCreuse mc = new MatriceCreuse(m.getHauteur(), m.getLargeur());
		for (int x = 1; x <= m.getHauteur(); ++x)
			for (int y = 1; y <= m.getLargeur(); ++y)
				mc.set(x, y, m.get(x, y));
		return mc;
	}
	
	public static MatricePleine versPleine(MatriceCreuse m) {
		MatricePleine mp = new MatricePleine(m.getHauteur(), m.getLargeur());
		for (int x = 1; x <= m.getHauteur(); ++x)
			for (int y = 1; y <= m.getLargeur(); ++y)
				mp.set(x, y, m.get(x, y));
		return mp;
	}
}
