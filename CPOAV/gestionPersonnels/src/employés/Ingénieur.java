package employ�s;

public class Ing�nieur extends Technicien{
	
	public Ing�nieur(String string, double i) {
		super(string, i);
	}
	
	@Override
	public double getSalaire() {
		return (getAbsences()<30)?(this.salaireContract+prime)*(30-getAbsences())/30:0;
	}
}
