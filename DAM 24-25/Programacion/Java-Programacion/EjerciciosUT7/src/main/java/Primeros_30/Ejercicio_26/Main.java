package Ejercicio_26;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> cuadradosImpares = listaNumeros.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(cuadradosImpares);

    }
}
