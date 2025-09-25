import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1. ITERADORES
// Los iteradores permiten recorrer colecciones como listas o conjuntos de forma secuencial.
class IteradorExample {
    public static void mostrarIterador() {
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");

        Iterator<String> iterador = nombres.iterator();
        System.out.println("Recorriendo lista con iterador:");
        while (iterador.hasNext()) {
            String nombre = iterador.next();
            System.out.println(" - " + nombre);
        }
    }
}

// 2. VALIDAR SALUDO
// Valida si un saludo comienza con "Hola" o "Buenas" usando una condición simple.
class SaludoValidator {
    public static boolean esSaludoValido(String saludo) {
        return saludo != null && (saludo.startsWith("Hola") || saludo.startsWith("Buenas"));
    }

    public static void probarSaludo(String saludo) {
        if (esSaludoValido(saludo)) {
            System.out.println("Saludo válido: " + saludo);
        } else {
            System.out.println("Saludo inválido: " + saludo);
        }
    }
}

// 3. OPERADORES TERNARIOS
// El operador ternario es una forma concisa de escribir una condición if-else.
class TernarioExample {
    public static void verificarEdad(int edad) {
        String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
        System.out.println("Edad " + edad + ": " + resultado);
    }
}

// 4. EXPRESIONES REGULARES CON GRUPOS
// Las expresiones regulares permiten buscar patrones en texto; los grupos capturan partes específicas.
class RegexExample {
    public static void analizarExpresion(String texto) {
        // Patrón: busca algo como "variable = valor" y captura ambos lados
        String patron = "(\\w+)\\s*=\\s*(\\w+)";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            System.out.println("Expresión encontrada:");
            System.out.println(" - Variable: " + matcher.group(1)); // Primer grupo
            System.out.println(" - Valor: " + matcher.group(2));    // Segundo grupo
        } else {
            System.out.println("No se encontró una expresión válida en: " + texto);
        }
    }
}

// 5. Metodos de numeros
// Los metodos de numeros son metodos que se pueden aplicar a los numeros
class NumeroUtils {

    // Método para verificar si un número es par
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Método para calcular el cuadrado de un número
    public static int calcularCuadrado(int numero) {
        return numero * numero;
    }

    // Método para verificar si un número es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para calcular el factorial de un número
    public static long calcularFactorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo");
        }
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Método para encontrar el máximo común divisor (MCD) de dos números
    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Método para encontrar el mínimo común múltiplo (MCM) de dos números
    public static int calcularMCM(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }

    // Método para verificar si un número es un número de Armstrong
    public static boolean esNumeroArmstrong(int numero) {
        int original = numero;
        int suma = 0;
        int n = String.valueOf(numero).length();
        while (numero != 0) {
            int digito = numero % 10;
            suma += Math.pow(digito, n);
            numero /= 10;
        }
        return suma == original;
    }
}
