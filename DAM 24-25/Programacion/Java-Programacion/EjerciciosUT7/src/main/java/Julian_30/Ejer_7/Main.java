package Julian_30.Ejer_7;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> mayor = (a, b) -> a > b ? a : b;
        System.out.println(mayor.apply(5, 3)); // 5
    }
}
