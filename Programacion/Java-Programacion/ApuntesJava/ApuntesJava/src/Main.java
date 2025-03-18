public class Main {
    public static void main(String[] args) {
        // Iteradores
        IteradorExample.mostrarIterador();

        // Validar saludo
        System.out.println("\nProbando saludos:");
        SaludoValidator.probarSaludo("Hola, mundo");
        SaludoValidator.probarSaludo("Buenas tardes");
        SaludoValidator.probarSaludo("Adiós");

        // Operadores ternarios
        System.out.println("\nVerificando edades:");
        TernarioExample.verificarEdad(20);
        TernarioExample.verificarEdad(15);

        // Expresiones regulares con grupos
        System.out.println("\nAnalizando expresiones:");
        RegexExample.analizarExpresion("x = 5");
        RegexExample.analizarExpresion("exp = exp");
        RegexExample.analizarExpresion("exp && valor");
    }
}