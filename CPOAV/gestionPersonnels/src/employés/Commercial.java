package employés;

public class Commercial extends Technicien {
	
	public Commercial(String string, double i) {
		super(string, i);
	}
	
	@Override
	public double getSalaire() {
		return (getAbsences()<4)?this.salaireContract*(4-getAbsences()):0;
	}

}
