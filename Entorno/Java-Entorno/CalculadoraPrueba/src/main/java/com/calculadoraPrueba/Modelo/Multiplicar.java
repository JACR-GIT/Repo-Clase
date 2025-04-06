package com.calculadoraPrueba.Modelo;

public class Multiplicar {
    private int a;
    private int b;

    public Multiplicar(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double multiplicar() {
        return a * b;
    }
}
