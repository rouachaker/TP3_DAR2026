package Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import Serveur.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            InetAddress adresseServeur = InetAddress.getByName("127.0.0.1");
            InetSocketAddress serveur = new InetSocketAddress(adresseServeur, 1234);
            socket.connect(serveur);
            BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = entree.readLine();
            System.out.println("Message du serveur : " + message);
            socket.close();
        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}