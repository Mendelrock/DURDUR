package deco.decorateur;

import deco.commerce.ICommande;

public class CommandeOrdinaire implements ICommande {
	private int numero;
	private double montant;

	public CommandeOrdinaire(int numero, double montant) {
		this.numero = numero;
		this.montant = montant;
	}

	public CommandeOrdinaire(ICommande cde) {
		this(cde.getNumero(),cde.getMontant());
	}

	/* (non-Javadoc)
	 * @see exo1.decorateur.ICommande#getNumero()
	 */
	@Override
	public int getNumero() {
		return this.numero;
	}

	/* (non-Javadoc)
	 * @see exo1.decorateur.ICommande#getMontant()
	 */
	@Override
	public double getMontant() {
		return this.montant;
	}
}
