package Julian_30.Ejer_30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> lista1 = Arrays.asList("hola", "adios");
        List<String> lista2 = Arrays.asList("hola", "chau");
        List<String> combinada = Stream.concat(lista1.stream(), lista2.stream())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(combinada);
    }
}
