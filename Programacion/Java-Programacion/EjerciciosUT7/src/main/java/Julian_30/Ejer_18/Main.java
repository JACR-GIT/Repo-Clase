package Julian_30.Ejer_18;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(-5, 2, -1, 8, -3);
        int cercano = numeros.stream()
                .min((n1, n2) -> Integer.compare(Math.abs(n1), Math.abs(n2)))
                .orElse(0);
        System.out.println("Más cercano a cero: " + cercano);
    }
}
