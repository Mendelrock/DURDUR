package etats;

import commandes.CommandeD�j�Pay�eEx;

public class Pay�e implements ICommande{

	private int numero;

	public Pay�e(int numero) {
		this.numero=numero;
	}

	@Override
	public ICommande payer() {
		throw new CommandeD�j�Pay�eEx();
	}

	@Override
	public ICommande livrer() {
		return new Livr�e(this.numero);
	}

	@Override
	public ICommande rembourser() {
		return new Cr��e(numero);
	}

	@Override
	public String getEtat() {
		return  "Pay�e";
	}

	@Override
	public int getNum�ro() {
		return this.numero;
	}
}
