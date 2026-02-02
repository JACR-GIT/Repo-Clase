package practicas;

import java.io.*;
import java.net.*;

/**
 * ACTIVIDAD 4 - SERVIDOR TCP CON OBJETOS Y MÚLTIPLES CLIENTES
 * Usa hilos para atender a varios clientes simultáneamente.
 */
public class Actividad4_ServidorTCP {
    
    private static Profesor[] profesores; // Array compartido por todos los hilos
    private static int contadorClientes = 0; // Contador de clientes
    
    public static void main(String[] args) {
        int puerto = 6000;
        
        // Inicializar array de profesores
        inicializarProfesores();
        
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor TCP iniciado en puerto " + puerto);
            System.out.println("Esperando clientes...\n");
            
            // Bucle infinito para aceptar clientes
            while (true) {
                Socket cliente = servidor.accept();
                contadorClientes++;
                
                System.out.println("Cliente " + contadorClientes + " conectado");
                
                // Crear hilo para atender al cliente
                HiloCliente hilo = new HiloCliente(cliente, contadorClientes);
                hilo.start();
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void inicializarProfesores() {
        profesores = new Profesor[5];
        
        // Crear especialidades
        Especialidad info = new Especialidad(1, "Informática");
        Especialidad mate = new Especialidad(2, "Matemáticas");
        
        // Crear profesores
        profesores[0] = new Profesor(1, "Juan García", info);
        profesores[0].getAsignaturas()[0] = new Asignatura(1, "Programación");
        profesores[0].getAsignaturas()[1] = new Asignatura(2, "Bases de Datos");
        
        profesores[1] = new Profesor(2, "María López", info);
        profesores[1].getAsignaturas()[0] = new Asignatura(3, "PSP");
        
        profesores[2] = new Profesor(3, "Pedro Martínez", mate);
        profesores[2].getAsignaturas()[0] = new Asignatura(4, "Cálculo");
        profesores[2].getAsignaturas()[1] = new Asignatura(5, "Álgebra");
        
        profesores[3] = new Profesor(4, "Ana Sánchez", info);
        profesores[3].getAsignaturas()[0] = new Asignatura(6, "Redes");
        
        profesores[4] = new Profesor(5, "Luis Fernández", mate);
        profesores[4].getAsignaturas()[0] = new Asignatura(7, "Estadística");
        
        System.out.println("Profesores inicializados:");
        for (Profesor p : profesores) {
            System.out.println("  ID " + p.getIdProfesor() + ": " + p.getNombre());
        }
        System.out.println();
    }
    
    private static Profesor buscarProfesor(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            for (Profesor p : profesores) {
                if (p.getIdProfesor() == id) {
                    return p;
                }
            }
        } catch (NumberFormatException e) {
            // ID inválido
        }
        
        // No encontrado
        return new Profesor(-1, "PROFESOR NO ENCONTRADO", 
                          new Especialidad(-1, "NO EXISTE"));
    }
    
    // Clase interna para el hilo que atiende a cada cliente
    static class HiloCliente extends Thread {
        private Socket socket;
        private int idCliente;
        
        public HiloCliente(Socket socket, int idCliente) {
            this.socket = socket;
            this.idCliente = idCliente;
        }
        
        public void run() {
            try {
                // IMPORTANTE: Crear ObjectOutputStream PRIMERO y hacer flush
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
                salida.flush();
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                
                // Enviar ID al cliente
                salida.writeInt(idCliente);
                salida.flush();
                
                // Procesar peticiones del cliente
                String idProfesor;
                while (true) {
                    idProfesor = entrada.readUTF();
                    
                    if (idProfesor.equals("*")) {
                        System.out.println("Cliente " + idCliente + " desconectado\n");
                        break;
                    }
                    
                    System.out.println("Cliente " + idCliente + " solicita profesor ID: " + idProfesor);
                    
                    // Buscar y enviar profesor
                    Profesor profesor = buscarProfesor(idProfesor);
                    salida.writeObject(profesor);
                    salida.flush();
                    salida.reset(); // Limpiar el caché de objetos después de enviar
                }
                
                // Cerrar recursos
                salida.close();
                entrada.close();
                socket.close();
                
            } catch (IOException e) {
                System.out.println("Error con cliente " + idCliente + ": " + e.getMessage());
            }
        }
    }
}
