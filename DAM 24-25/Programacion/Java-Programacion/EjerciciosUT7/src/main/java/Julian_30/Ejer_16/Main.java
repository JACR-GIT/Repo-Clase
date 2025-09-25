package Julian_30.Ejer_16;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(123, 45, 6);
        int suma = numeros.stream()
                .mapToInt(n -> String.valueOf(n).chars().map(ch -> ch - '0').sum())
                .sum();
        System.out.println("Suma de dígitos: " + suma);
    }
}
