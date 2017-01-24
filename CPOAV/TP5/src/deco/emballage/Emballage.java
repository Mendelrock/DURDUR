package deco.emballage;

import deco.commerce.ICommande;
import deco.decorateur.CommandeOrdinaire;

public class Emballage extends CommandeOrdinaire {
	
	private final static double surcout = 3.0;
	
	public Emballage(ICommande cde) {
		super(cde);
	}
	
	@Override
	public double getMontant(){
		return super.getMontant() + surcout;
	}
}
