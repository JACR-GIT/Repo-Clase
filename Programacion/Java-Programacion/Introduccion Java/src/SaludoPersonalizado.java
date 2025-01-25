import java.util.Scanner;
public class SaludoPersonalizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su usuario: ");
        String usuario = scanner.nextLine();


        System.out.println("¡Hola, "+ usuario +" ! Bienvenido a Java. ");
    }
}