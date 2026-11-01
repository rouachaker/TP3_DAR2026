package Serveur;
import Client.cli;
import ClientHandler.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Op.Operation;

public class serv {


    private static int compteurOperations = 0;

    public static synchronized int incrementerCompteur() {
        compteurOperations++;
        return compteurOperations;
    }

    public static void main(String[] args) {

        int port = 1234;
        int numeroClient = 0;

        try (ServerSocket serveur = new ServerSocket(port)) {

            System.out.println("Serveur calculatrice demarre.");
            System.out.println("En attente des clients...");

            while (true) {

                Socket socketClient = serveur.accept();
                numeroClient++;

                System.out.println("Client n°" + numeroClient + " connecte : " + socketClient.getRemoteSocketAddress());

                clip traitement = new clip(socketClient, numeroClient);

                Thread thread = new Thread(traitement);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}