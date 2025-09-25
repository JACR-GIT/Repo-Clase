package com.practica4.Model;

public class Cliente {
    private String NIF;
    private String NyA;
    private String Direcion;
    private String Poblacion;

    public Cliente(String NIF, String NyA, String Direcion, String Poblacion) {
        this.NIF = NIF;
        this.NyA = NyA;
        this.Direcion = Direcion;
        this.Poblacion = Poblacion;
    }
    public String getNIF() {
        return NIF;
    }
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    public String getNyA() {
        return NyA;
    }
    public void setNyA(String NyA) {
        this.NyA = NyA;
    }
    public String getDirecion() {
        return Direcion;
    }
    public void setDirecion(String Direcion) {
        this.Direcion = Direcion;
    }
    public String getPoblacion() {
        return Poblacion;
    }
    public void setPoblacion(String Poblacion) {
        this.Poblacion = Poblacion;
    }
}
