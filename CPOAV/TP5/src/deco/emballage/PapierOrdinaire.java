package deco.emballage;

import deco.commerce.ICommande;

public class PapierOrdinaire extends Emballage{
	
	private final static double surcout = 2.0;
	
	public PapierOrdinaire(ICommande cde) {
		super(cde);
	}

	@Override
	public double getMontant(){
		return super.getMontant() + surcout;
	}
}
