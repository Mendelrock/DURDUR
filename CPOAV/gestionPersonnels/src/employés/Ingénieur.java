package employés;

public class Ingénieur extends Technicien{
	
	public Ingénieur(String string, double i) {
		super(string, i);
	}
	
	@Override
	public double getSalaire() {
		return (getAbsences()<30)?(this.salaireContract+prime)*(30-getAbsences())/30:0;
	}
}
