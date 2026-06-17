package com.safa.ModeloProductoConsumidor;

import java.util.concurrent.*;

public class SistemaTelemetria {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java SistemaTelemetria <num_consumidores> <tam_buffer>");
            return;
        }

        int numConsumidores = Integer.parseInt(args[0]);
        int tamBuffer = Integer.parseInt(args[1]);
        String fichero = "keys.txt"; // Asegúrate de tener este archivo listo

        // Buffer síncronizado obligatorio
        BlockingQueue<String> buffer = new LinkedBlockingQueue<>(tamBuffer);

        // Crear e iniciar el Productor
        Thread hiloProductor = new Thread(new Productor(buffer, fichero, numConsumidores));
        hiloProductor.start();

        // Crear e iniciar los Consumidores
        Thread[] hilosConsumidores = new Thread[numConsumidores];
        for (int i = 0; i < numConsumidores; i++) {
            hilosConsumidores[i] = new Thread(new Consumidor(buffer, i + 1));
            hilosConsumidores[i].start();
        }

        // Esperar a que todos terminen correctamente (Exigencia del examen)
        try {
            hiloProductor.join();
            for (Thread t : hilosConsumidores) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.err.println("El sistema principal fue interrumpido.");
        }

        // --- INFORME FINAL ---
        int procesados = Consumidor.getTotalProcesados();
        int alertas = Consumidor.getTotalAlertas();

        System.out.println("\n--- ESTADO FINAL DE MISIÓN ---");
        System.out.println("Paquetes totales procesados: " + procesados);
        System.out.println("Paquetes con alertas: " + alertas);

        // Supongamos que si más del 15% tiene alertas, es INESTABLE
        double porcentajeAlertas = (procesados > 0) ? ((double) alertas / procesados) * 100 : 0;
        if (porcentajeAlertas > 15.0) {
            System.out.println("ESTADO FINAL DE MISIÓN: INESTABLE (" + String.format("%.2f", porcentajeAlertas) + "% de anomalías)");
        } else {
            System.out.println("ESTADO FINAL DE MISIÓN: ESTABLE");
        }
    }
}