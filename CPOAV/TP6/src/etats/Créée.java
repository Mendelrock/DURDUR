package etats;

import commandes.CommandeNonLivrableEx;
import commandes.CommandeNonRemboursableEx;

public class Créée implements ICommande{

	private int numero;

	public Créée(int numero) {
		this.numero=numero;
	}

	@Override
	public ICommande payer() {
		return new Payée(this.numero);
	}

	@Override
	public ICommande livrer() {
		throw new CommandeNonLivrableEx();
	}

	@Override
	public ICommande rembourser() {
		throw new CommandeNonRemboursableEx ();
	}

	@Override
	public String getEtat() {
		return "Créée";
	}

	@Override
	public int getNuméro() {
		return this.numero;
	}

}
