package entreprise;

import services.Service;

public interface IService {

	String getType();

	String getNom();

	void setNom(String nom);

	Service spawn(String nom);

}