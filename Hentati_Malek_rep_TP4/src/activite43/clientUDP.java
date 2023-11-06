package activite43;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class clientUDP {
	private static final int SERVER_PORT = 1234;
    private static final int CLIENT_PORT = 5678;
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(CLIENT_PORT);
            InetAddress serverAddress = InetAddress.getByName("localhost");

            System.out.println("Client connecté au serveur sur le port " + SERVER_PORT);
            System.out.print("Entrez votre nom d'utilisateur : ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();

            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        clientSocket.receive(receivePacket);

                        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println(message);
                    } 
                } catch (IOException e) { e.printStackTrace();}});
               receiveThread.start();

            while (true) {
                String message = scanner.nextLine();
                String fullMessage = "[" + username + "]: " + message;

                byte[] sendData = fullMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);}
            } catch (IOException e) {    e.printStackTrace();}}}
        
        
    

