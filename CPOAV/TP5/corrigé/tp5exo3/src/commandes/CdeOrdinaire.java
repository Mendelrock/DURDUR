package commandes;

import commerce.ICommande;

public class CdeOrdinaire implements ICommande {
	private int num�ro;
	private double montant;
	public CdeOrdinaire(int num�ro, double montant) {
		this.num�ro = num�ro;
		this.montant = montant;
	}
	@Override
	public double getMontant() { return montant;}
	@Override
	public int getNum�ro() { return num�ro;}
}
