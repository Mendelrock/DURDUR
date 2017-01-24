package entreprise;

public interface IFactoryService extends Iterable<IService> {
	public IService créerService(String nom, String type) throws IllegalArgumentException, ServiceExistantException;
}
