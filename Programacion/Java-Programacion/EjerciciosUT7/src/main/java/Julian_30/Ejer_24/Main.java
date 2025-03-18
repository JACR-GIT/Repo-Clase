package Julian_30.Ejer_24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3);
        Transformador<Integer, String> aCadena = n -> "Num-" + n;
        List<String> resultado = numeros.stream().map(aCadena::transformar).collect(Collectors.toList());
        System.out.println(resultado);
    }
}
