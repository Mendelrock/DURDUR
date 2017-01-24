package composants.operations;

import arithmétique.IOperation;

public class Moins implements IOperation {
	private IOperation gauche;
	private IOperation droite;
	
	public Moins(IOperation gauche, IOperation droite){
		this.gauche = gauche;
		this.droite = droite;
	}
	
	@Override
	public double eval() {
		return gauche.eval()-droite.eval();
	}

}