package Ejercicio_22;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 10;

        int sumaCuadrados = IntStream.iterate(0, i -> i + 2).limit(N)
                .map(n -> n*n)
                .reduce(0, Integer::sum);

        System.out.println("Suma de cuadrados: " + sumaCuadrados);

        // Llamada al método generarCuadradosPares
        generarCuadradosPares(N);
    }

    public static void generarCuadradosPares(Integer n) {
        List<Integer> listaPares = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            listaPares.add(i * 2);
        }

        Integer resultado = listaPares.stream()
                .map(a -> a * a)
                .reduce((a, b) -> a + b).orElse(0);

        ListIterator<Integer> iterator = listaPares.listIterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            elem = elem * elem;
            iterator.set(elem);
        }
        System.out.println(listaPares);
    }
}