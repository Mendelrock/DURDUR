package services;

/**
 * @author ouziri
 * @version 1.0 
 *
 */

public class ServTechnique extends Service {
	public ServTechnique (String nom) {
		super(nom);		
	}	
	
	@Override
	public String getType() {	
		return "Technique";
	}

	@Override
	public Service spawn(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
}
