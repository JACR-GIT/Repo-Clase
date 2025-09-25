package com.examenejavafx.Modelo;

import java.util.Date;

public class Anzuelo {
    private String modelo;
    private String ojos;
    private String color;
    private int peso;
    private int tamaño;
    private String navegabilidad;
    private String referencia;
    private String disponibilidad;
    private Date fechaRecepcion;
    private int PVP;

    public Anzuelo(String modelo, String ojos, String color, int peso, int tamaño, String navegabilidad, String referencia, String disponibilidad, Date fechaRecepcion, int PVP) {
        this.modelo = modelo;
        this.ojos = ojos;
        this.color = color;
        this.peso = peso;
        this.tamaño = tamaño;
        this.navegabilidad = navegabilidad;
        this.referencia = referencia;
        this.disponibilidad = disponibilidad;
        this.fechaRecepcion = fechaRecepcion;
        this.PVP = PVP;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getNavegabilidad() {
        return navegabilidad;
    }

    public void setNavegabilidad(String navegabilidad) {
        this.navegabilidad = navegabilidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getPVP() {
        return PVP;
    }

    public void setPVP(int PVP) {
        this.PVP = PVP;
    }
}