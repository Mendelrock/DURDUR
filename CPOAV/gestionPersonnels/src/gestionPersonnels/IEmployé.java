package gestionPersonnels;

public interface IEmployé {
	
	static double prime = 1000.0;
	
	String getNom();

	double getSalaire();

	int getAbsences();

	void setAbsences(int i);

}
