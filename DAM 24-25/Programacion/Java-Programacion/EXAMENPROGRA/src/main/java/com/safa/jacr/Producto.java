package com.safa.jacr;

public class Producto {
    private String nombre;
    private String codigo;

    public Producto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Producto() {
        this("", "");
    }

    public Producto(Producto p) {
        this(p.nombre, p.codigo);
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

    public int compareTo(Producto o) {
        int cmp = nombre.compareTo(o.nombre);
        return (cmp != 0) ? cmp : codigo.compareTo(o.codigo);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return codigo.equals(p.codigo);
    }

    public int hashCode() {
        return codigo.hashCode();
    }

    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
