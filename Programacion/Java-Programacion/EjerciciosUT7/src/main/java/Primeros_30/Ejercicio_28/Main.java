package Ejercicio_28;

import java.util.List;

public class Main {
    public  static void main(String[] args) {
        List<Integer> numeros = List.of(3, 10, 15, 7, 8, 20, 25);
        int X = 10;

        long cantidad = numeros.stream()
                .filter(n -> n > X)
                .count();

        System.out.println("Hay " + cantidad + " números mayores que " + X);
    }
}
