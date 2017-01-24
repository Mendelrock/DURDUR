package options;

import commerce.CdeAvecOptions;
import commerce.ICommande;

public class Emballage extends CdeAvecOptions{
	public Emballage(ICommande commande) {
		super(commande);
	}
	@Override
	public double getMontant(){
		return super.getMontant() +3.0;
	}
}
