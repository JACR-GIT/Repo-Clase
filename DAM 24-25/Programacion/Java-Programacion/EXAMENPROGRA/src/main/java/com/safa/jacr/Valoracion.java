package com.safa.jacr;

public class Valoracion implements Comparable<Valoracion> {

    private Producto producto;
    private int puntuacion;
    private String comentario;

    public Valoracion(Producto producto, int puntuacion, String comentario) {
        this.producto = producto;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int compareTo(Valoracion o) {
        return producto.compareTo(o.producto);
    }

    public String toString() {
        return "Valoracion de :" + producto.getNombre() + " (" + producto.getCodigo() + ")\n"
                +"Puntacion: " + puntuacion + " Estrellas\n"
                +"Comentario: "  + comentario + "\n";
    }
}
