package com.LecturaCSV.Actividad1;

public class CodigoProductoInvalidoException {
    public static void validarCodigoProducto(String codigoProducto) {
        if (codigoProducto == null || codigoProducto.isEmpty()) {
            throw new IllegalArgumentException("El código del producto no puede ser nulo o vacío.");
        }
        if (!codigoProducto.matches("PRD\\d{3}")) {
            throw new IllegalArgumentException("El código del producto debe seguir el formato PRD-000.");
        }
    }
}
