//Ejercicio 9: Operaciones con Decimales
//Objetivo: Usar variables de tipo double y realizar operaciones matemáticas.
//1. Instrucciones:
//○ Escribe un programa que calcule el área de un círculo dado su radio.
//○ Declara una variable double para el radio.
//○ Usa la fórmula: Área = π × radio² (usa Math.PI para el valor
//de π).
//○ Imprime el resultado en la consola.
//2. Sugerencias:
//○ Asegúrate de usar el operador de potencia (Math.pow) si es necesario.
//○ Experimenta cambiando el valor del radio para verificar los cálculos.
import java.util.Scanner;
public class OperacionesDecimalesRadio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el radio: ");
        double radio = scanner.nextDouble();

        System.out.println(operacionradio(radio));
    }

    public static double operacionradio(double radio){
        double area =  Math.round((Math.PI * Math.pow(radio, 2)) * 100.0)/100.0;
        return area;
    }
}
