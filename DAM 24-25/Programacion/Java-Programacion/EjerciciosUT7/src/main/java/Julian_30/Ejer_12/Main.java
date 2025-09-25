package Julian_30.Ejer_12;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 5, 10, 15, 20);
        int x = 7;
        double promedio = numeros.stream()
                .filter(n -> n > x)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Promedio mayores a " + x + ": " + promedio);
    }
}
