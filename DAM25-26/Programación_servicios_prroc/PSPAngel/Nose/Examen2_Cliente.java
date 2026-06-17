import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Examen2_Cliente {
    static int puerto = 6000;
    static String host = "localhost";

    static void main(String[] args) {
        try{
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor en " + host + ":" + puerto);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.print("Ingrese la clave de acceso: ");
            String clave = sc.nextLine();
            oos.writeUTF(clave);
            oos.flush();
            String accesso = ois.readUTF();
            if (accesso.equals("ACCESO_DENEGADO")) {
                System.out.println("Acceso denegado por el servidor. Cerrando conexión...");
                socket.close();
                return;
            }
            System.out.println("Acceso concedido por el servidor.");
            int idCliente = ois.readInt();
            System.out.println("ID de cliente recibido: " + idCliente);
            while (true) {
                System.out.print("Ingrese el ID del producto a solicitar: ");
                String idProducto = sc.nextLine();
                oos.writeObject(idProducto);
                oos.flush();
                if (idProducto.equals("*")) {
                    System.out.println("Cerrando conexión con el servidor...");
                    socket.close();
                    break;
                }
                String respuesta = (String) ois.readObject();
                System.out.println("Producto recibido: " + respuesta.toString());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
