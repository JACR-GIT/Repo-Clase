import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MenuExamen {
    public static void mostrarMenu() {
        System.out.println("\nMenú de Ejercicios");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
        System.out.println("5. Ejercicio 5");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción (1-6): ");
    }

public static String saludaSegunHora
    public static boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                
            case 2:
                System.out.println("Ejecutando Ejercicio 2...");
                // Aquí puedes agregar la lógica del Ejercicio 2
                break;
            case 3:
                System.out.println("Ejecutando Ejercicio 3...");
                // Aquí puedes agregar la lógica del Ejercicio 3
                break;
            case 4:
                System.out.println("Ejecutando Ejercicio 4...");
                // Aquí puedes agregar la lógica del Ejercicio 4
                break;
            case 5:
                System.out.println("Ejecutando Ejercicio 5...");
                // Aquí puedes agregar la lógica del Ejercicio 5
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                return false;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 6.");
                return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                boolean continuar = ejecutarOpcion(opcion);
                if (!continuar) {
                    break;
                }
            } else {
                System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 6.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
