package airCountry;

public class Aeroport {
	private String nom;
	private int abscisse;
	public Aeroport (String nom, int abscisse) {
		this.nom = nom;
		this.abscisse = abscisse;
	}
	public int getCoordonn�es() {return this.abscisse;}
	@Override
	public String toString() { return nom;}
	public int getDistance(Aeroport dest) {
		return(Math.abs(dest.getCoordonn�es() - getCoordonn�es()));
		
	}
}
