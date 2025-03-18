package Julian_30.Ejer_10;

import java.util.function.Supplier;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Supplier<Random> generador = () -> new Random();
        Random rand = generador.get();
        System.out.println("Número aleatorio: " + (rand.nextInt(100) + 1));
    }
}
