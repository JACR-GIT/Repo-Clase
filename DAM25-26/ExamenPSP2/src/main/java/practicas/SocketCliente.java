package practicas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketCliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        Socket cliente = new Socket(host, puerto);

        InetAddress i = cliente.getInetAddress();

        System.out.println("Cliente puerto local: " + cliente.getLocalPort());
        System.out.println("Servidor puerto remoto: " + cliente.getPort());
        System.out.println("IP Host remoto: " + i.getHostAddress());
        System.out.println("Host remoto: " + i.getHostName());

        cliente.close();
    }
}