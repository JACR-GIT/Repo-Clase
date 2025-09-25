package com;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ######################################################
 * #      CHULETA DEFINITIVA DE JAVA - VERSIÓN TEMÁTICA      #
 * ######################################################
 *
 * Estructurada según las Unidades Temáticas (UT5, UT6, UT7).
 * Contiene ejemplos didácticos para CADA CONCEPTO y CADA FILA de las tablas de las presentaciones.
 *
 * --- ÍNDICE ---
 * 1. UT5_IntroduccionJava: Tipos, variables, operadores, bucles, condicionales, colecciones básicas.
 * 2. UT6_POO_Y_ClasesComunes: POO (herencia, polimorfismo), `equals`, `hashCode`, `Comparable`, `Comparator`, Clases comunes (String, Math, Time).
 * 3. UT7_ConceptosAvanzados: Interfaces, Clases Abstractas, Lambdas, Streams, Regex.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- DEMOSTRACIÓN DE LA CHULETA DE JAVA ---");
        System.out.println("\n--- UT5: Fundamentos ---");
        UT5_IntroduccionJava.EstructurasDeDatosBasicas.demostracionListas();

        System.out.println("\n--- UT6: Clases Comunes (String) ---");
        UT6_POO_Y_ClasesComunes.ClasesDeUsoComun.demostracionMetodosString();

        System.out.println("\n--- UT7: Conceptos Avanzados (Streams) ---");
        UT7_ConceptosAvanzados.ExpresionesLambdaYStreams.demostracionStreams();
        UT7_ConceptosAvanzados.ExpresionesRegulares.demostracionRegex();

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Cerveza");
        lista.add("Ron-cola");
        lista.add("Gin-tonic");
        // Obtener el iterador de la colección
        Iterator<String> iterador = lista.iterator();
        // Recorrer la colección con el iterador
        while (iterador.hasNext()) {
            String elemento = iterador.next();
            System.out.println("Elemento: " + elemento);
            // Ejemplo de eliminar un elemento
            if (elemento.equals("Ron-cola")) {
                iterador.remove();
            }
        }
        System.out.println("Lista después de usar el iterador: " + lista);
    }
}

// ============================================================================================
// --- UNIDAD 5: INTRODUCCIÓN A JAVA ---
// ============================================================================================
class UT5_IntroduccionJava {

    public static class AsignacionesYTiposPrimitivos {
        public static void demostracion() {
            // --- Tipos de datos primitivos ---
            byte miByte = 100;              // 1 byte
            short miShort = 30000;          // 2 bytes
            int miInt = 2000000000;         // 4 bytes (el más común)
            long miLong = 9000000000000000000L; // 8 bytes (necesita 'L' al final)

            float miFloat = 3.14f;          // 4 bytes (necesita 'f' al final)
            double miDouble = 3.1415926535; // 8 bytes (el más común para decimales)

            char miChar = 'A';              // 2 bytes (un solo carácter, comillas simples)
            char charDeString = "Hola".charAt(1); // 'o'

            boolean miBoolean = true;       // true o false

            // --- Constantes con 'final' ---
            final double PI = 3.1416;
            // PI = 3.14; // Error de compilación, no se puede reasignar

            // --- Conversión de tipos (Casting) ---
            int entero = 100;
            double decimal = (double) entero; // Casting explícito (aunque en este caso es implícito)

            double decimalGrande = 123.78;
            int enteroCortado = (int) decimalGrande; // Se pierde la parte decimal -> 123

            // --- Operadores abreviados ---
            int contador = 10;
            contador += 5; // Equivale a: contador = contador + 5; -> 15
            contador *= 2; // Equivale a: contador = contador * 2; -> 30

            // --- Operadores de incremento/decremento ---
            int a = 5;
            int b = ++a; // Pre-incremento: a se incrementa a 6, LUEGO b se asigna a 6. (a=6, b=6)

            int c = 5;
            int d = c++; // Post-incremento: d se asigna a 5, LUEGO c se incrementa a 6. (c=6, d=5)
        }
    }

    public static class CondicionalesYBucles {
        public static void demostracion() {
            // --- Condicional if-else ---
            int edad = 20;
            if (edad >= 18) {
                System.out.println("Es mayor de edad.");
            } else {
                System.out.println("Es menor de edad.");
            }

            // --- Switch (expresión, Java 14+) ---
            int dia = 3;
            String nombreDia = switch(dia) {
                case 1 -> "Lunes";
                case 2 -> "Martes";
                case 3 -> "Miércoles";
                default -> "Día no válido";
            };

            // --- Bucle for-each (el más recomendado para colecciones) ---
            List<String> frutas = Arrays.asList("Manzana", "Pera", "Naranja");
            for (String fruta : frutas) {
                System.out.println(fruta);
            }

            // --- Bucle while con continue y break ---
            int i = 0;
            while(i < 10) {
                i++;
                if (i % 2 == 0) {
                    continue; // Salta a la siguiente iteración si es par
                }
                if (i > 7) {
                    break; // Termina el bucle si es mayor que 7
                }
                System.out.println("Número impar: " + i);
            }
        }
    }

