package com.EstructurasEIteradores.Actividad7;

public class Sensor {
    private final String id;
    private int valor;

    public Sensor(String id, int valorInicial) {
        this.id = id;
        this.valor = valorInicial;
    }

    public void actualizarValor(int nuevoValor) {
        this.valor = nuevoValor;
    }

    public boolean esValorNormal() {
        return valor >= 10 && valor <= 100;
    }

    public String getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }
}
