package Julian_30.Ejer_14;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cadenas = Arrays.asList("hola", "", "adios", "");
        long vacias = cadenas.stream().filter(String::isEmpty).count();
        System.out.println("Cadenas vacías: " + vacias);
    }
}
