package commandes;

import commerce.ICommande;

public class CdeOrdinaire implements ICommande {
	private int numéro;
	private double montant;
	public CdeOrdinaire(int numéro, double montant) {
		this.numéro = numéro;
		this.montant = montant;
	}
	@Override
	public double getMontant() { return montant;}
	@Override
	public int getNuméro() { return numéro;}
}
