package Ejercicio_17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;

        Operacion resta = (a, b) -> a - b;

        System.out.println("Suma: " + suma.ejecutar(10, 5));
        System.out.println("Resta: " + resta.ejecutar(10, 5));

    }
}
