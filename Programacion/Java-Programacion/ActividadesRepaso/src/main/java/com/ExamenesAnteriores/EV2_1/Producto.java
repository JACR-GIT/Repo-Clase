package com.ExamenesAnteriores.EV2_1;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private String codigo;

    public Producto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Producto() {}

    public Producto(Producto copia) {
        this.nombre = copia.nombre;
        this.codigo = copia.codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Producto o) {
        int cmp = this.nombre.compareTo(o.nombre);
        if (cmp == 0) {
            return this.codigo.compareTo(o.codigo);
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
