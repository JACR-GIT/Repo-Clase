package Ejercicio_22;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 100;

        int sumaCuadrados = IntStream.iterate(0, i -> i + 2).limit(N)
                .map(n -> n*n)
                .reduce(0, Integer::sum);

        System.out.println("Suma de cuadrados: " + sumaCuadrados);
    }
}
