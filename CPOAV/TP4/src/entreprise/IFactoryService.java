package entreprise;

public interface IFactoryService extends Iterable<IService> {
	public IService cr�erService(String nom, String type) throws IllegalArgumentException, ServiceExistantException;
}
