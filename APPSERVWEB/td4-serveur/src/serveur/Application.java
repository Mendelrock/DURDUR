package serveur;

import java.io.IOException;

public class Application {
	private final static int PORT = 1000;
	
	public static void main(String[] args){
		try{
			new Serveur(PORT).lancer();
			System.out.println("Serveur lanc� sur le port " + PORT);
		} catch (IOException e) {
			System.err.println("Pb lors de la cr�ation du serveur : " + e);
		}
	}
}
