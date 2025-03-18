package Julian_30.Ejer_15;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("hola", "adios", "hi", "saludos");
        palabras.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .forEach(System.out::println);
    }
}
