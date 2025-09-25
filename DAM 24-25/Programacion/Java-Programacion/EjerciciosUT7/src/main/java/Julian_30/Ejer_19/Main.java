package Julian_30.Ejer_19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> cadenas = Arrays.asList("hola", "adios", "hi");
        List<String> sinVocales = cadenas.stream()
                .map(s -> s.replaceAll("[aeiouAEIOU]", ""))
                .collect(Collectors.toList());
        System.out.println(sinVocales);
    }
}
