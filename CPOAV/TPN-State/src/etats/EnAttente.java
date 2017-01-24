package etats;

import exceptions.PatientPasAffecté;
import exceptions.PatientPasEvalué;
import hopital.IEtatPatient;
import hopital.Patient;

public class EnAttente implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		throw new PatientPasAffecté();
	}

	@Override
	public IEtatPatient évaluer(Patient pat) {
		if (pat.getGravité()>3){
			pat.setDoc("Dr House");
			return new Affecté();
		}
		return new Evalué();
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
