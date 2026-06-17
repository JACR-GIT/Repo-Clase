package com.safa.ModeloProductoConsumidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable{
    private final BlockingQueue<String> buffer;
    private final String nombreFichero;
    private final int numConsumidores;

    // Constructor
    public Productor(BlockingQueue<String> buffer, String nombreFichero, int numConsumidores) {
        this.buffer = buffer;
        this.nombreFichero = nombreFichero;
        this.numConsumidores = numConsumidores;
    }

    @Override
    public void run() {
        try(BufferedReader br = new BufferedReader(new java.io.FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                buffer.put(linea);
            }
            // Enviar un mensaje de fin de producción a cada consumidor
            for (int i = 0; i < numConsumidores; i++) {
                buffer.put("FIN");
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
