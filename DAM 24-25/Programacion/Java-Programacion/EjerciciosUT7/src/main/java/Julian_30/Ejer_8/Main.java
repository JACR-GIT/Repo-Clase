package Julian_30.Ejer_8;

import java.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> aMayusculas = s -> s.toUpperCase();
        List<String> nombres = Arrays.asList("juan", "maría", "pedro");
        nombres.stream().map(aMayusculas).forEach(System.out::println);
    }
}
