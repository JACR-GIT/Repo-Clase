package Julian_30.Ejer_11;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 3, 6, 8, 9);
        numeros.stream().filter(n -> n % 3 == 0).forEach(System.out::println);
    }
}
