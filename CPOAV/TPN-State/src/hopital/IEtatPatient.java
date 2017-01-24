package hopital;

public interface IEtatPatient {

	String getDoc(String doc);
	
	IEtatPatient �valuer(Patient pat);

	IEtatPatient affecter(String doc, Patient pat);

	IEtatPatient traiter(Patient pat);

}