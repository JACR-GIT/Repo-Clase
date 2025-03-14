package Ejercicio_13;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List <Integer> numeros = List.of(2,3,5,6,8);
        Consumer<Integer> imprimirNumero = numero -> System.out.println(numero*2);
        for (Integer numero : numeros) {
            imprimirNumero.accept(numero);
        }
    }
}
