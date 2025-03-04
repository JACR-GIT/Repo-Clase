package com.safa.jacr;

import java.util.Objects;

public class Transformacion {

    String nombre;
    int poder;

    public Transformacion(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transformacion that = (Transformacion) o;
        return poder == that.poder && Objects.equals(nombre, that.nombre);
    }

    public int hashCode() {
        return Objects.hash(nombre, poder);
    }

    public String toString() {
        return "Transformacion{" +
                "nombre='" + nombre + '\'' +
                ", poder=" + poder +
                '}';
    }
}
