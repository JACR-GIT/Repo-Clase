package Julian_30.Ejer_17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        Map<String, List<Integer>> porParidad = numeros.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "par" : "impar"));
        System.out.println(porParidad);
    }
}