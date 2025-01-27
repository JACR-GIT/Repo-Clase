import java.util.Scanner;

public class TrianguloAsteristicos {

    public void imprimirTriangulo(int tamaño) {
        for (int i = 1; i <= tamaño; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrianguloAsteristicos triangulo = new TrianguloAsteristicos();

        try {
            System.out.print("Ingresa el tamaño del triángulo: ");
            int tamaño = scanner.nextInt();

            if (tamaño <= 0) {
                System.out.println("Por favor, ingresa un número entero positivo.");
            } else {
                triangulo.imprimirTriangulo(tamaño);
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor, ingresa un número entero.");
        } finally {
            scanner.close();
        }
    }
}

