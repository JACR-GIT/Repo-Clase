import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActividadesExamen {

    // Clase principal que contiene todo
    public class ExamenDAM {
        // Clase Persona para ejercicios de comparación
        static class Persona implements Comparable<Persona> {
            private String nombre;
            private int edad;

            public Persona(String nombre, int edad) {
                this.nombre = nombre;
                this.edad = edad;
            }

            public String getNombre() { return nombre; }
            public int getEdad() { return edad; }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Persona p = (Persona) obj;
                return edad == p.edad && nombre.equals(p.nombre);
            }

            @Override
            public int hashCode() {
                int result = nombre.hashCode();
                result = 31 * result + edad;
                return result;
            }

            @Override
            public int compareTo(Persona o) {
                return Integer.compare(this.edad, o.edad);
            }

            @Override
            public String toString() {
                return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
            }
        }

        // Clase Empleado para herencia
        static class Empleado extends Persona {
            private double salario;

            public Empleado(String nombre, int edad, double salario) {
                super(nombre, edad);
                this.salario = salario;
            }

            public double getSalario() { return salario; }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                if (!super.equals(obj)) return false;
                Empleado e = (Empleado) obj;
                return Double.compare(salario, e.salario) == 0;
            }

            @Override
            public int hashCode() {
                int result = super.hashCode();
                long temp = Double.doubleToLongBits(salario);
                return 31 * result + (int) (temp ^ (temp >>> 32));
            }

            @Override
            public String toString() {
                return "Empleado{nombre='" + getNombre() + "', edad=" + getEdad() + ", salario=" + salario + "}";
            }
        }

        // Comparator por nombre
        static class ComparadorPorNombre implements Comparator<Persona> {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        }

        // Comparator por edad y nombre
        static class ComparadorEdadNombre implements Comparator<Persona> {
            @Override
            public int compare(Persona p1, Persona p2) {
                int edadComp = Integer.compare(p1.getEdad(), p2.getEdad());
                return edadComp != 0 ? edadComp : p1.getNombre().compareTo(p2.getNombre());
            }
        }

        // Clase Usuario para validación y ordenación
        static class Usuario implements Comparable<Usuario> {
            private String nombre, email;
            private int edad;

            public Usuario(String nombre, String email, int edad) {
                this.nombre = nombre;
                this.email = email;
                this.edad = edad;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                return email.equals(((Usuario) obj).email);
            }

            @Override
            public int hashCode() {
                return email.hashCode();
            }

            @Override
            public int compareTo(Usuario o) {
                return Integer.compare(edad, o.edad);
            }

            @Override
            public String toString() {
                return "Usuario{nombre='" + nombre + "', email='" + email + "', edad=" + edad + "}";
            }

            public String getEmail() { return email; }
        }

        // Clases para herencia y polimorfismo (Empleados)
        static class EmpleadoBase {
            public void trabajar() { System.out.println("Trabajando"); }
        }

        static class Gerente extends EmpleadoBase {
            @Override
            public void trabajar() { System.out.println("Gestionando equipo"); }
        }

        static class Desarrollador extends EmpleadoBase {
            @Override
            public void trabajar() { System.out.println("Escribiendo código"); }
        }

        static class Vendedor extends EmpleadoBase {
            @Override
            public void trabajar() { System.out.println("Vendiendo productos"); }
        }

        // Clases para polimorfismo (Figuras Geométricas)
        static abstract class FiguraGeometrica {
            public abstract double calcularArea();
        }

        static class Circulo extends FiguraGeometrica {
            private double radio;

            public Circulo(double radio) { this.radio = radio; }

            @Override
            public double calcularArea() { return Math.PI * radio * radio; }
        }

        static class Rectangulo extends FiguraGeometrica {
            private double ancho, alto;

            public Rectangulo(double ancho, double alto) {
                this.ancho = ancho;
                this.alto = alto;
            }

            @Override
            public double calcularArea() { return ancho * alto; }
        }

        // Clases para herencia (Vehículos)
        static class Vehiculo {
            public void mover() { System.out.println("Moviendo"); }
        }

        static class Coche extends Vehiculo {
            @Override
            public void mover() { System.out.println("El coche acelera"); }
        }

        static class Bicicleta extends Vehiculo {
            @Override
            public void mover() { System.out.println("La bicicleta pedalea"); }
        }

        // Clases para polimorfismo (Dispositivos)
        static class Dispositivo {
            public void encender() { System.out.println("Encendiendo dispositivo"); }
        }

        static class Telefono extends Dispositivo {
            @Override
            public void encender() { System.out.println("Encendiendo el teléfono"); }
        }

        static class Ordenador extends Dispositivo {
            @Override
            public void encender() { System.out.println("Encendiendo el ordenador"); }
        }

        static class Television extends Dispositivo {
            @Override
            public void encender() { System.out.println("Encendiendo la televisión"); }
        }

        // Método main con todas las actividades
        public static void main(String[] args) {
            System.out.println("=== UT6: Ejercicios de comparación y expresiones regulares ===");

            // 1. Implementación de equals y hashCode
            System.out.println("\nEjercicio 1:");
            Persona p1 = new Persona("Ana", 20);
            Persona p2 = new Persona("Ana", 20);
            Persona p3 = new Persona("Luis", 25);
            System.out.println("p1 equals p2: " + p1.equals(p2));
            System.out.println("p1 equals p3: " + p1.equals(p3));

            // 2. Uso de HashSet
            System.out.println("\nEjercicio 2:");
            HashSet<Persona> personas = new HashSet<>();
            personas.add(p1);
            personas.add(p2); // No se añade (duplicado)
            personas.add(p3);
            System.out.println("Tamaño del HashSet: " + personas.size());

            // 3. Sobrescritura de equals y hashCode en jerarquía
            System.out.println("\nEjercicio 3:");
            Empleado e1 = new Empleado("Ana", 20, 2000);
            Empleado e2 = new Empleado("Ana", 20, 2000);
            Empleado e3 = new Empleado("Luis", 25, 2500);
            System.out.println("e1 equals e2: " + e1.equals(e2));
            System.out.println("e1 equals e3: " + e1.equals(e3));

            // 4. Implementación de Comparable
            System.out.println("\nEjercicio 4:");
            List<Persona> listaPersonas = new ArrayList<>(Arrays.asList(
                    new Persona("Ana", 20), new Persona("Luis", 25), new Persona("Marta", 18)));
            Collections.sort(listaPersonas);
            System.out.println(listaPersonas);

            // 5. Uso de Comparator
            System.out.println("\nEjercicio 5:");
            List<Persona> listaPorNombre = new ArrayList<>(listaPersonas);
            listaPorNombre.sort(new ComparadorPorNombre());
            System.out.println(listaPorNombre);

            // 6. Comparator con múltiples criterios
            System.out.println("\nEjercicio 6:");
            List<Persona> listaEdadNombre = new ArrayList<>(Arrays.asList(
                    new Persona("Luis", 20), new Persona("Ana", 20), new Persona("Marta", 18)));
            listaEdadNombre.sort(new ComparadorEdadNombre());
            System.out.println(listaEdadNombre);

            // 7. Ordenación de lista de Empleados
            System.out.println("\nEjercicio 7:");
            List<Empleado> empleados = new ArrayList<>(Arrays.asList(
                    new Empleado("Luis", 25, 2000), new Empleado("Ana", 25, 2200), new Empleado("Marta", 20, 1800)));
            empleados.sort(Comparator.comparing(Empleado::getEdad).thenComparing(Empleado::getNombre, Comparator.reverseOrder()));
            System.out.println(empleados);

            // 8. Validación de correo electrónico
            System.out.println("\nEjercicio 8:");
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            System.out.println(Pattern.matches(emailRegex, "ana@ejemplo.com"));
            System.out.println(Pattern.matches(emailRegex, "ana@ejemplo"));

            // 9. Extracción de números de teléfono
            System.out.println("\nEjercicio 9:");
            String textoTelefono = "Llama al 123-456-789 o al 987-654-321";
            Pattern telefonoPattern = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");
            Matcher telefonoMatcher = telefonoPattern.matcher(textoTelefono);
            while (telefonoMatcher.find()) System.out.println(telefonoMatcher.group());

            // 10. Validación de contraseñas
            System.out.println("\nEjercicio 10:");
            String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
            System.out.println(Pattern.matches(passRegex, "Pass1234"));
            System.out.println(Pattern.matches(passRegex, "pass123"));

            // 11. Validación y Ordenación (Usuario)
            System.out.println("\nEjercicio 11:");
            List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
                    new Usuario("Ana", "ana@ejemplo.com", 20), new Usuario("Luis", "luis@ejemplo.com", 25)));
            usuarios.forEach(u -> System.out.println("Email válido: " + Pattern.matches(emailRegex, u.getEmail())));
            Collections.sort(usuarios);
            System.out.println(usuarios);

            // 12. Validación de nombres
            System.out.println("\nEjercicio 12:");
            String nombreRegex = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
            System.out.println(Pattern.matches(nombreRegex, "Juan Pérez"));
            System.out.println(Pattern.matches(nombreRegex, "juan pérez"));

            // 13. Validación de fechas
            System.out.println("\nEjercicio 13:");
            String fechaRegex = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
            System.out.println(Pattern.matches(fechaRegex, "31/12/2020"));
            System.out.println(Pattern.matches(fechaRegex, "32/13/2020"));

            // 14. Validación de códigos postales
            System.out.println("\nEjercicio 14:");
            String cpRegex = "^\\d{5}$";
            System.out.println(Pattern.matches(cpRegex, "28001"));
            System.out.println(Pattern.matches(cpRegex, "2800"));

            // 15. Extracción de palabras clave
            System.out.println("\nEjercicio 15:");
            String textoPalabras = "Ana y Alberto fueron al parque.";
            Pattern palabraPattern = Pattern.compile("\\b[Aa]\\w+");
            Matcher palabraMatcher = palabraPattern.matcher(textoPalabras);
            while (palabraMatcher.find()) System.out.println(palabraMatcher.group());

            // 16. Validación de URLs
            System.out.println("\nEjercicio 16:");
            String urlRegex = "^https?://[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            System.out.println(Pattern.matches(urlRegex, "https://www.ejemplo.com"));
            System.out.println(Pattern.matches(urlRegex, "www.ejemplo.com"));

            // 17. Validación de números de teléfono internacionales
            System.out.println("\nEjercicio 17:");
            String telRegex = "^\\+\\d{2} \\d{9}$";
            System.out.println(Pattern.matches(telRegex, "+34 912345678"));
            System.out.println(Pattern.matches(telRegex, "912345678"));

            // 18. Extracción de hashtags
            System.out.println("\nEjercicio 18:");
            String textoHashtags = "Hoy es un gran día #feliz #java";
            Pattern hashtagPattern = Pattern.compile("#\\w+");
            Matcher hashtagMatcher = hashtagPattern.matcher(textoHashtags);
            while (hashtagMatcher.find()) System.out.println(hashtagMatcher.group());

            System.out.println("\n=== UT5: Ejercicios Extra de POO ===");

            // 1. Subcadena
            System.out.println("\nEjercicio 1:");
            String texto = "La lluvia en Sevilla es una maravilla";
            System.out.println(texto.substring(5, 11));

            // 2. Carácter en posición
            System.out.println("\nEjercicio 2:");
            System.out.println(texto.charAt(7));

            // 3. Buscar palabra
            System.out.println("\nEjercicio 3:");
            System.out.println(texto.indexOf("Sevilla"));

            // 4. Convertir a mayúsculas
            System.out.println("\nEjercicio 4:");
            System.out.println(texto.toUpperCase());

            // 5. Comparar cadenas
            System.out.println("\nEjercicio 5:");
            String cadena1 = "Hola";
            String cadena2 = "hola";
            System.out.println(cadena1.equalsIgnoreCase(cadena2));

            // 6. Reemplazar texto
            System.out.println("\nEjercicio 6:");
            System.out.println(texto.replace("lluvia", "sol"));

            // 7. Dividir cadena
            System.out.println("\nEjercicio 7:");
            String[] palabras = texto.split(" ");
            for (String palabra : palabras) System.out.println(palabra);

            // 8. Verificar inicio y fin
            System.out.println("\nEjercicio 8:");
            System.out.println(texto.startsWith("La"));
            System.out.println(texto.endsWith("maravilla"));

            // 9. Eliminar espacios
            System.out.println("\nEjercicio 9:");
            String cadenaEspacios = " Hola Mundo ";
            System.out.println(cadenaEspacios.trim());

            // 10. Concatenar cadenas
            System.out.println("\nEjercicio 10:");
            System.out.println(cadena1 + " " + cadena2);

            // 11. Convertir String a int
            System.out.println("\nEjercicio 11:");
            String numeroStr = "123";
            int num = Integer.parseInt(numeroStr);
            System.out.println(num);

            // 12. Convertir int a String
            System.out.println("\nEjercicio 12:");
            int numeroInt = 456;
            String numStr = Integer.toString(numeroInt);
            System.out.println(numStr);

            // 13. Máximo y mínimo
            System.out.println("\nEjercicio 13:");
            System.out.println(Integer.max(5, 10));
            System.out.println(Integer.min(5, 10));

            // 14. Comparar enteros
            System.out.println("\nEjercicio 14:");
            int comp = Integer.compare(5, 10);
            System.out.println(comp < 0 ? "5 < 10" : comp > 0 ? "5 > 10" : "5 = 10");

            // 15. Sumar enteros
            System.out.println("\nEjercicio 15:");
            System.out.println(Calculadora.sumar(3, 4));

            // 16. Valor absoluto
            System.out.println("\nEjercicio 16:");
            System.out.println(Math.abs(-10));

            // 17. Potencia
            System.out.println("\nEjercicio 17:");
            System.out.println(Math.pow(2, 5));

            // 18. Raíz cuadrada
            System.out.println("\nEjercicio 18:");
            System.out.println(Math.sqrt(25));

            // 19. Redondeo
            System.out.println("\nEjercicio 19:");
            System.out.println(Math.round(4.7));

            // 20. Número aleatorio
            System.out.println("\nEjercicio 20:");
            int random = (int) (Math.random() * 100) + 1;
            System.out.println(random);

            // 21. Fecha actual
            System.out.println("\nEjercicio 21:");
            System.out.println(LocalDate.now());

            // 22. Crear fecha
            System.out.println("\nEjercicio 22:");
            LocalDate fecha = LocalDate.of(2000, 2, 15);
            System.out.println(fecha);

            // 23. Sumar días
            System.out.println("\nEjercicio 23:");
            System.out.println(LocalDate.now().plusDays(10));

            // 24. Diferencia de días
            System.out.println("\nEjercicio 24:");
            LocalDate fecha1 = LocalDate.of(2023, 1, 1);
            LocalDate fecha2 = LocalDate.of(2023, 12, 31);
            System.out.println(ChronoUnit.DAYS.between(fecha1, fecha2));

            // 25. Formatear fecha
            System.out.println("\nEjercicio 25:");
            DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println(LocalDate.now().format(fechaFormatter));

            // 26. Hora actual
            System.out.println("\nEjercicio 26:");
            System.out.println(LocalTime.now());

            // 27. Crear hora
            System.out.println("\nEjercicio 27:");
            LocalTime hora = LocalTime.of(14, 30);
            System.out.println(hora);

            // 28. Sumar horas
            System.out.println("\nEjercicio 28:");
            System.out.println(LocalTime.now().plusHours(2));

            // 29. Formatear hora
            System.out.println("\nEjercicio 29:");
            DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println(LocalTime.now().format(horaFormatter));

            // 30. Tiempo de ejecución
            System.out.println("\nEjercicio 30:");
            long inicio = System.currentTimeMillis();
            for (int i = 1; i <= 1000; i++) System.out.print("");
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo: " + (fin - inicio) + " ms");

            // 31. Comparar objetos
            System.out.println("\nEjercicio 31:");
            Persona p4 = new Persona("Ana", 20);
            Persona p5 = new Persona("Ana", 25);
            System.out.println(p4.equals(p5)); // Compara solo por nombre

            // 32. Ordenar lista
            System.out.println("\nEjercicio 32:");
            List<Persona> listaOrdenada = new ArrayList<>(Arrays.asList(p1, p3));
            listaOrdenada.sort(Comparator.comparing(Persona::getEdad));
            System.out.println(listaOrdenada);

            // 33. Uso de System.getProperty
            System.out.println("\nEjercicio 33:");
            System.out.println("SO: " + System.getProperty("os.name"));
            System.out.println("Java: " + System.getProperty("java.version"));

            // 34. Uso de System.getenv
            System.out.println("\nEjercicio 34:");
            System.out.println("PATH: " + System.getenv("PATH"));

            // 35. Uso de System.gc
            System.out.println("\nEjercicio 35:");
            System.gc();
            System.out.println("Recolector de basura llamado.");

            System.out.println("\n=== Ejercicios de iteradores, herencia y polimorfismo ===");

            // 1. Iterador para recorrer una lista
            System.out.println("\nEjercicio 1:");
            List<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            Iterator<Integer> it = lista.iterator();
            while (it.hasNext()) System.out.println(it.next());

            // 2. Herencia con empleados y su rol
            System.out.println("\nEjercicio 2:");
            EmpleadoBase eBase1 = new Gerente();
            EmpleadoBase eBase2 = new Desarrollador();
            EmpleadoBase eBase3 = new Vendedor();
            eBase1.trabajar();
            eBase2.trabajar();
            eBase3.trabajar();

            // 3. Polimorfismo con formas geométricas
            System.out.println("\nEjercicio 3:");
            FiguraGeometrica[] figuras = {new Circulo(5), new Rectangulo(4, 6)};
            for (FiguraGeometrica f : figuras) System.out.println(f.calcularArea());

            // 4. Iteradores en conjunto (Set)
            System.out.println("\nEjercicio 4:");
            Set<String> conjunto = new HashSet<>(Arrays.asList("Ana", "Luis"));
            Iterator<String> itSet = conjunto.iterator();
            while (itSet.hasNext()) System.out.println(itSet.next());
            conjunto.add("Marta");
            itSet = conjunto.iterator();
            while (itSet.hasNext()) System.out.println(itSet.next());

            // 5. Herencia con vehículos
            System.out.println("\nEjercicio 5:");
            Vehiculo v1 = new Coche();
            Vehiculo v2 = new Bicicleta();
            v1.mover();
            v2.mover();

            // 6. Iteradores y modificación de listas
            System.out.println("\nEjercicio 6:");
            List<Integer> listaMod = new ArrayList<>(Arrays.asList(1, 2, 3));
            ListIterator<Integer> listIt = listaMod.listIterator();
            while (listIt.hasNext()) listIt.set(listIt.next() * 2);
            System.out.println(listaMod);

            // 7. Polimorfismo con dispositivos electrónicos
            System.out.println("\nEjercicio 7:");
            Dispositivo[] dispositivos = {new Telefono(), new Ordenador(), new Television()};
            for (Dispositivo d : dispositivos) d.encender();
        }

        // Clase Calculadora para ejercicio 15 de UT5
        static class Calculadora {
            public static int sumar(int a, int b) {
                return a + b;
            }
        }
    }
}
