import java.util.Scanner;

public class CalculadoraBasica {
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: División entre cero no permitida.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraBasica calculadora = new CalculadoraBasica();

        try {
            System.out.print("Ingresa el primer número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Ingresa el segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.print("Elige una operación (suma, resta, multiplicación, división): ");
            String operacion = scanner.next().toLowerCase();

            double resultado;
            switch (operacion) {
                case "suma":
                    resultado = calculadora.sumar(num1, num2);
                    System.out.println("El resultado de la suma es: " + resultado);
                    break;
                case "resta":
                    resultado = calculadora.restar(num1, num2);
                    System.out.println("El resultado de la resta es: " + resultado);
                    break;
                case "multiplicación":
                case "multiplicacion":
                    resultado = calculadora.multiplicar(num1, num2);
                    System.out.println("El resultado de la multiplicación es: " + resultado);
                    break;
                case "división":
                case "division":
                    resultado = calculadora.dividir(num1, num2);
                    System.out.println("El resultado de la división es: " + resultado);
                    break;
                default:
                    System.out.println("Operación no válida.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor intenta de nuevo.");
        } finally {
            scanner.close();
        }
    }
}
