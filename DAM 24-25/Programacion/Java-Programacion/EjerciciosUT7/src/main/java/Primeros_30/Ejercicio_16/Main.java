package Ejercicio_16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>(List.of(
                new Persona("Ana", 25),
                new Persona("Pedro", 30),
                new Persona("Luis", 20)
        ));

        Comparator<Persona> coparadorEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();
        personas.sort(coparadorEdad);
        System.out.println(personas);
    }
}
