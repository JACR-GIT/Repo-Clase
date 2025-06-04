package com.Actividad1;

import java.util.List;

public class MainActividad1 {
    public static void main(String[] args) {
        LectorProductos lector = new LectorProductos();
        List<ProductoNoPedecedero> productosNoPerecederos = lector.leerProductosNoPerecederos("productos.csv");
        List<ProductoPedecedero> productosPedecederos = lector.leerProductosPedecedero("productos.csv");
        System.out.println("Productos leídos del CSV:");
    }
}
