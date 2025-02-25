import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Explicacion {
//    Resumen/Esquema para Dominar los Puntos del Examen de 1º DAM

//1. Uso de Librerías
//    Definición: Las librerías en Java son colecciones de clases y métodos predefinidos que facilitan tareas comunes (por ejemplo, java.util para estructuras de datos, java.time para fechas y horas).
//    Cómo usarlas:
//    Importar las librerías necesarias al inicio del código con import.
//    Ejemplo: import java.util.Scanner; para leer entrada del usuario, o import java.time.LocalTime; para manejar horas.
//    Consejos para el examen:
//    Familiarízate con las librerías estándar de Java (por ejemplo, java.util, java.io, java.time).
//    Practica importar y usar clases como ArrayList, Scanner, o LocalDate/Time.
//    Ejemplo práctico:

    public class EjemploLibreria {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Hola, " + nombre + "!");
            scanner.close();
        }
    }

//2. Creación de Clases
//    Definición: Una clase en Java es un modelo o plantilla para crear objetos, definiendo atributos (variables) y métodos (comportamientos).
//    Elementos principales:
//    Atributos: Variables dentro de la clase (públicos, privados, etc.).
//    Métodos: Funciones que operan sobre los atributos (por ejemplo, constructores, getters, setters).
//    Constructores: Métodos especiales para inicializar objetos.
//    Sintaxis básica:

    public class Persona {
        // Atributos
        private String nombre;
        private int edad;

        // Constructor
        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        // Métodos
        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        }
    }

//    Consejos para el examen:
//    Aprende a crear clases con atributos privados y métodos públicos (encapsulamiento).
//    Practica instanciar objetos y usar constructores.
//    Entiende la diferencia entre clases públicas, abstractas e interfaces (aunque no se menciona explícitamente, puede ser útil).

//    3. Herencia
//    Definición: Mecanismo por el cual una clase (subclase) hereda atributos y métodos de otra clase (superclase) usando la palabra clave extends.
//    Ventajas: Reutilización de código y polimorfismo.
//    Sintaxis básica:

    public class Animal {
        protected String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public void hacerSonido() {
            System.out.println("Sonido genérico");
        }
    }

    public class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: ¡Guau!");
        }
    }

//    Consejos para el examen:
//    Entiende super para llamar al constructor o métodos de la superclase.
//    Practica el uso de @Override para sobrescribir métodos.
//    Aprende sobre herencia múltiple (usando interfaces, ya que Java no permite herencia múltiple de clases).

//     4. Igualdad y Comparación
//    Definición:
//    Igualdad (==): Compara si dos objetos ocupan la misma dirección de memoria (referencias).
//    Comparación (equals()): Compara el contenido o valor de los objetos (debe sobrescribirse en la clase si es necesario).
//    Método compareTo(): Usado en interfaces como Comparable para ordenar objetos (devuelve un entero: negativo, cero o positivo).
//    Ejemplo:

    public class Persona implements Comparable<Persona> {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Persona persona = (Persona) obj;
            return edad == persona.edad && nombre.equals(persona.nombre);
        }

        @Override
        public int compareTo(Persona otra) {
            return this.nombre.compareTo(otra.nombre); // Compara por nombre
        }

        @Override
        public String toString() {
            return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
        }
    }

//    Consejos para el examen:
//    Practica sobrescribir equals() y hashCode() juntos (si usas equals, debes usar hashCode).
//    Entiende la diferencia entre == y equals().
//    Aprende a usar Comparable o Comparator para ordenar objetos.

//5. Estructuras de Datos y Ordenación de las Mismas
//    Definición: Estructuras de datos son formas de organizar y almacenar datos (por ejemplo, arrays, listas, conjuntos, mapas). Ordenación implica organizar esos datos (por ejemplo, de forma ascendente o descendente).
//    Estructuras comunes en Java:
//    Arrays: Arreglos fijos (int[], String[]).
//    Listas: ArrayList, LinkedList (de java.util).
//    Conjuntos: HashSet, TreeSet (sin duplicados, ordenados o no).
//    Mapas: HashMap, TreeMap (clave-valor).
//    Métodos de ordenación:
//    Usar Collections.sort() para listas.
//    Implementar Comparable o Comparator para objetos personalizados.
//            Ejemplo:


    public class EjemploEstructuras {
        public static void main(String[] args) {
            ArrayList<Integer> numeros = new ArrayList<>();
            numeros.add(5);
            numeros.add(2);
            numeros.add(8);

            Collections.sort(numeros); // Ordena de forma ascendente
            System.out.println("Números ordenados: " + numeros);
        }
    }
//    Consejos para el examen:
//    Practica usar ArrayList, HashSet, HashMap, y sus métodos principales (add, remove, size, etc.).
//    Aprende a ordenar con Collections.sort() o Arrays.sort().
//    Entiende la diferencia entre estructuras ordenadas (TreeSet, TreeMap) y no ordenadas (HashSet, HashMap).

//    6. Algo (No Mucho) de Expresiones Regulares
//    Definición: Expresiones regulares (regex) son patrones para buscar, validar o manipular texto (por ejemplo, validar emails, números, etc.).
//    Uso básico en Java:
//    Usar la clase Pattern y Matcher de java.util.regex.
//            Ejemplo: Validar un email con regex.


    public class EjemploRegex {
        public static void main(String[] args) {
            String email = "usuario@dominio.com";
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                System.out.println("Email válido!");
            } else {
                System.out.println("Email no válido.");
            }
        }
    }
//    Consejos para el examen:
//    Aunque dices “no mucho”, aprende patrones básicos (por ejemplo, [A-Za-z] para letras, \d para dígitos).
//    Practica validar formatos comunes (emails, números de teléfono, etc.).
//    No te preocupes por patrones muy complejos si no es necesario.

//7. Consejos Generales para el Examen
//    Prioriza: Dedica más tiempo a “Uso de Librerías”, “Creación de Clases”, “Herencia” y “Estructuras de Datos”, ya que parecen ser los temas más relevantes para 1º DAM.
//    Práctica: Escribe código para cada punto, compilándolo y ejecutándolo para entender cómo funcionan.
//    Errores comunes:
//    Olvidar importar librerías.
//    No sobrescribir equals() y hashCode() correctamente.
//            Confundir == con equals().
//    No manejar bien las excepciones o entradas inválidas.
//    Recursos útiles:
//    Documentación oficial de Java (oracle.com/java).
//    Tutoriales en línea sobre Java (por ejemplo, en W3Schools o Baeldung).
//    Ejercicios prácticos en plataformas como Codeforces, LeetCode o HackerRank (aunque ajustados a tu nivel).
}
