package composants.valeurs;

import arithmétique.IOperation;

public class Pi implements IOperation{

	@Override
	public double eval() {
		return Math.PI;
	}

}
