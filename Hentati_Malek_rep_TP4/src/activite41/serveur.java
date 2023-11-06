package activite41;
import java.io.*;
import java.net.*;
public class serveur {

	final static int PORT=1234;
	private static byte[] buffer = new byte[1024];
	
	public static void main(String[] args) {
		try {
			DatagramSocket Socket = new DatagramSocket(PORT);
			System.out.println("Démarrage du Server");
			
			while(true) {
				 DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				 Socket.receive(packet);
				 
				 String username = new String(packet.getData(), 0, packet.getLength());
				 String message = "Bienvenue " + username;
				 
				 DatagramPacket messageTOSend = new DatagramPacket(message.getBytes(), message.length(), packet.getAddress(), packet.getPort());
				 Socket.send(messageTOSend);
			}
			
		} catch (IOException e) {e.printStackTrace();}}}
			
		
		
		
	

