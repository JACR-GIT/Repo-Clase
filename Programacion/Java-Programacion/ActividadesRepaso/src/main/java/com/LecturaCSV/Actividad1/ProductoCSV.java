package com.LecturaCSV.Actividad1;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import java.time.LocalDate;

public class ProductoCSV {

    @CsvBindByName(column = "codigo") String codigo;
    @CsvBindByName(column = "nombre") String nombre;
    @CsvBindByName(column = "precio") double precio;
    @CsvCustomBindByName(column = "fechaCaducidad", converter = LocalDateConverter.class)
    LocalDate fechaCaducidad;
    @CsvBindByName(column = "datoExtra")
    int diasCaducidadExtra;
    @CsvBindByName(column = "datoExtra")
    String tipoConservacion;

    // Constructor vacío requerido por OpenCSV
    public ProductoCSV() {}

    public ProductoCSV(String codigo, String nombre, double precio, LocalDate fechaCaducidad, int diasCaducidadExtra, String tipoConservacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
        this.diasCaducidadExtra = diasCaducidadExtra;
        this.tipoConservacion = tipoConservacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getDiasCaducidadExtra() {
        return diasCaducidadExtra;
    }

    public void setDiasCaducidadExtra(int diasCaducidadExtra) {
        this.diasCaducidadExtra = diasCaducidadExtra;
    }

    public String getTipoConservacion() {
        return tipoConservacion;
    }

    public void setTipoConservacion(String tipoConservacion) {
        this.tipoConservacion = tipoConservacion;
    }

    @Override
    public String toString() {
        return "ProductoCSV{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fechaCaducidad=" + fechaCaducidad +
                ", diasCaducidadExtra=" + diasCaducidadExtra +
                ", tipoConservacion='" + tipoConservacion + '\'' +
                '}';
    }
}
