package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String args[]){
		try {
			new Client().run();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() throws UnknownHostException, IOException{
		ServerSocket s = new ServerSocket(2000); // Create and connect the socket
		Socket socket = s.accept();
		DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
	
		// Send first message
		dOut.writeByte(1);
		dOut.writeUTF("This is the first type of message.");
		dOut.flush(); // Send off the data
	
		// Send the second message
		dOut.writeByte(2);
		dOut.writeUTF("This is the second type of message.");
		dOut.flush(); // Send off the data
	
		// Send the third message
		dOut.writeByte(3);
		dOut.writeUTF("This is the third type of message (Part 1).");
		dOut.writeUTF("This is the third type of message (Part 2).");
		dOut.flush(); // Send off the data
	
		// Send the exit message
		dOut.writeByte(-1);
		dOut.flush();
	
		dOut.close();
	}
}
