package appli;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import blti.ServeurBLTi;
import blti.Service;
import blti.ServiceRegistry;
import blti.ValidationException;

public class BLTiLaunch {

	// chargement dynamique d'un jarfile contenant une seule classe
	// cette classe impl�mente l'interface VerySimple

	private static final int PORT_SERVICE = 3000;

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);

		// URLClassLoader sur ftp
		String fileNameURL = "ftp://localhost:2121/";  // 
		URLClassLoader urlcl = URLClassLoader.newInstance(new URL[] {new URL(fileNameURL)});

		System.out.println("Bienvenue dans votre gestionnaire dynamique d'activit� BLTi");
		System.out.println("Pour ajouter une activit�, celle-ci doit �tre pr�sente sur votre serveur ftp");
		System.out.println("A tout instant, en tapant le nom de la classe, vous pouvez l'int�grer");
		System.out.println("Les clients se connectent au serveur 3000 pour lancer une activit�");

		new Thread(new ServeurBLTi(PORT_SERVICE)).start();

		while (true){
			try {
				String classeName = clavier.next();
				ServiceRegistry.addService(urlcl.loadClass(classeName).asSubclass(Service.class));
			} catch (ClassCastException e) {
				System.out.println("La classe doit impl�menter blti.Service");;
			}catch (ValidationException e) {
				System.out.println(e.getMessage());;
			} catch (ClassNotFoundException e) {
				System.out.println("La classe n'est pas sur le serveur ftp dans home"); 
			}
		}
	}
}
