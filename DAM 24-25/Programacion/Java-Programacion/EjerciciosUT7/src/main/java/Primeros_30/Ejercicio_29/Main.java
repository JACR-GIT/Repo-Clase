package Primeros_30.Ejercicio_29;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Ejercicio_29.Persona> listaPersonas = List.of(
                new Ejercicio_29.Persona("Ana", 25),
                new Ejercicio_29.Persona("Pedro", 30),
                new Ejercicio_29.Persona("Luis", 22)
        );

        List<String> listaNombres = listaPersonas.stream()
                .map(Ejercicio_29.Persona::getNombre)
                .collect(Collectors.toList());

        System.out.println(listaNombres);
    }
}
