package Ejercicio_20;

public class Libro {
    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String toString() {
        return "Libro: " + titulo;
    }
}

