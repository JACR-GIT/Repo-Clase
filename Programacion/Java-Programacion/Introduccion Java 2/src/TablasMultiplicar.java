import java.util.Scanner;

public class TablasMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dime la tabla del 1 al 10 que quieres ver: ");
        int num1 = sc.nextInt();

        GenerarTablas(num1);
    }
    public static void GenerarTablas(int numero) {
        for (int i = 0; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " X " + i + " = " + resultado);
        }
    }
}