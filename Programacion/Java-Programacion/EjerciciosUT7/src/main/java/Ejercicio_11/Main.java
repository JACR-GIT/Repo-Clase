package Ejercicio_11;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> listaNombres = List.of("Ana", "Pedro", "Alberto", "Beatriz", "Antonio");

        Predicate<String> empiezaConA =  nombre -> nombre.startsWith("A");


        for (String nombre : listaNombres) {
            if (empiezaConA.test(nombre)) {
                System.out.println(nombre);
            }
        }
    }
}
