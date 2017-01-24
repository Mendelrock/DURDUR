package commandes;

import java.util.GregorianCalendar;

public class Commande{
	
	private int numero;
	private GregorianCalendar dateLiv = null;
	private boolean payee = false;
	
	public void payer() {
		if (payee)
			throw new CommandeD�j�Pay�eEx();
		this.payee = true;
	}
	
	public String getEtat() {
		if (payee == false)
			return "Cr��e";
		else if (dateLiv == null)
			return  "Pay�e";
		else return "Livr�e";
	}
	
	public int getNum�ro() {
		return numero;
	}
	
	public Commande(int numero) {
		this.numero = numero;
		this.payee = false;
	}
	
	public void livrer(){
		if (! this.payee)
			throw new CommandeNonLivrableEx();
		this.dateLiv = new GregorianCalendar();
	}

	public void rembourser() {
		if (! this.payee || this.dateLiv != null)
			throw new CommandeNonRemboursableEx ();
		this.payee = false;
	}
}