package com.EstructurasEIteradores.Actividad1;

import java.util.ArrayList;
import java.util.List;

public class FuncionesProductos {
    public static List<Producto> filtrarPorPrecio(List<Producto> productos, double precioMaximo) {
        List<Producto> filtrado = new ArrayList<Producto>();
        for (Producto producto : productos) {
            if (producto.getPrecio() <= precioMaximo) {
                filtrado.add(producto);
            }
        }
        return filtrado;
    }
}
