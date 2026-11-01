package ClientHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import Serveur.*;

public class ClientHandler implements Runnable {
    private Socket socketClient;
    private int numeroClient;
    public ClientHandler(Socket socketClient, int numeroClient) {
        this.socketClient = socketClient;
        this.numeroClient = numeroClient;
    }
    public void run() {
        try {
            System.out.println("Client n°" + numeroClient + " connecté | Adresse : " + socketClient.getRemoteSocketAddress());
            PrintWriter sortie = new PrintWriter(socketClient.getOutputStream(), true);
            sortie.println("Bienvenue, vous êtes le client n°" + numeroClient);
            socketClient.close();
        } catch (IOException e) {
            System.out.println("Erreur avec le client n°" + numeroClient);
        }
    }
}