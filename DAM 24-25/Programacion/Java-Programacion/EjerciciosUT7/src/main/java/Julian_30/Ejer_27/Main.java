package Julian_30.Ejer_27;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(-1, 2, -3, 4, 0);
        Map<Boolean, List<Integer>> particion = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n > 0));
        System.out.println("Positivos: " + particion.get(true));
        System.out.println("No positivos: " + particion.get(false));
    }
}
