package composants.valeurs;

import arithm�tique.IOperation;

public class Pi implements IOperation{

	@Override
	public double eval() {
		return Math.PI;
	}

}
