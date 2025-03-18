package Ejercicio_21;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> filtradoNumerosPrimos = listaNumeros.stream().filter(numero -> {
            if (numero == 1) {
                return false;
            }

            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    return false;
                }
            }

            return true;
        });

        filtradoNumerosPrimos.forEach(System.out::println);
    }
}
