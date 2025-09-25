package com.ActividadesExtras;

public class Empleado {
    String nombre;
    String departamento;
    double salario;
    int anioContratacion;

    public Empleado(String nombre, String departamento, double salario, int anioContratacion) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.anioContratacion = anioContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnioContratacion() {
        return anioContratacion;
    }

    public void setAnioContratacion(int anioContratacion) {
        this.anioContratacion = anioContratacion;
    }
}