    public static class EstructurasDeDatosBasicas {
        public static void demostracionListas() {
            // List: Ordenada, permite duplicados. ArrayList es la implementación más común.
            List<String> nombres = new ArrayList<>();
            nombres.add("Ana");
            nombres.add("Luis");
            nombres.add(0, "Zoe"); // Añade en una posición específica
            nombres.add("Ana");
            System.out.println("Lista: " + nombres); // [Zoe, Ana, Luis, Ana]
            nombres.remove("Luis"); // Elimina un elemento
            System.out.println("Elemento en pos 0: " + nombres.get(0)); // Zoe
        }

        public static void demostracionSets() {
            // Set: No ordenado (HashSet) o ordenado (TreeSet), no permite duplicados.
            Set<String> unicos = new HashSet<>();
            unicos.add("Rojo");
            unicos.add("Verde");
            unicos.add("Rojo"); // No se añade, ya existe
            System.out.println("HashSet (sin orden): " + unicos);

            Set<String> ordenados = new TreeSet<>(unicos); // TreeSet ordena los elementos
            System.out.println("TreeSet (ordenado): " + ordenados);
        }

        public static void demostracionMapas() {
            // Map: Pares clave-valor. Claves únicas. HashMap es la implementación más común.
            Map<String, Integer> edades = new HashMap<>();
            edades.put("Ana", 25);
            edades.put("Luis", 30);
            edades.put("Ana", 26); // Actualiza el valor de la clave "Ana"
            System.out.println("Mapa: " + edades);
            System.out.println("Edad de Luis: " + edades.get("Luis"));
        }
    }
}


// ============================================================================================
// --- UNIDAD 6: POO Y CLASES COMUNES ---
// ============================================================================================
class UT6_POO_Y_ClasesComunes {

    // --- Clase de ejemplo para las demostraciones ---
    static class Persona implements Comparable<Persona> {
        private final String nombre;
        private final int edad;

        public Persona(String nombre, int edad) { this.nombre = nombre; this.edad = edad; }
        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }

