package options;

import commerce.CdeAvecOptions;
import commerce.ICommande;

public class LivraisonEnPtDeRetrait extends CdeAvecOptions {
	private String pointDeRetrait;
	public LivraisonEnPtDeRetrait(ICommande commande, String pointDeRetrait) {
		super(commande);
		this.pointDeRetrait = pointDeRetrait;
	}
	public String getPointDeRetrait() { return pointDeRetrait;}
	@Override
	public double getMontant() {
		return super.getMontant() +2.0;
	}
}
