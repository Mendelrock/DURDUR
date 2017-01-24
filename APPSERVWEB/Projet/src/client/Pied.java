package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Pied {
	
	static String ADR_IP_BIBLIO = "1000";
	static int PORT_RESERVATION = 2500;
	void main(String[] args){
		Socket laSocket;
		BufferedReader socketIn;
		PrintWriter socketOut;
		try {
			laSocket = new Socket(ADR_IP_BIBLIO, PORT_RESERVATION);
			socketIn = new BufferedReader (new InputStreamReader(laSocket.getInputStream ( )));
			socketOut = new PrintWriter (laSocket.getOutputStream ( ), true);
			
			/* bonjour */
			
			System.out.println("Bienvenue sur votre syst�me de r�servation : ");
			System.out.println("Vous pouvez ici r�server un livre disponible ");
			System.out.println("et passer le chercher dans les 2 heures");
			
			/* saisie des donn�es */
			
			Scanner clavier = new Scanner(System.in);
			System.out.println("Votre num�ro d'abonn�, svp :");
			int numAbonn� = clavier.nextInt();
			System.out.println("Le num�ro de livre que vous souhaitez r�server :");
			int numDocument = clavier.nextInt();
			
			/* envoi des donn�es au service */
			
			socketOut.println(numAbonn�);
			socketOut.println(numDocument);
			
			/* r�ception de la r�ponse
			 * et affichage de cette r�ponse */
			
			System.out.println(socketIn.readLine());
			
			// fermeture de la connexion
			
			laSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}