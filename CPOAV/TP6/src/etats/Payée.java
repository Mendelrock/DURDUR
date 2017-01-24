package etats;

import commandes.CommandeDéjàPayéeEx;

public class Payée implements ICommande{

	private int numero;

	public Payée(int numero) {
		this.numero=numero;
	}

	@Override
	public ICommande payer() {
		throw new CommandeDéjàPayéeEx();
	}

	@Override
	public ICommande livrer() {
		return new Livrée(this.numero);
	}

	@Override
	public ICommande rembourser() {
		return new Créée(numero);
	}

	@Override
	public String getEtat() {
		return  "Payée";
	}

	@Override
	public int getNuméro() {
		return this.numero;
	}
}
