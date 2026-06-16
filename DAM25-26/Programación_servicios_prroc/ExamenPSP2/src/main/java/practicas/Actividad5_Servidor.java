package practicas;

import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 5 - SERVIDOR CON HILOS
 * Convierte cadenas a mayúsculas usando un hilo por cliente.
 */
public class Actividad5_Servidor {
    public static void main(String[] args) {
        int puerto = 44444;
        
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en puerto " + puerto);
            System.out.println("Esperando clientes...\n");
            
            // Bucle infinito para aceptar clientes
            while (true) {
                Socket cliente = servidor.accept();
                
                // Crear y lanzar hilo para este cliente
                HiloCliente hilo = new HiloCliente(cliente);
                hilo.start();
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Clase interna para el hilo que atiende a cada cliente
    static class HiloCliente extends Thread {
        private Socket socket;
        
        public HiloCliente(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            String ip = socket.getInetAddress().toString();
            int puerto = socket.getPort();
            
            try {
                // Mostrar conexión
                System.out.println("Cliente conectado: IP=" + ip + ", Puerto=" + puerto);
                
                // Crear flujos
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                
                // Procesar mensajes
                String cadena;
                while (true) {
                    cadena = entrada.readUTF();
                    
                    if (cadena.equals("*")) {
                        System.out.println("Cliente desconectado: IP=" + ip + ", Puerto=" + puerto + "\n");
                        break;
                    }
                    
                    // Convertir a mayúsculas y enviar
                    String mayusculas = cadena.toUpperCase();
                    salida.writeUTF(mayusculas);
                }
                
                // Cerrar recursos
                entrada.close();
                salida.close();
                socket.close();
                
            } catch (IOException e) {
                System.out.println("Error con cliente " + ip + ": " + e.getMessage());
            }
        }
    }
}
