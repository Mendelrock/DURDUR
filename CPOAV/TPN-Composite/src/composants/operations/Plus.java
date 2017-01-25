package composants.operations;

import arithm�tique.IOperation;

public class Plus implements IOperation {
	private IOperation gauche;
	private IOperation droite;
	
	public Plus(IOperation gauche, IOperation droite){
		this.gauche = gauche;
		this.droite = droite;
	}
	
	@Override
	public double eval() {
		return gauche.eval()+droite.eval();
	}

}