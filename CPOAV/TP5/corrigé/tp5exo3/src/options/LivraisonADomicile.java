package options;

import commerce.CdeAvecOptions;
import commerce.ICommande;

public class LivraisonADomicile extends CdeAvecOptions {
	public LivraisonADomicile(ICommande commande) {
		super(commande);
	}
	@Override
	public double getMontant(){
		double montant = super.getMontant();
		if (montant < 50.0)
			montant += 5.0;
		else montant += 9.0;
		return montant;
	}
}
