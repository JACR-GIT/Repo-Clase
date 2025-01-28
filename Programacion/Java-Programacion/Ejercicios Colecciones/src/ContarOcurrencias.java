import java.util.ArrayList;
import java.util.HashMap;

public class ContarOcurrencias {
    public static void main(String[] args) {
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("manzana");
        palabras.add("banana");
        palabras.add("manzana");
        palabras.add("naranja");
        palabras.add("banana");
        palabras.add("manzana");

        HashMap<String, Integer> conteo = new HashMap<>();

        for (String palabra : palabras) {
            conteo.put(palabra, conteo.getOrDefault(palabra, 0) + 1);
        }

        for (String palabra : conteo.keySet()) {
            System.out.println(palabra + ": " + conteo.get(palabra));
        }
    }
}
