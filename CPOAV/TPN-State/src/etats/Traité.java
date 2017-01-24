package etats;

import exceptions.PatientPasAffecté;
import exceptions.PatientPasEnAttente;
import exceptions.PatientPasEvalué;
import hopital.IEtatPatient;
import hopital.Patient;

public class Traité implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		throw new PatientPasAffecté();
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
		throw new PatientPasAffecté();
	}

}
