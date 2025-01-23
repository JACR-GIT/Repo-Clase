import java.util.Scanner;
public class EntradaUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.println("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Ingrese un numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese su numero: ");
        int num2 = scanner.nextInt();

        int resultado = num1 + num2;

        System.out.println("Hola, " + usuario + "." + "\nTu edad es de " + edad + "."
        + "\nLa suma de esos 2 numeros es: " + resultado);
    }
}
