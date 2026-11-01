package Serveur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import ClientHandler.ClientHandler;

public class Serveur {
    public static void main(String[] args) {
        int port = 1234;
        int numeroClient = 0;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur démarré sur le port " + port);
            System.out.println("En attente des clients...");
            while (true) {
                Socket socketClient = serverSocket.accept();
                numeroClient++;
                Runnable clientHandler = new ClientHandler(socketClient, numeroClient);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch(IOException e){
                    System.out.println("Erreur serveur : " + e.getMessage());}
            }}
