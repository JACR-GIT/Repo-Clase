package Julian_30.Ejer_26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> listas = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        int suma = listas.stream().flatMap(List::stream).mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);
    }
}
