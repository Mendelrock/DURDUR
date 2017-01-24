package commerce;

public abstract class CdeAvecOptions implements ICommande{
	private ICommande commande;
	public CdeAvecOptions(ICommande commande) {
		this.commande = commande;
	}
	@Override
	public double getMontant() {
		return commande.getMontant();
	}
	@Override
	public int getNuméro() {
		return commande.getNuméro();
	}
}
