package etats;

import exceptions.PatientPasEnAttente;
import exceptions.PatientPasEvalu�;
import hopital.IEtatPatient;
import hopital.Patient;

public class Affect� implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		return doc;
	}

	@Override
	public IEtatPatient �valuer(Patient pat) {
		throw new PatientPasEnAttente();
	}

	@Override
	public IEtatPatient affecter(String doc, Patient pat) {
		throw new PatientPasEvalu�();
	}

	@Override
	public IEtatPatient traiter(Patient pat) {
		return new Trait�();
	}
}
