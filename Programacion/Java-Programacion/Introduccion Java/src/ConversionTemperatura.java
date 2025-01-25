import java.util.Scanner;

public class ConversionTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de la temperatura en celsius: ");
        double TemperaturaC = scanner.nextDouble();

        System.out.println(operacion(TemperaturaC));
    }
    public static double operacion(double TemperaturaC) {
        double TemperaturaF = TemperaturaC * ((double)9/5) + 32;
        return TemperaturaF;
    }
}