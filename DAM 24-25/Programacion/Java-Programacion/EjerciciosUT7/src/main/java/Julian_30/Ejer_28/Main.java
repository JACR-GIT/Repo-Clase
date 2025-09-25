package Julian_30.Ejer_28;

import java.util.Arrays;
import java.util.List;
import java.util.IntSummaryStatistics;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 7);
        IntSummaryStatistics stats = numeros.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Mínimo: " + stats.getMin());
    }
}
