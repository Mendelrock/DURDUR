package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entreprise.IFactoryService;
import entreprise.IService;
import entreprise.ServiceExistantException;

public class FactoryService implements IFactoryService {
	private static List<IService> sortes = new ArrayList<>();
	static{
		sortes.add(new ServTechnique("prototype de service technique"));
	}
	public Service créerService(String nom, String type) throws IllegalArgumentException, ServiceExistantException {
		for(IService s : this){
			if (s.getType().equals(type))
				return s.spawn(nom);
		}
		throw new IllegalArgumentException (type);
	}
	
	@Override
	public Iterator<IService> iterator() {
		return sortes.iterator();
	}
}
