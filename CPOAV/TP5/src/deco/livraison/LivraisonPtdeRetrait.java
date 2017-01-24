package deco.livraison;

import deco.commerce.ICommande;
import deco.decorateur.CommandeOrdinaire;

public class LivraisonPtdeRetrait  extends CommandeOrdinaire{
	
	private final static double surcout = 2.0;
	
	public LivraisonPtdeRetrait(ICommande cde) {
		super(cde);
	}
	
	@Override
	public double getMontant(){
		return super.getMontant() + surcout;
	}
}
