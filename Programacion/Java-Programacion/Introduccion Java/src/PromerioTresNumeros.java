import java.util.Scanner;
public class PromerioTresNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer numero: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int num2 = scanner.nextInt();
        System.out.println("Ingrese el tercer numero: ");
        int num3 = scanner.nextInt();

        System.out.println("El promedio de " + num1 + ", " + num2 + " y " + num3 + " es de: " + promedio(num1,num2,num3));
    }
    public static double promedio ( int num1, int num2, int num3 ) {
        return (num1 + num2 + num3) / 3;
    }
}