        // --- Orden Natural: por edad ---
        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        // --- Igualdad: dos personas son iguales si tienen el mismo nombre y edad ---
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Persona persona = (Persona) o;
            return edad == persona.edad && Objects.equals(nombre, persona.nombre);
        }

        // --- Contrato equals-hashCode: si son equals, deben tener el mismo hashCode ---
        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }

        @Override public String toString() { return nombre + " (" + edad + " años)"; }
    }

    public static class HerenciaYPolimorfismo {
        // Superclase abstracta
        public static abstract class Animal {
            protected String nombre;
            public Animal(String nombre) { this.nombre = nombre; }
            public abstract void hacerSonido(); // Método abstracto
            public void dormir() { System.out.println(nombre + " está durmiendo (Zzz)..."); }
        }

        // Subclase que hereda de Animal
        public static class Perro extends Animal {
            public Perro(String nombre) {
                super(nombre); // Llama al constructor de la clase padre
            }
            @Override
            public void hacerSonido() { // Implementa el método abstracto
                System.out.println(nombre + " dice: ¡Guau!");
            }
        }
        public static void demostracion() {
            Animal miPerro = new Perro("Fido");
            miPerro.hacerSonido(); // Polimorfismo: se llama a la implementación de Perro
            miPerro.dormir();     // Se llama al método heredado de Animal
        }
    }

    public static class ComparacionExternaConComparator {
        public static void demostracion() {
            List<Persona> personas = new ArrayList<>(List.of(
                    new Persona("Ana", 30), new Persona("Carlos", 22), new Persona("Juan", 25)
            ));

            // Orden por defecto (Comparable: por edad)
            Collections.sort(personas);
            System.out.println("Orden natural (edad): " + personas);

            // Orden externo con Comparator (por nombre)
            Comparator<Persona> porNombre = Comparator.comparing(Persona::getNombre);
            personas.sort(porNombre);
            System.out.println("Orden por nombre: " + personas);

            // Orden inverso
            personas.sort(porNombre.reversed());
            System.out.println("Orden por nombre (inverso): " + personas);
        }
    }

    public static class ClasesDeUsoComun {
        /** Demostración de CADA método de la tabla de String */
        public static void demostracionMetodosString() {
            System.out.println("\n--- Demostración Métodos de String ---");
            String a = "  Hola Mundo  ";
            String b = "hola mundo";

            System.out.println("charAt(3): " + a.trim().charAt(3)); // 'a'
            System.out.println("indexOf('M'): " + a.trim().indexOf('M')); // 5
            System.out.println("substring(5, 10): " + a.trim().substring(5, 10)); // "Mundo"
            System.out.println("toLowerCase(): " + a.trim().toLowerCase()); // "hola mundo"
            System.out.println("toUpperCase(): " + a.trim().toUpperCase()); // "HOLA MUNDO"
            System.out.println("equals(b): " + a.trim().equals(b)); // false (distingue mayúsculas)
            System.out.println("equalsIgnoreCase(b): " + a.trim().equalsIgnoreCase(b)); // true
            System.out.println("compareTo(b): " + a.trim().compareTo(b)); // < 0 porque 'H' < 'h'
            System.out.println("replace('o', 'a'): " + a.trim().replace('o', 'a')); // "Hala Munda"
            System.out.println("trim(): '" + a.trim() + "'"); // "Hola Mundo"
            System.out.println("split(' '): " + Arrays.toString(a.trim().split(" "))); // "[Hola, Mundo]"
            System.out.println("startsWith(\"Hola\"): " + a.trim().startsWith("Hola")); // true
            System.out.println("endsWith(\"Mundo\"): " + a.trim().endsWith("Mundo")); // true
            System.out.println("contains(\"la M\"): " + a.trim().contains("la M")); // true
        }

        public static void demostracionMetodosNumericos() {
            System.out.println("\n--- Demostración Métodos de Integer, Long, Float y Double ---");
            // Integer
            String strNum = "123";
            Integer a = 42;
            Integer b = 100;
            System.out.println("Integer.parseInt(\"123\"): " + Integer.parseInt(strNum)); // 123
            System.out.println("Integer.valueOf(\"123\"): " + Integer.valueOf(strNum)); // 123
            System.out.println("a.toString(): " + a.toString()); // "42"
            System.out.println("Integer.toString(100): " + Integer.toString(100)); // "100"
            System.out.println("Integer.max(42, 100): " + Integer.max(a, b)); // 100
            System.out.println("Integer.min(42, 100): " + Integer.min(a, b)); // 42
            System.out.println("Integer.compare(42, 100): " + Integer.compare(a, b)); // -1
            System.out.println("a.compareTo(100): " + a.compareTo(100)); // -1
            System.out.println("a.equals(42): " + a.equals(42)); // true

            // Long
            String strLong = "123456789";
            System.out.println("Long.parseLong(\"123456789\"): " + Long.parseLong(strLong)); // 123456789

            // Float
            String strFloat = "3.14";
            System.out.println("Float.parseFloat(\"3.14\"): " + Float.parseFloat(strFloat)); // 3.14

            // Double
            String strDouble = "2.718";
            System.out.println("Double.parseDouble(\"2.718\"): " + Double.parseDouble(strDouble)); // 2.718
        }

        /** Demostración de CADA método de la tabla de Math */
        public static void demostracionMetodosMath() {
            System.out.println("\n--- Demostración Métodos de Math ---");
            System.out.println("Math.abs(-5.5): " + Math.abs(-5.5)); // 5.5
            System.out.println("Math.pow(2, 3): " + Math.pow(2, 3)); // 8.0
            System.out.println("Math.sqrt(16): " + Math.sqrt(16)); // 4.0
            System.out.println("Math.round(4.7): " + Math.round(4.7)); // 5 (long)
            System.out.println("Math.ceil(4.1): " + Math.ceil(4.1)); // 5.0 (hacia arriba)
            System.out.println("Math.floor(4.9): " + Math.floor(4.9)); // 4.0 (hacia abajo)
            System.out.println("Math.random() (entre 0.0 y 1.0): " + Math.random());
        }

        public static void demostracionFechasYHoras() {
            System.out.println("\n--- Demostración LocalDate y LocalTime ---");
            LocalDate hoy = LocalDate.now();
            System.out.println("Hoy: " + hoy);
            LocalDate cumple = LocalDate.of(2025, 5, 20);
            System.out.println("Mi cumple: " + cumple);
            System.out.println("Mañana será: " + hoy.plusDays(1));
            System.out.println("Día de la semana: " + hoy.getDayOfWeek());

            LocalTime ahora = LocalTime.now();
            System.out.println("Ahora: " + ahora);
            System.out.println("Hora en 2h: " + ahora.plusHours(2));

            // Formateo
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("Formateado: " + hoy.atTime(ahora).format(formato));
        }
    }
}


// ============================================================================================
// --- UNIDAD 7: CONCEPTOS AVANZADOS ---
// ============================================================================================
class UT7_ConceptosAvanzados {

    public static class InterfacesYClasesAbstractas {
        // Interfaz: define un CONTRATO (qué se debe hacer)
        interface Volador {
            void volar(); // Todos los métodos son public abstract por defecto
        }

