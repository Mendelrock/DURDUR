package composants.operations;

import arithm�tique.IOperation;

public class Op�ration implements IOperation {
	private char op�rateur;
	private IOperation gauche;
	private IOperation droite;
	
	public Op�ration(char op�rateur, IOperation gauche, IOperation droite) { 
		this.op�rateur = op�rateur;
		this.gauche = gauche;
		this.droite = droite;
	}
	
	/* (non-Javadoc)
	 * @see arithm�tique.IOperation#eval()
	 */
	@Override
	public double eval() {
		if (op�rateur == '+')
			return gauche.eval() + droite.eval();
		else assert false : "op�ration inconnue";
		return 0.;
	}
}