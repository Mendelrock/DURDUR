package hopital;

import etats.EnAttente;

public class Patient {
	//private String nomEtat;
	private String nom;
	private String doc;
	private int gravit�;
	private IEtatPatient �tat;

	public Patient(String nom, int gravit�) {
		this.nom = nom;
		this.gravit� = gravit�;
		//this.nomEtat = "En Attente";
		this.doc = null;
		this.�tat = new EnAttente();
	}
	
	public String getNomEtat() { 
		return �tat.getClass().getSimpleName();
	}

	public String getNom() { 
		return nom; 
	}

	public String getDoc() { 
		return �tat.getDoc(this.doc);
	}
	
	public void setDoc(String doc){
		this.doc = doc;
	}

	public int getGravit�() {
		return gravit�; 
	}

	public void �valuer () {
		�tat = �tat.�valuer(this);
	}

	public void affecter(String doc) {
		�tat = �tat.affecter(doc, this);
	}

	public void traiter() {
		�tat = �tat.traiter(this);
	}
}

