package Ejercicio_30;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> listaNombres = List.of("Juan", "Pedro", "Maria", "Ana", "Luis", "Carlos", "Jose", "Luisa", "Marta", "Lucia");

        Map<Character, List<String>> nombresAgrupados = listaNombres.stream()
                .collect(Collectors.groupingBy(p -> p.charAt(0)));

        System.out.println(nombresAgrupados);
    }
}
