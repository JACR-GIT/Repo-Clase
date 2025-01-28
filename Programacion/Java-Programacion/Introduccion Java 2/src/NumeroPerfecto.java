import java.util.Scanner;

public class NumeroPerfecto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario un número entero positivo
        System.out.print("Introduce un número entero positivo: ");
        int numero = scanner.nextInt();

        // Validar que el número sea positivo
        if (numero <= 0) {
            System.out.println("Por favor, introduce un número entero positivo.");
        } else {
            // Determinar si el número es perfecto
            boolean esPerfecto = esNumeroPerfecto(numero);

            // Mostrar el resultado
            if (esPerfecto) {
                System.out.println("El número " + numero + " es un número perfecto.");
            } else {
                System.out.println("El número " + numero + " no es un número perfecto.");
            }
        }

        scanner.close();
    }

    // Método para determinar si un número es perfecto
    public static boolean esNumeroPerfecto(int numero) {
        int sumaDivisores = 0;

        // Recorrer los posibles divisores desde 1 hasta la mitad del número
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) { // Si es divisor
                sumaDivisores += i;
            }
        }

        // Verificar si la suma de los divisores es igual al número
        return sumaDivisores == numero;
    }
}
