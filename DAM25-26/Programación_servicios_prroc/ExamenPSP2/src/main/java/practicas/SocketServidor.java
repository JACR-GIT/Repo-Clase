package practicas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
    static void main() throws IOException {
        int puerto = 6000;
        ServerSocket servidor = null;

        servidor = new ServerSocket(puerto);

        System.out.println("Servidor Iniciado");
        System.out.println("Esperando primer cliente...");

        Socket cliente1 = servidor.accept();
        mostrarInfoCliente(cliente1, 1);

        System.out.println("Esperando segundo cliente...");

        Socket cliente2 = servidor.accept();
        mostrarInfoCliente(cliente2, 2);

        System.out.println("Se conectaron los 2 clientes. Fin del servidor.");

        cliente1.close();
        cliente2.close();
        servidor.close();
    }

    private static void mostrarInfoCliente(Socket cliente, int numero) throws IOException {
        System.out.println("\nCliente " + numero + " conectado:");
        System.out.println("Puerto local del servidor: " + cliente.getLocalPort());
        System.out.println("Puerto remoto del cliente: " + cliente.getPort());
        System.out.println("IP del cliente: " + cliente.getInetAddress().getHostAddress());
        System.out.println("Nombre host cliente: " + cliente.getInetAddress().getHostName());
    }
}
