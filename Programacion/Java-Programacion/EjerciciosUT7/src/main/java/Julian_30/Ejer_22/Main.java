package Julian_30.Ejer_22;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(-1, 2, -3, 4);
        List<Integer> absolutos = numeros.stream().map(Math::abs).collect(Collectors.toList());
        System.out.println(absolutos);
    }
}
