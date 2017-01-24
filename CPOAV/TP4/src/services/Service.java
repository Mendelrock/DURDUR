package services;

import entreprise.IService;

/**
 * @author ouziri
 * légèrement modifié par Mikal
 *
 */

public abstract class Service implements IService {
	private String nom ;
	
	public Service (String nom) {
		this.nom = nom;
	}
	/* (non-Javadoc)
	 * @see entreprise.IService#getType()
	 */
	@Override
	public abstract String getType();
	/* (non-Javadoc)
	 * @see entreprise.IService#getNom()
	 */
	@Override
	public String getNom(){
		return this.nom;
	}
	/* (non-Javadoc)
	 * @see entreprise.IService#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom){
		this.nom = nom ;
	}	
}
