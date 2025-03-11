package org.example;

public abstract class Operacion {

    abstract double calcular(double a, double b);
}

class Sumar extends Operacion {

    public double calcular(double a, double b) {
        return a + b;
    }
}

class Restar extends Operacion {
    public double calcular(double a, double b) {
        return a - b;
    }
}

class Multiplicar extends Operacion {
    public double calcular(double a, double b) {
        return a * b;
    }
}

class Dividir extends Operacion {
    public double calcular(double a, double b) {
        if (b !=0){
            return a / b;
        }else{
            throw new IllegalArgumentException("El divisor no puede ser 0");
        }
    }
}


