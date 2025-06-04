package com.Actividad1;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class ProductoNoPedecedero extends ProductoAbs implements Descontable {

    @CsvBindByName(column = "datoExtra") String tipoConservacion;

    public ProductoNoPedecedero(String codigo, String nombre, LocalDate fechaCaducidad, double precio, String tipoConservacion) {
        super(codigo, nombre, precio, fechaCaducidad);
        this.tipoConservacion = tipoConservacion;
    }

    public ProductoNoPedecedero() {
        super(null, null, 0, null);
    }

    public double aplicarDescuento(double porcentaje) {
        if (tipoConservacion.equalsIgnoreCase("Molido")) {
            return precio - (precio * porcentaje / 100);
        } else {
            return precio;
        }
    }
}
