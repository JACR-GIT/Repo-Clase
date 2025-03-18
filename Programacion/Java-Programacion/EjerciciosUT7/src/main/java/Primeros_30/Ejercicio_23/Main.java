package Ejercicio_23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List <String> listaCadenas = List.of("Esto es la primera", "Esta es la segunda cadena", "Esta es de todas la tercera cadena");

        long totalPalabras = listaCadenas.stream()
                .flatMap(frase -> Arrays.stream(frase.split("\\s+"))) // Separar en palabras
                .count(); // Contar todas las palabras

        // Imprimir el resultado
        System.out.println("Total de palabras: " + totalPalabras);
    }
}
