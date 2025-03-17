package Ejercicio_29;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Persona> listaPersonas = List.of(
                new Persona("Ana", 25),
                new Persona("Pedro", 30),
                new Persona("Luis", 22)
        );

        List<String> listaNombres = listaPersonas.stream()
                .map(Persona::getNombre)
                .collect(Collectors.toList());

        System.out.println(listaNombres);
    }
}
