package com.practica4.Model;

public class Vehiculo {
    private String matricula;
    private String descripcion;
    private String marca;
    private int km;
    private int precio;

    public Vehiculo(String matricula, String descripcion, String marca, int km, int precio) {
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.marca = marca;
        this.km = km;
        this.precio = precio;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
