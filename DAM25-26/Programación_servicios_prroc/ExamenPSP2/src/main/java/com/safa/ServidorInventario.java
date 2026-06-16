package com.safa;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorInventario {
    public static void main(String[] args) throws IOException {

        int numPuerto = 5000;
        int contadorClientes = 0;

        inicializarProductos();

        try {
            ServerSocket servidor = new ServerSocket(numPuerto);
            System.out.println("Servidor TCP iniciado en puerto " + numPuerto);
            System.out.println("Esperando clientes...\n");
            while (true) {
                Socket cliente = servidor.accept();
                contadorClientes++;

                System.out.println("Cliente " + contadorClientes + " conectado");

                ServidorInventario.HiloCliente hilo = new ServidorInventario.HiloCliente(cliente, contadorClientes);
                hilo.start();
            }
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static ArrayList<Producto> inicializarProductos() {

        Categoria cat1 = new Categoria("Electrónica", "Mantener en lugar seco y fresco");
        Categoria cat2 = new Categoria("Alimentos", "Refrigerar después de abrir");

        Proveedor prov1 = new Proveedor("Tech Supplies Co.", 5);
        Proveedor prov2 = new Proveedor("Fresh Foods Inc.", 2);

        Producto prod1 = new Producto(1, "Smartphone", cat1, prov1);
        Producto prod2 = new Producto(2, "Laptop", cat1, prov1);
        Producto prod3 = new Producto(3, "Yogur", cat2, prov2);
        Producto prod4 = new Producto(4, "Queso", cat2, prov2);

        ArrayList<Producto> inventario = new ArrayList<>();
        inventario.add(prod1);
        inventario.add(prod2);
        inventario.add(prod3);
        inventario.add(prod4);

        return inventario;
    }

    private static synchronized void registrarCadena(String cadena, ArrayList<String> cadenas) {
        try{
            cadenas.add(cadena);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Producto buscarProductoPorId(int id, ArrayList<Producto> inventario) {
        try{
            for (Producto prod : inventario) {
                if (prod.getIdProducto() == id) {
                    return prod;
                }
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return new Producto(-1, "No encontrado", null, null);
    }

    static class HiloCliente extends Thread {
        private Socket socket;
        private int idCliente;

        public HiloCliente(Socket socket, int idCliente) {
            this.socket = socket;
            this.idCliente = idCliente;
        }

        public void run() {
            try {
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
                salida.flush();
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                salida.writeInt(idCliente);
                salida.flush();

                String idProductoStr;
                while (true) {
                    idProductoStr = entrada.readUTF();

                    if (idProductoStr.equals("*")) {
                        System.out.println("Cliente " + idCliente + " desconectado\n");
                        break;
                    }
                    System.out.println("Cliente " + idCliente + " solicita producto ID: " + idProductoStr);
                    Producto producto = buscarProductoPorId(Integer.parseInt(idProductoStr), inicializarProductos());
                    salida.writeObject(producto);
                    salida.flush();
                    salida.reset();
                }

                salida.close();
                entrada.close();
                socket.close();

            } catch (Exception e) {
                System.out.println("Error con cliente " + idCliente + ": " + e.getMessage());
            }
        }
    }
}
