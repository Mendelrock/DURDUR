package deco.emballage;

import deco.commerce.ICommande;

public class PapierCadeau extends Emballage{
	
	private final static double surcout = 6.0;
	
	public PapierCadeau(ICommande cde) {
		super(cde);
	}
	
	@Override
	public double getMontant(){
		return super.getMontant() + surcout;
	}
}
