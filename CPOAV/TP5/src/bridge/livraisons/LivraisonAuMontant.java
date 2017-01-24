package bridge.livraisons;

import bridge.commande.Commande;
import bridge.commande.ILivraison;

public class LivraisonAuMontant implements ILivraison {
	@Override
	public double getCout(Commande cde) {
		return cde.getMontant() * 0.10;
	}

}
