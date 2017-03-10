package serv;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {
	public static void main(String args[]){
		try {
			new Serveur().run();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run()throws UnknownHostException, IOException{
		ServerSocket s = new ServerSocket(2000); // Set up receive socket
		Socket socket = s.accept();
		DataInputStream dIn = new DataInputStream(socket.getInputStream());
		
	
		boolean done = false;
		while(!done) {
			byte messageType = dIn.readByte();
	
			switch(messageType)
			{
			case 1: // Type A
				System.out.println("Message A: " + dIn.readUTF());
				break;
			case 2: // Type B
				System.out.println("Message B: " + dIn.readUTF());
				break;
			case 3: // Type C
				System.out.println("Message C [1]: " + dIn.readUTF());
				System.out.println("Message C [2]: " + dIn.readUTF());
				break;
			default:
				done = true;
			}
		}
		dIn.close();
	}
}