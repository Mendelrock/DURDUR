package commerce;

public class CommandeOrdinaire implements ICommande {
	private int numéro;
	private double montant;
	public CommandeOrdinaire(int numéro, double montant) {
		this.numéro = numéro;
		this.montant = montant;
	}
	@Override
	public double getMontant() { return montant;}
	@Override
	public int getNuméro() { return numéro;}
}
