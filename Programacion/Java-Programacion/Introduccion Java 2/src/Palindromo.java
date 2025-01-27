import java.util.Scanner;

public class Palindromo {

    // Método para verificar si una palabra o frase es un palíndromo
    public boolean esPalindromo(String texto) {
        String textoLimpio = texto.replaceAll("\\s+", "").toLowerCase();

        int inicio = 0;
        int fin = textoLimpio.length() - 1;

        while (inicio < fin) {
            if (textoLimpio.charAt(inicio) != textoLimpio.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Palindromo palindromo = new Palindromo();

        System.out.print("Ingresa una palabra o frase: ");
        String entrada = scanner.nextLine();

        if (palindromo.esPalindromo(entrada)) {
            System.out.println("El texto ingresado es un palíndromo.");
        } else {
            System.out.println("El texto ingresado NO es un palíndromo.");
        }

        scanner.close();
    }
}

