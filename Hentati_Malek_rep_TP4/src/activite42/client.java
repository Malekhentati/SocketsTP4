package activite42;
import java.io.*;
import java.net.*;
public class client {

	public static void main(String[] args) {
        try {
        	System.out.println("Je suis un client non conncté");
        	// Crée une nouvelle socket UDP pour le client
            DatagramSocket clientSocket = new DatagramSocket();
            // Adresse du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost");// Ici, "localhost" signifie que le serveur est sur la même machine
        	System.out.println("Je suis un client conncté");

            String request = "Demande de date ";
            byte[] sendData = request.getBytes();
            // Crée un paquet contenant les données à envoyer, l'adresse du serveur et le port
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1234);
            // Envoie le paquet au serveur
            clientSocket.send(sendPacket);
            // Réception de la réponse du serveur
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);// Attends la réponse du serveur
            // Convertit la réponse en une chaîne de caractères
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Date et heure fournies par le serveur: " + response);
            clientSocket.close();
        } catch (IOException e) {e.printStackTrace();}}}
            

