package services;

import entreprise.ServiceExistantException;

/**
 * @author ouziri
 *
 */

public class ServAdministratif extends Service {

	private static ServAdministratif instance;
	
	private ServAdministratif(String nom) {
		super(nom);		
	}
	
	public static ServAdministratif getInstance(String nom) throws ServiceExistantException{
		if ( (instance != null) && (instance.getNom()!=nom) ) throw new ServiceExistantException("");
		if (instance == null) instance = new ServAdministratif(nom);
		return instance;
	}
	
	@Override
	public String getType() {		
		return "Administratif";
	}

	@Override
	public Service spawn(String nom) {
		// TODO Auto-generated method stub
		return null;
	}	
}
