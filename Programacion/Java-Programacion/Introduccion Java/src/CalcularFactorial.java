import java.util.Scanner;

public class CalcularFactorial {
    // Método para calcular el factorial de un número
    public static int calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        int resultado = 1; // Inicializar el resultado como 1
        for (int i = 1; i <= n; i++) {
            resultado *= i; // Multiplica acumulativamente
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar un número al usuario
        System.out.print("Ingresa un número entero para calcular su factorial: ");
        int numero = scanner.nextInt();

        // Calcular y mostrar el factorial
        try {
            int factorial = calcularFactorial(numero);
            System.out.println("El factorial de " + numero + " es: " + factorial);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}


