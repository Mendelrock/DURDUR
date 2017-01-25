package bridge.livraisons;

import bridge.commande.Commande;
import bridge.commande.ILivraison;

public class LivraisonAuPoids implements ILivraison {
	@Override
	public double getCout(Commande cde) {
		if (cde.getPoids() <= 1.0)
			return 5.0;
		else if (cde.getPoids() <= 2.0)
			return 8.0;
		else return 15.0;
	}

}