package bridge_commande;

public class Commande {
	private ILivraison livraison  = null;
	private double poids;
	private double montant;
	public Commande(double poids, double montant) {
		this.poids = poids;
		this.montant = montant;
	}
	public void setLivraison(ILivraison livraison) {
		this.livraison = livraison;
	}
	public double getMontant() {return montant;}
	public ILivraison getLivraison() { return livraison;}
	public double getMontantTotal() {
		if (livraison == null)
			return montant;
		return montant + livraison.getCout(this);
	}
	public double getPoids() { return poids;}
}
