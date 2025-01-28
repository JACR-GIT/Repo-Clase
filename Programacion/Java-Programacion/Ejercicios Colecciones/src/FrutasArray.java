import java.util.ArrayList;
import java.util.Collections;

public class FrutasArray {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Fresa");
        frutas.add("Mango");
        Collections.reverse(frutas);
        for (String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}
