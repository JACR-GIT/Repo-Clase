package com.LecturaCSV.Actividad1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class ProductoAbs {

    String codigo;
    String nombre;
    double precio;
    private LocalDate fechaCaducidad;

    public ProductoAbs(String codigo, String nombre, double precio, LocalDate fechaCaducidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAbs that = (ProductoAbs) o;
        return Double.compare(precio, that.precio) == 0 && Objects.equals(codigo, that.codigo) && Objects.equals(nombre, that.nombre) && Objects.equals(fechaCaducidad, that.fechaCaducidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, fechaCaducidad);
    }

    @Override
    public String toString() {
        return "ProductoAbs{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fechaCaducidad=" + fechaCaducidad +
                '}';
    }
}
