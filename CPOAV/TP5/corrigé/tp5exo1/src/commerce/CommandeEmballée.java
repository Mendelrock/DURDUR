package commerce;

public class CommandeEmball�e implements ICommande{
	private ICommande commande;
	public CommandeEmball�e(ICommande commande) {
		this.commande = commande;
	}
	@Override
	public double getMontant() {
		return commande.getMontant();
	}
	@Override
	public int getNum�ro() {
		return commande.getNum�ro();
	}
}
