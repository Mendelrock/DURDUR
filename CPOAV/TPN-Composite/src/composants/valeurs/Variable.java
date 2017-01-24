package composants.valeurs;

import arithm�tique.IOperation;

public class Variable implements IOperation {
	private double valeur = 0.;

	public Variable( double valeur ) { 
		this.valeur = valeur; 
	}

	@Override
	public double eval() {
		return valeur;
	}
}