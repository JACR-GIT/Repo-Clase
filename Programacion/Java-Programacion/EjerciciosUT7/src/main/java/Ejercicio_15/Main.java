package Ejercicio_15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 2, 4, 5,11,7,8,9,10));
        Comparator<Integer> comparador = (a,b) -> b-a ;
        numeros.sort(comparador);
        System.out.println(numeros);
    }
}
