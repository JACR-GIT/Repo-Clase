package com.safa;

public class Proveedor {
    String nombreEmpresa;
    int diasEntrega;

    public Proveedor(String nombreEmpresa, int diasEntrega) {
        this.nombreEmpresa = nombreEmpresa;
        this.diasEntrega = diasEntrega;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }
}