        // Clase Abstracta: puede tener estado y métodos implementados y abstractos
        abstract static class Ave {
            abstract void ponerHuevos(); // Las aves ponen huevos
            void cantar() { System.out.println("Pio pio"); } // Implementación común
        }

        // Clase que implementa la interfaz y hereda de la clase abstracta
        static class Paloma extends Ave implements Volador {
            @Override
            public void volar() { System.out.println("La paloma vuela por la ciudad."); }
            @Override
            void ponerHuevos() { System.out.println("La paloma ha puesto un huevo."); }
        }
    }

    public static class ExpresionesLambdaYStreams {
        /** Demostración de sintaxis de Lambdas */
        public static void demostracionLambdas() {
            // 1. Lambda sin parámetros
            Runnable tarea = () -> System.out.println("Hola desde un lambda.");
            tarea.run();

            // 2. Lambda con un solo parámetro
            Function<String, String> aMayusculas = (s) -> s.toUpperCase();
            System.out.println(aMayusculas.apply("texto"));

            // 3. Lambda con varios parámetros (una línea)
            Comparator<Integer> comparador = (n1, n2) -> n1.compareTo(n2);

            // 4. Lambda con bloque de código
            Function<Integer, Boolean> esPrimo = (num) -> {
                if (num <= 1) return false;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) return false;
                }
                return true;
            };
            System.out.println("¿Es 7 primo? " + esPrimo.apply(7));
        }

        /** Demostración de Streams API */
        public static void demostracionStreams() {
            List<String> nombres = Arrays.asList("Ana", "Juan", "Alberto", "Pedro", "Antonia");

            // filter (filtra), map (transforma), sorted (ordena), collect (recopila)
            List<String> resultado = nombres.stream()
                    .filter(nombre -> nombre.startsWith("A"))
                    .map(String::toUpperCase)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println("Nombres que empiezan por 'A', en mayúsculas y ordenados: " + resultado);

            // reduce (agrega a un solo valor)
            int totalLetras = nombres.stream()
                    .mapToInt(String::length)
                    .reduce(0, (acumulador, longitud) -> acumulador + longitud);
            System.out.println("Total de letras en todos los nombres: " + totalLetras);

            // anyMatch, allMatch, noneMatch
            boolean hayAlgunoConP = nombres.stream().anyMatch(n -> n.startsWith("P")); // true
            boolean todosTienenMasDe3Letras = nombres.stream().allMatch(n -> n.length() > 3); // true
        }
    }

    public static class ExpresionesRegulares {
        private static void testRegex(String regex, String texto, String descripcion) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(texto);
            System.out.print(descripcion + " | Regex: '" + regex + "' | Texto: '" + texto + "' -> Encontrado: ");
            boolean encontrado = false;
            while(matcher.find()) {
                System.out.print("'" + matcher.group() + "' ");
                encontrado = true;
            }
            if (!encontrado) System.out.print("ninguno");
            System.out.println();
        }

        /** Demostración de CADA símbolo de la tabla de Regex */
        public static void demostracionRegex() {
            System.out.println("\n--- Demostración Símbolos Regex ---");
            testRegex(".", "a b c", "'.' (cualquier carácter)");
            testRegex("^a", "abc", "'^' (inicio de línea)");
            testRegex("c$", "abc", "'$' (fin de línea)");
            testRegex("a*", "aaabc", "'*' (0 o más 'a')");
            testRegex("a+", "aaabc", "'+' (1 o más 'a')");
            testRegex("a?b", "ab", "'?' (0 o 1 'a' antes de 'b')");
            testRegex("\\d{3}", "12345", "'{n}' (exactamente 3 dígitos)");
            testRegex("\\d{2,}", "12345", "'{n,}' (2 o más dígitos)");
            testRegex("\\d{2,4}", "12345", "'{n,m}' (entre 2 y 4 dígitos)");
            testRegex("[aeiou]", "hola", "'[]' (una vocal)");
            testRegex("[^aeiou]", "hola", "'[^]' (no vocal)");
            testRegex("a|b", "bca", "'|' (a o b)");
            testRegex("(la)", "lalala", "'()' (grupo de captura)");
            testRegex("\\d", "abc123xyz", "'\\d' (un dígito)");
            testRegex("\\D", "abc123xyz", "'\\D' (no dígito)");
            testRegex("\\w", "a-b_1*2", "'\\w' (carácter de palabra)");
            testRegex("\\W", "a-b_1*2", "'\\W' (no carácter de palabra)");
            testRegex("\\s", "a b\tc", "'\\s' (espacio en blanco)");
            testRegex("\\S", "a b\tc", "'\\S' (no espacio en blanco)");
            testRegex("\\bcat\\b", "the cat catalog", "'\\b' (límite de palabra)");
        }
    }
}