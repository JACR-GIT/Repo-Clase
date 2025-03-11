package org.example;

public class Calculadora{

    public double calcular(double a, double b, String operacion) {
        double resultado = 0;
        switch (operacion) {
            case "sumar" -> new Sumar().calcular(a, b);
            case "restar" -> new Restar().calcular(a, b);
            case "multiplicar" -> new Multiplicar().calcular(a, b);
            case "dividir" -> new Dividir().calcular(a, b);
        }
        return resultado;
    }
}
