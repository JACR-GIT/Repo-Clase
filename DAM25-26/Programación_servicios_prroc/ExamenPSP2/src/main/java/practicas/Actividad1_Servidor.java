package practicas;

import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 1 - SERVIDOR TCP
 * Recibe cadenas de texto del cliente y devuelve el número de caracteres.
 * Finaliza cuando recibe un asterisco (*).
 */

public class Actividad1_Servidor {
    public static void main(String[] args) {
        int puerto = 6000;

        try {
            // 1. Crear ServerSocket en el puerto
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en puerto " + puerto);
            System.out.println("Esperando cliente...");

            // 2. Aceptar conexión del cliente (accept se bloquea hasta que llegue un cliente)
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress());

            // 3. Crear flujos de entrada y salida
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            // 4. Procesar mensajes del cliente
            String cadena;
            while (true) {
                cadena = entrada.readUTF(); // Leer cadena del cliente
                System.out.println("Recibido: " + cadena);

                if (cadena.equals("*")) {
                    System.out.println("Fin de la comunicación");
                    break;
                }

                // Calcular número de caracteres
                int numCaracteres = cadena.length();

                // Enviar resultado al cliente
                salida.writeInt(numCaracteres);
                System.out.println("Enviado: " + numCaracteres + " caracteres");
            }

            // 5. Cerrar recursos (importante: primero streams, luego sockets)
            entrada.close();
            salida.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}