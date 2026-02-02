package practicas;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ACTIVIDAD 6 - SERVIDOR MASTERMIND
 * Juego en el que los clientes deben adivinar una combinación de 4 dígitos.
 */
public class Actividad6_ServidorMastermind {
    
    private static int[] combinacionSecreta;
    private static boolean juegoTerminado = false;
    private static int contadorClientes = 0;
    private static final int MAX_INTENTOS = 10;
    
    public static void main(String[] args) {
        int puerto = 6000;
        
        // Generar combinación secreta (4 dígitos sin repetir)
        generarCombinacion();
        
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("=== SERVIDOR MASTERMIND ===");
            System.out.println("Combinación secreta: " + Arrays.toString(combinacionSecreta));
            System.out.println("Puerto: " + puerto);
            System.out.println("Esperando jugadores...\n");
            
            while (!juegoTerminado) {
                Socket cliente = servidor.accept();
                contadorClientes++;
                
                System.out.println("Jugador " + contadorClientes + " conectado");
                
                HiloJugador hilo = new HiloJugador(cliente, contadorClientes);
                hilo.start();
            }
            
            servidor.close();
            System.out.println("\n=== JUEGO TERMINADO ===");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void generarCombinacion() {
        combinacionSecreta = new int[4];
        List<Integer> numeros = new ArrayList<>();
        
        // Crear lista con números del 0 al 9
        for (int i = 0; i < 10; i++) {
            numeros.add(i);
        }
        
        // Mezclar y tomar los primeros 4
        Collections.shuffle(numeros);
        for (int i = 0; i < 4; i++) {
            combinacionSecreta[i] = numeros.get(i);
        }
    }
    
    private static int[] comprobarCombinacion(int[] intento) {
        int aciertos = 0;
        int coincidencias = 0;
        
        // Contar aciertos (número correcto en posición correcta)
        for (int i = 0; i < 4; i++) {
            if (intento[i] == combinacionSecreta[i]) {
                aciertos++;
            }
        }
        
        // Contar coincidencias (número correcto en posición incorrecta)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && intento[i] == combinacionSecreta[j]) {
                    coincidencias++;
                }
            }
        }
        
        return new int[]{aciertos, coincidencias};
    }
    
    static class HiloJugador extends Thread {
        private Socket socket;
        private int idJugador;
        
        public HiloJugador(Socket socket, int idJugador) {
            this.socket = socket;
            this.idJugador = idJugador;
        }
        
        public void run() {
            try {
                // IMPORTANTE: Crear ObjectOutputStream PRIMERO y hacer flush
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
                salida.flush();
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                
                // Enviar ID y estado del juego
                salida.writeInt(idJugador);
                salida.writeBoolean(juegoTerminado);
                salida.flush();
                
                if (juegoTerminado) {
                    System.out.println("Jugador " + idJugador + " desconectado (juego terminado)");
                    return;
                }
                
                int intentos = 0;
                
                // Procesar intentos del jugador
                while (intentos < MAX_INTENTOS && !juegoTerminado) {
                    // Recibir combinación del cliente
                    int[] intento = (int[]) entrada.readObject();
                    intentos++;
                    
                    System.out.println("Jugador " + idJugador + " - Intento " + intentos + 
                                     ": " + Arrays.toString(intento));
                    
                    // Comprobar combinación
                    int[] resultado = comprobarCombinacion(intento);
                    int aciertos = resultado[0];
                    int coincidencias = resultado[1];
                    
                    boolean gano = (aciertos == 4);
                    if (gano) {
                        juegoTerminado = true;
                        System.out.println("¡Jugador " + idJugador + " ha GANADO!");
                    }
                    
                    // Enviar respuesta
                    RespuestaMastermind respuesta = new RespuestaMastermind(
                        aciertos, coincidencias, MAX_INTENTOS - intentos, juegoTerminado, gano);
                    salida.writeObject(respuesta);
                    salida.flush();
                    
                    System.out.println("  Aciertos: " + aciertos + ", Coincidencias: " + coincidencias);
                }
                
                if (intentos >= MAX_INTENTOS) {
                    System.out.println("Jugador " + idJugador + " agotó sus intentos");
                }
                
                System.out.println("Jugador " + idJugador + " desconectado\n");
                
                salida.close();
                entrada.close();
                socket.close();
                
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error con jugador " + idJugador + ": " + e.getMessage());
            }
        }
    }
}
