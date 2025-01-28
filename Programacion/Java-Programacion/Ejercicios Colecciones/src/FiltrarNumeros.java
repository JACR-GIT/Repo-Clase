import java.util.ArrayList;

public class FiltrarNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numeros.add(i);
        }
        numeros.removeIf(numero -> numero % 2 != 0);
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
