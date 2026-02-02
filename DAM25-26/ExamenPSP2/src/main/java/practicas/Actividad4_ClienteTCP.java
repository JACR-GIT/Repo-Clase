package practicas;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ACTIVIDAD 4 - CLIENTE TCP CON OBJETOS
 * Consulta profesores por ID al servidor.
 */
public class Actividad4_ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        
        try {
            // Conectar al servidor
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado al servidor");
            
            // IMPORTANTE: Crear ObjectOutputStream PRIMERO y hacer flush
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            salida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            
            // Recibir ID del cliente
            int idCliente = entrada.readInt();
            System.out.println("ID asignado: " + idCliente);
            System.out.println("Introduce ID del profesor (* para salir)\n");
            
            Scanner teclado = new Scanner(System.in);
            String idProfesor;
            
            while (true) {
                System.out.print("ID Profesor: ");
                idProfesor = teclado.nextLine();
                
                // Enviar ID al servidor
                salida.writeUTF(idProfesor);
                
                if (idProfesor.equals("*")) {
                    System.out.println("Cerrando conexión...");
                    break;
                }
                
                // Recibir objeto Profesor
                Profesor profesor = (Profesor) entrada.readObject();
                
                // Mostrar datos
                System.out.println("\n=== DATOS DEL PROFESOR ===");
                if (profesor.getIdProfesor() == -1) {
                    System.out.println(profesor.getNombre());
                } else {
                    System.out.println("ID: " + profesor.getIdProfesor());
                    System.out.println("Nombre: " + profesor.getNombre());
                    System.out.println("Especialidad: " + profesor.getEspecialidad().getNombre() +
                                     " (ID: " + profesor.getEspecialidad().getIdEspecialidad() + ")");
                    
                    System.out.println("Asignaturas:");
                    for (int i = 0; i < 3; i++) {
                        if (profesor.getAsignaturas()[i] != null) {
                            Asignatura asig = profesor.getAsignaturas()[i];
                            System.out.println("  - " + asig.getNombre() + 
                                             " (ID: " + asig.getIdAsignatura() + ")");
                        }
                    }
                }
                System.out.println("==========================\n");
            }
            
            teclado.close();
            salida.close();
            entrada.close();
            socket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
