package Ejercicio_25;

import java.util.Arrays;
import java.util.List;

public class Main {
    public  static void main(String[] args) {
        List<String> listaCadenas = List.of("Esto es la primera", "Esta es la segunda cadena", "Esta es de todas la tercera cadena");
        String totalPalabras = listaCadenas.stream()
                .flatMap(frase -> Arrays.stream(frase.split("\\s+"))) // Separar en palabras
                .reduce((a,b)-> a.length() > b.length() ? a : b).orElse("");

        System.out.println("La frase más larga es: " + totalPalabras);
    }
}
