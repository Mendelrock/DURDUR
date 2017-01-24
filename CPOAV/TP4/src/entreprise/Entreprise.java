package entreprise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ouziri
 *
 */

public class Entreprise implements Iterable<IService>{
	List<IService> _Services = new ArrayList<IService>();
	IFactoryService f;
	
	public Entreprise(IFactoryService f){
		this.f=f;
	}
	
	public void useFactory(IFactoryService f){
		this.f=f;
	}
	
	// Ajout d'un service
	public void addService (String nom, String type) throws IllegalArgumentException, ServiceExistantException {
		IService service = f.créerService(nom, type);
		if (this.searchServiceByNom(nom) != null)
			throw new ServiceExistantException (nom);
		this._Services.add(service);		
	}
	
	// Recherche de services par nom (clé de gestion)
	public IService searchServiceByNom (String nom){		
		for (IService service : _Services)
			if (service.getNom().equals(nom))
				return service;
		return null;
	}

	@Override
	public Iterator<IService> iterator() {
		return _Services.iterator();
	}	
}
