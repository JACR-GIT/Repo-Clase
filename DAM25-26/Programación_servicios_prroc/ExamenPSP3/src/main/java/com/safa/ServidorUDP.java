package com.safa;

import practicas.Actividad5_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorUDP {

     public static void main(String[] args) {
        int puerto = 44444;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en puerto " + puerto);
            System.out.println("Esperando clientes...\n");

            while (true) {
                Socket cliente = servidor.accept();

                ServidorInventario.HiloCliente hilo = new ServidorInventario.HiloCliente();
                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     static class HiloCliente extends Thread {
        private Socket socket;

        public HiloCliente(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            String ip = socket.getInetAddress().toString();
            int puerto = socket.getPort();

            try {

                System.out.println("Cliente conectado: IP=" + ip + ", Puerto=" + puerto);

                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());


                String cadena;
                while (true) {
                    cadena = entrada.readUTF();

                    if (cadena.equals("*")) {
                        System.out.println("Cliente desconectado: IP=" + ip + ", Puerto=" + puerto + "\n");
                        break;
                    }

                }

                entrada.close();
                salida.close();
                socket.close();

            } catch (IOException e) {
                System.out.println("Error con cliente " + ip + ": " + e.getMessage());
            }
        }
    }
}
