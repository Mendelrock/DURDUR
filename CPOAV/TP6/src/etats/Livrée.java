package etats;

import java.util.GregorianCalendar;

import commandes.CommandeD�j�Pay�eEx;
import commandes.CommandeNonLivrableEx;
import commandes.CommandeNonRemboursableEx;

public class Livr�e implements ICommande {

	private int numero;
	private GregorianCalendar dateLiv;

	public Livr�e(int numero) {
		this.numero=numero;
		this.dateLiv=new GregorianCalendar();
	}

	/* (non-Javadoc)
	 * @see etats.ICommande#getNum�ro()
	 */
	@Override
	public int getNum�ro() {
		return numero;
	}
	
	@Override
	public ICommande payer() {
		throw new CommandeD�j�Pay�eEx();
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
		return "Livr�e";
	}

}
