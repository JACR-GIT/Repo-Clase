package com.Actividad1;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class ProductoPedecedero extends ProductoAbs implements Descontable {

    int diasCaducidadExtra;

    public ProductoPedecedero(String codigo, String nombre, double precio, LocalDate fechaCaducidad, int diasCaducidadExtra) {
        super(codigo, nombre, precio, fechaCaducidad);
        this.diasCaducidadExtra = diasCaducidadExtra;
    }

    public ProductoPedecedero() {
        super(null, null, 0, null);
    }

    public double aplicarDescuento(double porcentaje) {
        if (diasCaducidadExtra < 2) {
            return precio * (1 - porcentaje / 100);
        } else {
            return precio;
        }
    }
}
