package employés;

import gestionPersonnels.IEmployé;

public class Technicien implements IEmployé {

	protected String nom;
	protected double salaireContract;
	protected int nbAbsences;
	
	public Technicien(String string, double i) {
		this.nom = string;
		this.salaireContract = i;
		this.nbAbsences = 0;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public double getSalaire() {
		return (getAbsences()<60)?this.salaireContract*(60-getAbsences())/60:0;
	}

	@Override
	public int getAbsences() {
		return this.nbAbsences;
	}

	@Override
	public void setAbsences(int i) {
		this.nbAbsences += i;
	}

}
