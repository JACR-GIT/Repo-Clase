import java.util.Scanner;

public class ContadorDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numero = -1;

        while (numero < 0) {
            System.out.print("Introduce un número entero positivo: ");
            if (scanner.hasNextLong()) {
                numero = scanner.nextLong();
                if (numero < 0) {
                    System.out.println("El número debe ser positivo. Inténtalo nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                scanner.next();
            }
        }

        int contadorDigitos = contarDigitos(numero);

        // Mostrar el resultado
        System.out.println("El número " + numero + " tiene " + contadorDigitos + " dígitos.");

        scanner.close();
    }

    // Método para contar los dígitos de un número
    public static int contarDigitos(long numero) {
        int contador = 0;
        do {
            numero /= 10;
            contador++;
        } while (numero != 0);
        return contador;
    }
}

