package com.safa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TerminalOperario {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 5000;

        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor");

            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            salida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            int idOperario = entrada.readInt();
            System.out.println("ID asignado: " + idOperario);
            System.out.println("Introduce ID del producto (* para salir)\n");

            Scanner sc = new Scanner(System.in);
            int idProducto;

            while (true) {
                System.out.print("ID Producto: ");
                String entradaTeclado = sc.nextLine();

                salida.writeUTF(entradaTeclado);

                if (entradaTeclado.equals("*")) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

                Producto producto = (Producto) entrada.readObject();

                System.out.println("\n=== DATOS DEL PRODUCTO ===");
                if (producto.getIdProducto() == -1) {
                    System.out.println(producto.getNombre());
                } else {
                    System.out.println("ID: " + producto.getIdProducto());
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Categoría: " + producto.getCat().getNombreCategoria() +
                                     " (ID: " + producto.getCat().getCondicionesAlmacenaje() + ")");
                    System.out.println("Proveedor: " + producto.getProv().getNombreEmpresa() +
                                     " (Días de entrega: " + producto.getProv().getDiasEntrega() + ")");
                }
                System.out.println();
            }

            sc.close();
            salida.close();
            entrada.close();
            socket.close();


        }catch (IOException|ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
