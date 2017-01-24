package deco.decorateur;

import deco.commerce.ICommande;

public class CommandeUrgente extends CommandeOrdinaire{

	public CommandeUrgente(ICommande cde) {
		super(cde);
	}
	
	public CommandeUrgente(int numero, double montant) {
		super(numero, montant);
	}
	
	@Override
	public double getMontant(){
		return super.getMontant()*1.2;
	}
}
