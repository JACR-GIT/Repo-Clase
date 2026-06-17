import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Examen2_Servidor {
    static int puerto = 6000;
    static int operariosConectados = 0;
    static Producto[] productos;

    static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);
            inicializarDatos();
            while (true) {
                Socket socket = serverSocket.accept();
                operariosConectados++;
                System.out.println("Operario conectado. ID: " + operariosConectados);
                HiloServidor hilo = new HiloServidor(socket, operariosConectados);
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HiloServidor extends Thread {
        Socket socket;
        int idCliente;

        public HiloServidor(Socket socket, int idCliente) {
            this.socket = socket;
            this.idCliente = idCliente;
        }

        public void run() {
            try {
                System.out.println("Manejando operario ID: " + idCliente);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.flush();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String clave = ois.readUTF();
                System.out.println("Operario ID: " + idCliente + " proporcionó la clave: " + clave);
                if (!clave.equals("LOGISTICA2026")) {
                    oos.writeUTF("ACCESO_DENEGADO");
                    oos.flush();
                    System.out.println("Operario ID: " + idCliente + " proporcionó una clave incorrecta. Desconectando...");
                    socket.close();
                    return;
                }
                oos.writeUTF("ACCESO_CONCEDIDO");
                oos.flush();
                oos.writeInt(idCliente);
                oos.flush();
                while (true) {
                    String idProducto = (String) ois.readObject();
                    System.out.println("ID de producto recibido: " + idProducto);
                    if (idProducto.equals("*")) {
                        System.out.println("Operario ID: " + idCliente + " se desconectó.");
                        socket.close();
                        break;
                    }
                    Producto producto = obtenerProductos(idProducto);
                    System.out.println("Operario ID: " + idCliente + " solicitó producto ID: " + idProducto);
                    System.out.println("Producto encontrado: " + producto);

                    if (producto != null) {
                        oos.writeObject(producto.toString());
                    } else {
                        oos.writeObject(new Producto(-1, "No encontrado", new Categoria("no existe", "nada"), new Proveedor("SIN EXISTENCIA", -1)).toString());
                    }
                }
                oos.close();
                ois.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void inicializarDatos() {
        Categoria cat1 = new Categoria("Electrónica", "Mantener en seco");
        Categoria cat2 = new Categoria("Perecederos", "Refrigerar < 5°C");
        Proveedor prov1 = new Proveedor("Tech Supplies", 5);
        Proveedor prov2 = new Proveedor("Fresh Foods", 2);

        productos = new Producto[3];
        productos[0] = new Producto(1, "Smartphone", cat1, prov1);
        productos[1] = new Producto(2, "Laptop", cat1, prov1);
        productos[2] = new Producto(3, "Leche", cat2, prov2);

    }

    static Producto obtenerProductos(String idProducto) {
        if (idProducto == null) {
            return null;
        }
        for (Producto p : productos) {
            if (String.valueOf(p.getIdProducto()).equals(idProducto)) {
                return p;
            }
        }
        return null;
    }
}
