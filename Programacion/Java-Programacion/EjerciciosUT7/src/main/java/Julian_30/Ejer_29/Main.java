package Julian_30.Ejer_29;

import java.util.function.Supplier;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> dado = () -> new Random().nextInt(6) + 1;
        List<Integer> tiradas = Stream.generate(dado).limit(10).collect(Collectors.toList());
        System.out.println("Tiradas: " + tiradas);
    }
}