package com.Actividad2;

import com.opencsv.bean.CsvBindByName;

public class Libro {

    @CsvBindByName(column = "isbn")
    private String isbn;
    @CsvBindByName(column = "título")
    private String titulo;
    @CsvBindByName(column = "autor")
    private String autor;
    @CsvBindByName(column = "año")
    private int anio;
    @CsvBindByName(column = "precio")
    private double precio;

    // Getters y setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format("%s - \"%s\" de %s (%d) - %.2f€",
                isbn, titulo, autor, anio, precio);
    }
}
