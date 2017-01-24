package bridge_livraisons;

import bridge_commande.Commande;
import bridge_commande.ILivraison;

public class LivraisonAuMontant implements ILivraison {
	@Override
	public double getCout(Commande cde) {
		return cde.getMontant() * 0.10;
	}

}
