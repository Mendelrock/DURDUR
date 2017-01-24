package entreprise;


/**
 * @author ouziri
 *
 */

@SuppressWarnings("serial")
public class ServiceExistantException extends RuntimeException {

	public ServiceExistantException(String nom) {
		super(nom);	
	}
}
