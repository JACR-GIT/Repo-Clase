package practicas;

import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 3 - SERVIDOR UDP CON OBJETOS
 * Gestiona un array de alumnos y responde a consultas por ID.
 */
public class Actividad3_ServidorUDP {
    public static void main(String[] args) {
        int puerto = 9876;
        
        // Crear array de 5 alumnos
        Alumno[] alumnos = new Alumno[5];
        
        // Inicializar datos
        alumnos[0] = new Alumno(1, "Juan Pérez", new Curso(1, "DAM"));
        alumnos[1] = new Alumno(2, "María López", new Curso(2, "DAW"));
        alumnos[2] = new Alumno(3, "Pedro García", new Curso(1, "DAM"));
        alumnos[3] = new Alumno(4, "Ana Martínez", new Curso(3, "ASIR"));
        alumnos[4] = new Alumno(5, "Luis Sánchez", new Curso(2, "DAW"));
        
        System.out.println("Servidor UDP iniciado en puerto " + puerto);
        
        try {
            // Crear socket UDP
            DatagramSocket socket = new DatagramSocket(puerto);
            
            // Bucle infinito para atender peticiones
            while (true) {
                // 1. Recibir ID del alumno (como String)
                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                socket.receive(paqueteRecepcion);
                
                // Obtener datos del cliente
                String idStr = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                InetAddress direccionCliente = paqueteRecepcion.getAddress();
                int puertoCliente = paqueteRecepcion.getPort();
                
                System.out.println("ID solicitado: " + idStr);
                
                // 2. Buscar alumno
                Alumno alumnoEncontrado = null;
                try {
                    int id = Integer.parseInt(idStr.trim());
                    for (Alumno a : alumnos) {
                        if (a.getIdAlumno() == id) {
                            alumnoEncontrado = a;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    // ID inválido
                }
                
                // Si no se encontró, crear alumno con datos de "no existe"
                if (alumnoEncontrado == null) {
                    alumnoEncontrado = new Alumno(-1, "ALUMNO NO ENCONTRADO", 
                                                  new Curso(-1, "NO EXISTE"));
                }
                
                // 3. Convertir objeto Alumno a bytes usando ByteArrayOutputStream
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(alumnoEncontrado);
                byte[] bufferEnvio = baos.toByteArray();
                
                // 4. Enviar objeto al cliente
                DatagramPacket paqueteEnvio = new DatagramPacket(
                    bufferEnvio, bufferEnvio.length, direccionCliente, puertoCliente);
                socket.send(paqueteEnvio);
                
                System.out.println("Alumno enviado: " + alumnoEncontrado.getNombre() + "\n");
                
                oos.close();
                baos.close();
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
