package Ejercicio_24;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        List<String> listaNombres = List.of("Juan", "Pedro", "Luis", "Ana", "Maria", "Jose", "Luisa", "Pepe", "Manuel", "Antonio");
        listaNombres.stream().distinct().sorted().forEach(System.out::println);
        listaNombres.stream()
                .distinct()
                .sorted((a, b) -> b.compareTo(a)) // Orden descendente
                .forEach(System.out::println);

    }
}
