package etats;

import exceptions.PatientPasAffect�;
import exceptions.PatientPasEnAttente;
import exceptions.PatientPasEvalu�;
import hopital.IEtatPatient;
import hopital.Patient;

public class Trait� implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		throw new PatientPasAffect�();
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
		throw new PatientPasAffect�();
	}

}
