package commerce;

public class CommandeOrdinaire implements ICommande {
	private int num�ro;
	private double montant;
	public CommandeOrdinaire(int num�ro, double montant) {
		this.num�ro = num�ro;
		this.montant = montant;
	}
	@Override
	public double getMontant() { return montant;}
	@Override
	public int getNum�ro() { return num�ro;}
}
