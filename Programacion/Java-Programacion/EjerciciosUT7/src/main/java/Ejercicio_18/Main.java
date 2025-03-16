package Ejercicio_18;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cadenas = List.of("Hola", "Mundo", "Java", "Lambda");

        cadenas.forEach(System.out::println);
    }
}
