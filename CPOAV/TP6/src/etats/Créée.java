package etats;

import commandes.CommandeNonLivrableEx;
import commandes.CommandeNonRemboursableEx;

public class Cr��e implements ICommande{

	private int numero;

	public Cr��e(int numero) {
		this.numero=numero;
	}

	@Override
	public ICommande payer() {
		return new Pay�e(this.numero);
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
		return "Cr��e";
	}

	@Override
	public int getNum�ro() {
		return this.numero;
	}

}
