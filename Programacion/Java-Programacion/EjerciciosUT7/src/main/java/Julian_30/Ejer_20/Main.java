package Julian_30.Ejer_20;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Long> factoriales = numeros.stream()
                .map(n -> factorial(n))
                .collect(Collectors.toList());
        System.out.println(factoriales);
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}
