import java.util.Scanner;

public class CalculoNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar las 5 notas al usuario
        System.out.println("Ingrese la nota de la asignatura 1: ");
        float nota1 = sc.nextFloat();
        System.out.println("Ingrese la nota de la asignatura 2: ");
        float nota2 = sc.nextFloat();
        System.out.println("Ingrese la nota de la asignatura 3: ");
        float nota3 = sc.nextFloat();
        System.out.println("Ingrese la nota de la asignatura 4: ");
        float nota4 = sc.nextFloat();
        System.out.println("Ingrese la nota de la asignatura 5: ");
        float nota5 = sc.nextFloat();

        // Llamar al método notamedia e imprimir el resultado
        System.out.println(notamedia(nota1, nota2, nota3, nota4, nota5));

        sc.close(); // Cerrar el scanner
    }

    public static String notamedia(float nota1, float nota2, float nota3, float nota4, float nota5) {
        float notamedia = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;

        // Usar el operador ternario para evaluar si está aprobado o no
        return notamedia + " " + (notamedia >= 5 ? "APROBADO" :"SUSPENDIDO");
    }
}

