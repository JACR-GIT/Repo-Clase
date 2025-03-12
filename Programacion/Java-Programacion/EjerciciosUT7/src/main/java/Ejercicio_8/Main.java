package Ejercicio_8;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Carlos", 2000, 500);

        System.out.println("El salario del gerente es: " + gerente.calcularSalario()+ " €");
    }
}