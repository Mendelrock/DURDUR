package deco.livraison;

import deco.commerce.ICommande;
import deco.decorateur.CommandeOrdinaire;

public class LivraisonADomicile extends CommandeOrdinaire{
	
	private final static double surcoutBas = 5.0;
	private final static double surcoutHaut = 9.0;
	
	public LivraisonADomicile(ICommande cde) {
		super(cde);
	}
	
	@Override
	public double getMontant(){
		if (super.getMontant()<50)
			return super.getMontant() + surcoutBas;
		return super.getMontant() + surcoutHaut;
	}
}
