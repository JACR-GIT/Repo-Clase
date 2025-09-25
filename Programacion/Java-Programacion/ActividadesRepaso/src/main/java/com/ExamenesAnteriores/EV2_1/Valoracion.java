package com.ExamenesAnteriores.EV2_1;

import java.util.Scanner;

public class Valoracion implements Comparable<Valoracion> {
    Producto producto = new Producto();
    Estrellas estrellas;
    String comentario;

    public Valoracion(Producto producto, Estrellas estrellas, String comentario) {
        this.producto = producto;
        this.estrellas = estrellas;
        this.comentario = comentario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Estrellas getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Estrellas estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int compareTo(Valoracion o) {
        return this.producto.compareTo(o.producto);
    }

    @Override
    public String toString() {
        return "Valoracion en: " + producto + "\n\t Puntuacion: " + estrellas + " estrellas " + "\n\t Comentario: "+ comentario;
    }
}
