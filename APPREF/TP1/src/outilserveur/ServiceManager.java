package outilserveur;

import java.net.Socket;

public class ServiceManager {

	
	// attribut static Class
	
	private static Class<? extends Service> classe;
	
	// m�thode statique init
	
	public static void init(Class<? extends Service> classe) throws InstantiationException, IllegalAccessException{
		classe.newInstance();
		ServiceManager.classe=classe;
	}
	
	// m�thode statique newService
	
	public static Service newService(Socket client_socket) {	
		Service service = null;
		try {
			service = classe.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		service.setSocket(client_socket);
		return service;
	}
}
