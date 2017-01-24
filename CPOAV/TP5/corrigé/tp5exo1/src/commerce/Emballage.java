package commerce;

public class Emballage extends CommandeEmballée{
	public Emballage(ICommande commande) {
		super(commande);
	}
	@Override
	public double getMontant(){
		return super.getMontant() +3.0;
	}
}
