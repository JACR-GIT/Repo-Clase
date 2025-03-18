package Julian_30.Ejer_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Double> potencias = numeros.stream()
                .map(n -> Math.pow(2, n))
                .collect(Collectors.toList());
        System.out.println(potencias);
    }
}
