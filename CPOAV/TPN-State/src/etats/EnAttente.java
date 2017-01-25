package etats;

import exceptions.PatientPasAffect�;
import exceptions.PatientPasEvalu�;
import hopital.IEtatPatient;
import hopital.Patient;

public class EnAttente implements IEtatPatient {

	@Override
	public String getDoc(String doc) {
		throw new PatientPasAffect�();
	}

	@Override
	public IEtatPatient �valuer(Patient pat) {
		if (pat.getGravit�()>3){
			pat.setDoc("Dr House");
			return new Affect�();
		}
		return new Evalu�();
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