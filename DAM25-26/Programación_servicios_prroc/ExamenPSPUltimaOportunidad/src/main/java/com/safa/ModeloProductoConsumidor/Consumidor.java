package com.safa.ModeloProductoConsumidor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumidor implements Runnable{
    private  final BlockingQueue<String> buffer;
    private final int idConsumidor;

    //Variables compartidas atomicas para las estadisticas finales
    private static final AtomicInteger totalProcesados = new AtomicInteger(0);
    private static final AtomicInteger totalAlertas = new AtomicInteger(0);

    // Constructor
    public Consumidor(BlockingQueue<String> buffer, int idConsumidor) {
        this.buffer = buffer;
        this.idConsumidor = idConsumidor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String dato = buffer.take();// Bloquea hasta que haya un dato disponible

                if("POISON_PILL".equals(dato)) {
                    break;
                }
                //Procesamos el paquete
                PaqueteTelemetria paquete = new PaqueteTelemetria();
                String resultado = paquete.comprobarAnomalias();

                totalProcesados.incrementAndGet();
                if(!resultado.equals("OK")) {
                   totalAlertas.incrementAndGet();
                }

                // Mostramos el resultado del procesamiento
                System.out.printf("Consumidor %d procesó: %s - Resultado: %s%n", idConsumidor, dato, resultado);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
        //Metodos para obtener las estadisticas finales
    public static int getTotalProcesados() {
        return totalProcesados.get();
    }
    public static int getTotalAlertas() {
        return totalAlertas.get();
    }
}
