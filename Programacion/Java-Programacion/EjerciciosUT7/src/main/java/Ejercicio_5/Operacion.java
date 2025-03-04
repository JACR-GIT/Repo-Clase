package Ejercicio_5;

import java.util.function.Function;

public interface Operacion {
    public static int calcular(int a, int b) {
        java.util.function.BiFunction<Integer, Integer, Integer> multiplicar = (a, b) -> a * b;
        return multiplicar.apply(a, b);
    }
}
