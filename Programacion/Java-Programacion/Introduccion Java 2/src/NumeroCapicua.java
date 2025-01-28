import java.util.Scanner;

public class NumeroCapicua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero positivo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Por favor, introduce un número entero positivo.");
        } else {
            boolean esCapicua = esNumeroCapicua(numero);

            if (esCapicua) {
                System.out.println("El número " + numero + " es capicúa.");
            } else {
                System.out.println("El número " + numero + " no es capicúa.");
            }
        }
        scanner.close();
    }

    public static boolean esNumeroCapicua(int numero) {
        int numeroOriginal = numero;
        int numeroInvertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            numeroInvertido = numeroInvertido * 10 + digito;
            numero /= 10;
        }

        return numeroOriginal == numeroInvertido;
    }
}

