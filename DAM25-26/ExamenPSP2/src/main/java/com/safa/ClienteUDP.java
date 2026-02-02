package com.safa;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 9876;

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName(host);

            Scanner teclado = new Scanner(System.in);
            String idCliente;

            System.out.println("Cliente UDP conectado");
            System.out.println("Introduce ID del Cliente (* para salir)\n");

            while (true) {
                System.out.print("ID Cliente: ");
                idCliente = teclado.nextLine();

                if (idCliente.equals("*")) {
                    System.out.println("Saliendo...");
                    break;
                }


                byte[] bufferEnvio = idCliente.getBytes();
                DatagramPacket paqueteEnvio = new DatagramPacket(
                    bufferEnvio, bufferEnvio.length, direccion, puerto);
                socket.send(paqueteEnvio);

                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paqueteRecepcion = new DatagramPacket(
                    bufferRecepcion, bufferRecepcion.length);
                socket.receive(paqueteRecepcion);

                ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                Cliente cliente = (Cliente) ois.readObject();

                System.out.println("\n=== DATOS DEL Cliente ===");
                if (cliente.getId() == -1) {
                    System.out.println(cliente.getNombre());
                } else {
                    System.out.println("ID: " + cliente.getId());
                    System.out.println("Nombre: " + cliente.getNombre());
                }
                System.out.println("========================\n");

                ois.close();
                bais.close();
            }

            teclado.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
