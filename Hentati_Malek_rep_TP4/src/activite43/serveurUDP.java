package activite43;
import java.io.*;
import java.net.*;
import java.util.*;
public class serveurUDP {
    private static final int PORT = 1234;
    private static Set<InetSocketAddress> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);

            System.out.println("Serveur en écoute sur le port " + PORT);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                InetSocketAddress clientSocket = new InetSocketAddress(clientAddress, clientPort);

                if (!clients.contains(clientSocket)) {
                    clients.add(clientSocket);
                }

                System.out.println("Message reçu de " + clientSocket + ": " + message);

                // Diffusion du message à tous les clients
                for (InetSocketAddress client : clients) {
                    if (!client.equals(clientSocket)) {
                        DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(), client);
                        serverSocket.send(sendPacket);}}}
                    } catch (IOException e) {e.printStackTrace();}}}
                
            
        
            
        
    

