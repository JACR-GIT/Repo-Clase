import java.util.HashMap;
import java.util.Scanner;

public class UsoHashMap {
    public static void main(String[] args) {
        HashMap<String, String> paisesCapitales = new HashMap<>();
        paisesCapitales.put("España", "Madrid");
        paisesCapitales.put("Francia", "París");
        paisesCapitales.put("Italia", "Roma");
        paisesCapitales.put("Alemania", "Berlín");
        paisesCapitales.put("Japón", "Tokio");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escribe el nombre de un país: ");
        String pais = scanner.nextLine();

        if (paisesCapitales.containsKey(pais)) {
            System.out.println("La capital de " + pais + " es " + paisesCapitales.get(pais));
        } else {
            System.out.println("El país no está en el mapa.");
        }

        scanner.close();
    }
}
