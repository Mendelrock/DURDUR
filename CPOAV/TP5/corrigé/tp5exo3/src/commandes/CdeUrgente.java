package commandes;

public class CdeUrgente extends CdeOrdinaire {
	public CdeUrgente(int numéro, double montant) {
		super(numéro, montant);
	}
	@Override
	public double getMontant(){
		return super.getMontant() *1.20;
	}
}
