package serveur;

import java.io.IOException;

import outilserveur.Serveur;

public class AppliServeur {
	
	public static void main(String args[]){
		try {
			Class.forName(args[0]);
			new Serveur(Integer.parseInt(args[1])).start();
		} catch (NumberFormatException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
