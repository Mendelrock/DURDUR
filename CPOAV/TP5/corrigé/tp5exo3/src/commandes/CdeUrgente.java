package commandes;

public class CdeUrgente extends CdeOrdinaire {
	public CdeUrgente(int num�ro, double montant) {
		super(num�ro, montant);
	}
	@Override
	public double getMontant(){
		return super.getMontant() *1.20;
	}
}
