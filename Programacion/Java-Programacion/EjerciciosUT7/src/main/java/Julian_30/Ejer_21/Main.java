package Julian_30.Ejer_21;

import java.util.function.Function;
public class Main {
    public static void main(String[] args) {
        Texto texto = new Texto();
        Function<String, Integer> contar = texto::contarLetras;
        System.out.println(contar.apply("Hola")); // 4
    }
}
