package practicas;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ACTIVIDAD 3 - CLIENTE UDP CON OBJETOS
 * Consulta alumnos por ID al servidor.
 */
public class Actividad3_ClienteUDP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 9876;
        
        try {
            // Crear socket UDP
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName(host);
            
            Scanner teclado = new Scanner(System.in);
            String idAlumno;
            
            System.out.println("Cliente UDP conectado");
            System.out.println("Introduce ID del alumno (* para salir)\n");
            
            while (true) {
                System.out.print("ID Alumno: ");
                idAlumno = teclado.nextLine();
                
                if (idAlumno.equals("*")) {
                    System.out.println("Saliendo...");
                    break;
                }
                
                // 1. Enviar ID al servidor
                byte[] bufferEnvio = idAlumno.getBytes();
                DatagramPacket paqueteEnvio = new DatagramPacket(
                    bufferEnvio, bufferEnvio.length, direccion, puerto);
                socket.send(paqueteEnvio);
                
                // 2. Recibir objeto Alumno del servidor
                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paqueteRecepcion = new DatagramPacket(
                    bufferRecepcion, bufferRecepcion.length);
                socket.receive(paqueteRecepcion);
                
                // 3. Convertir bytes a objeto usando ByteArrayInputStream
                ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                Alumno alumno = (Alumno) ois.readObject();
                
                // 4. Mostrar datos
                System.out.println("\n=== DATOS DEL ALUMNO ===");
                if (alumno.getIdAlumno() == -1) {
                    System.out.println(alumno.getNombre());
                } else {
                    System.out.println("ID: " + alumno.getIdAlumno());
                    System.out.println("Nombre: " + alumno.getNombre());
                    System.out.println("Curso: " + alumno.getCurso().getDescripcion() + 
                                     " (ID: " + alumno.getCurso().getIdCurso() + ")");
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
