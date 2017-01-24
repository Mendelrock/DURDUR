package etats;

import exceptions.PatientPasEnAttente;
import exceptions.PatientPasEvalué;
import hopital.IEtatPatient;
import hopital.Patient;

public class Affecté implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		return doc;
	}

	@Override
	public IEtatPatient évaluer(Patient pat) {
		throw new PatientPasEnAttente();
	}

	@Override
	public IEtatPatient affecter(String doc, Patient pat) {
		throw new PatientPasEvalué();
	}

	@Override
	public IEtatPatient traiter(Patient pat) {
		return new Traité();
	}
}
