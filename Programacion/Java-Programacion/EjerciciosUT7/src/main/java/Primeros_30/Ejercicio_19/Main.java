package Ejercicio_19;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> funcion = Calculadora::cuadrado;

        System.out.println(funcion.apply(5)); 
    }
}
