package practicas;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ACTIVIDAD 1 - CLIENTE TCP
 * Envía cadenas de texto al servidor y recibe el número de caracteres.
 * Finaliza cuando se introduce un asterisco (*).
 */

public class Actividad1_Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try {
            // 1. Crear Socket y conectar al servidor
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor " + host + ":" + puerto);

            // 2. Crear flujos de entrada y salida
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // 3. Leer cadenas desde teclado y enviar al servidor
            Scanner teclado = new Scanner(System.in);
            String cadena;

            while (true) {
                System.out.print("Introduce cadena (* para salir): ");
                cadena = teclado.nextLine();

                // Enviar cadena al servidor
                salida.writeUTF(cadena);

                if (cadena.equals("*")) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

                // Recibir número de caracteres del servidor
                int numCaracteres = entrada.readInt();
                System.out.println("La cadena tiene " + numCaracteres + " caracteres\n");
            }

            // 4. Cerrar recursos
            teclado.close();
            salida.close();
            entrada.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}