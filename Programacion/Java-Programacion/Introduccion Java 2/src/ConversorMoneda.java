import java.util.Scanner;

public class ConversorMoneda {
    private static final double TASA_EURO_DOLAR = 1.10;
    private static final double TASA_DOLAR_EURO = 0.91;

    public double convertirEurosADolares(double euros) {
        return euros * TASA_EURO_DOLAR;
    }

    public double convertirDolaresAEuros(double dolares) {
        return dolares * TASA_DOLAR_EURO;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        try {
            System.out.print("Ingresa la cantidad: ");
            double cantidad = scanner.nextDouble();

            System.out.print("¿Qué conversión deseas realizar? (euros a dólares / dólares a euros): ");
            String conversion = scanner.next().toLowerCase();

            double resultado;
            switch (conversion) {
                case "euros a dólares":
                case "euros a dolares":
                    resultado = conversor.convertirEurosADolares(cantidad);
                    System.out.printf("%.2f euros son %.2f dólares.%n", cantidad, resultado);
                    break;
                case "dólares a euros":
                case "dolares a euros":
                    resultado = conversor.convertirDolaresAEuros(cantidad);
                    System.out.printf("%.2f dólares son %.2f euros.%n", cantidad, resultado);
                    break;
                default:
                    System.out.println("Conversión no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor ingresa un número válido.");
        } finally {
            scanner.close();
        }
    }
}

