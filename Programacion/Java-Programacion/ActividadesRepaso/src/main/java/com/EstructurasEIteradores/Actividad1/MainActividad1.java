package com.EstructurasEIteradores.Actividad1;

import java.util.ArrayList;
import java.util.List;

public class MainActividad1 {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("P001", "Manzana", 0.5));
        listaProductos.add(new Producto("P002", "Pan", 1.0));
        listaProductos.add(new Producto("P003", "Leche", 0.8));

        List<Producto> productosFiltrados = FuncionesProductos.filtrarPorPrecio(listaProductos, 0.8);
        for (Producto producto : productosFiltrados) {
            System.out.println("Producto filtrado: " + producto.getNombre() + " - Precio: " + producto.getPrecio());
        }
    }
}
