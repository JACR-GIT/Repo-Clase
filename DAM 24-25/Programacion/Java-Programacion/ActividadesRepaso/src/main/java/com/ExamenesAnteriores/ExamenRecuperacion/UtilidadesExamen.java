package com.ExamenesAnteriores.ExamenRecuperacion;

import com.ExamenesAnteriores.EV2_2.PerroDeJose;
import com.joey.utils.*;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UtilidadesExamen {

    // --- EJERCICIO 1 ---
    // EXPLICACIÓN:
    // 1. Usamos streams sobre la lista de razas obtenida de SoporteJoey.
    // 2. `collect` es el operador final para agrupar los resultados.
    // 3. `Collectors.groupingBy` es perfecto para crear un Map. La clave es el resultado de `RazaPerro::getTamanyoRaza`.
    // 4. El segundo argumento de `groupingBy` define cómo se coleccionan los valores para cada clave.
    //    - `Collectors.mapping` transforma cada elemento (RazaPerro) antes de añadirlo a la lista. Lo transformamos a su nombre (String).
    //    - `Collectors.toList()` recoge todos los nombres mapeados en una List<String>.
    // 5. El resultado es un Map<TamanyoRazaPerro, List<String>>. Finalmente, se ordena cada lista del mapa.
    public static Map<TamanyoRazaPerro, List<String>> clasificaPorTamanyo() {
        Map<TamanyoRazaPerro, List<String>> mapa = SoporteJoey.getInstance().getRazasPerros().stream()
                .collect(Collectors.groupingBy(
                        RazaPerro::getTamanyoRaza,
                        Collectors.mapping(r -> r.getNombreRaza().toString(), Collectors.toList())
                ));
        // Ordenamos alfabéticamente cada una de las listas dentro del mapa
        mapa.values().forEach(Collections::sort);
        return mapa;
    }

//    public static Map<TamanyoRazaPerro, List<String>> clasificarPorTamaño(){
//        List<RazaPerro> razasPerros = SoporteJoey.getInstance().getRazasPerros();
//        Map<TamanyoRazaPerro, List<String>> mapaPerros = new HashMap<>();
//        Set<TamanyoRazaPerro>  tamanyoRazasPerros = new HashSet<>();
//
//        for (RazaPerro razaPerro : razasPerros) {
//            tamanyoRazasPerros.add(razaPerro.getTamanyoRaza());
//        }
//
//        for (TamanyoRazaPerro t : tamanyoRazasPerros) {
//            for (RazaPerro razaPerro : razasPerros) {
//                razaPerro.getTamanyoRaza().equals()
//            }
//        }
//
//        return mapaPerros;
//    }

    // --- EJERCICIO 2 ---
    private static final List<Character> caracteresValidos =
            Arrays.asList('A', 'Z', 'F', 'Q', 'N', 'P', 'T', 'D', 'V', 'X', 'J', 'B');

    public static boolean validaCodigo(String codigo) {
        // EXPLICACIÓN:
        // El patrón usa [a-zA-Z] para ser más específico que \w.
        String patron = "([a-zA-Z]{3})-(\\d{3})([a-zA-Z]{3})";
        Matcher matcher = Pattern.compile(patron).matcher(codigo);

        if (!matcher.matches()) {
            return false; // Si el formato AAA-111AAA no coincide, es falso directamente.
        }

        // Recuperamos las partes de letras y las pasamos a mayúsculas para la validación.
        String parte1 = matcher.group(1).toUpperCase();
        String parte2 = matcher.group(3).toUpperCase();

        // EXPLICACIÓN Lógica de validación:
        // Iteramos por los caracteres de ambas partes y comprobamos si están en la lista `caracteresValidos`.
        for (char c : (parte1 + parte2).toCharArray()) {
            if (!caracteresValidos.contains(c)) {
                return false;
            }
        }

        // EXPLICACIÓN Lógica de vinculación:
        // Comparamos los caracteres según su posición en la lista `caracteresValidos`.
        // El índice del primer carácter de `parte1` debe ser igual al índice del último de `parte2` (contando desde el final).
        // indexOf(char1) == (tamañoLista - 1 - indexOf(char2))
        if (caracteresValidos.indexOf(parte1.charAt(0)) != caracteresValidos.size() - 1 - caracteresValidos.indexOf(parte2.charAt(2))) return false;
        if (caracteresValidos.indexOf(parte1.charAt(1)) != caracteresValidos.size() - 1 - caracteresValidos.indexOf(parte2.charAt(1))) return false;
        if (caracteresValidos.indexOf(parte1.charAt(2)) != caracteresValidos.size() - 1 - caracteresValidos.indexOf(parte2.charAt(0))) return false;

        // Si ha pasado todas las validaciones, es verdadero.
        return true;
    }

//    public static boolean validaCodigo(String codigo){
//        List<Character> caracteresValidos = Arrays.asList('A', 'Z', 'F', 'Q', 'N', 'P', 'T', 'D', 'V', 'X', 'J', 'B');
//        String patron = "(\\w{3})-\\d{3}(\\w{3})";
//        Pattern pattern = Pattern.compile(patron);
//        Matcher matcher = pattern.matcher(codigo);
//        boolean esValido = false;
//
//        if (matcher.matches()) {
//            String patron1 = matcher.group(1).toUpperCase();
//            String patron2 = matcher.group(2).toUpperCase();
//
//            if (!caracteresValidos.contains(patron1)) {
//                esValido = false;
//            }
//            if (!caracteresValidos.contains(patron2)) {
//                esValido = false;
//            }
//        }
//
//
//
//        return esValido;
//    }

    // --- EJERCICIO 3 ---
    // EXPLICACIÓN:
    // Se usan streams para encontrar las valoraciones requeridas de forma declarativa.
    // 1. `getOpciones()` nos da la lista de comentarios (pros y contras).
    // 2. Para cada clave (1, 2, -1, -2) hacemos una operación de stream.
    // 3. Filtramos: `filter(c -> c.length() % 2 != 0)` para impares y `% 2 == 0` para pares.
    // 4. Buscamos el mínimo/máximo: `min(Comparator.comparing(String::length))` busca el String con la longitud mínima.
    // 5. `orElse(null)`: `min` y `max` devuelven un `Optional`, ya que la lista filtrada podría estar vacía. `orElse` nos da el valor o un default.
    public static Map<Integer, String> ejercicioOpciones() {
        Map<Integer, String> resultado = new HashMap<>();
        List<Opcion> opciones = SoporteJoey.getInstance().getOpciones();

        // Clave 1: Pro, impar, mínimo
        String proMinImpar = opciones.stream().flatMap(o -> o.getPros().stream())
                .filter(c -> c.length() % 2 != 0)
                .min(Comparator.comparing(String::length))
                .orElse(null);

        // Clave 2: Pro, par, máximo
        String proMaxPar = opciones.stream().flatMap(o -> o.getPros().stream())
                .filter(c -> c.length() % 2 == 0)
                .max(Comparator.comparing(String::length))
                .orElse(null);

        // Clave -1: Contra, impar, mínimo
        String contraMinImpar = opciones.stream().flatMap(o -> o.getContras().stream())
                .filter(c -> c.length() % 2 != 0)
                .min(Comparator.comparing(String::length))
                .orElse(null);

        // Clave -2: Contra, par, máximo
        String contraMaxPar = opciones.stream().flatMap(o -> o.getContras().stream())
                .filter(c -> c.length() % 2 == 0)
                .max(Comparator.comparing(String::length))
                .orElse(null);

        resultado.put(1, proMinImpar);
        resultado.put(2, proMaxPar);
        resultado.put(-1, contraMinImpar);
        resultado.put(-2, contraMaxPar);

        return resultado;
    }

    //Actividad 3

//    public static Map<Integer, String> ejercicioOpciones() {
//        Map<Integer, String> mapaOpcionesFinal = new HashMap<>();
//        List<Opcion> listaOpciones = SoporteJoey.getInstance().getOpciones();
//
//        String opcionBuenaMenosCarateres = listaOpciones.stream().sorted(Collections.max());
//
//        return mapaOpcionesFinal;
//    }

    // --- EJERCICIO 4 ---
    public static List<PerroFamoso> creaPerros() {
        List<PerroFamoso> perros = new ArrayList<>();
        SoporteJoey soporte = SoporteJoey.getInstance();

        // EXPLICACIÓN:
        // Usamos `soporte.getRazaPerroByName(...)` como pide el enunciado, en lugar de `new RazaPerro(...)`.
        perros.add(new PerroFamoso("Hachiko", soporte.getRazaPerroByName(NombreRazaPerro.AKITA_INU), LocalDate.of(1923, 11, 10), "Tokio (Japón)", "Esperó a su dueño en la estación hasta su muerte"));
        perros.add(new PerroFamoso("Snoopy", soporte.getRazaPerroByName(NombreRazaPerro.BEAGLE), LocalDate.of(1950, 10, 2), "Santa Rosa (EE.UU.)", "Personaje del cómic 'Peanuts'"));
        perros.add(new PerroFamoso("Gordo", soporte.getRazaPerroByName(NombreRazaPerro.MASTIN), LocalDate.of(2008, 1, 1), "León (España)", "Perro rescatista de montaña"));
        perros.add(new PerroFamoso("Barry", soporte.getRazaPerroByName(NombreRazaPerro.MASTIN), LocalDate.of(1800, 1, 1), "Alpes suizos", "Salvó más de 40 vidas como perro de rescate"));
        perros.add(new PerroFamoso("Rex", soporte.getRazaPerroByName(NombreRazaPerro.PASTOR_ALEMAN), LocalDate.of(1994, 1, 1), "Viena (Austria)", "Protagonista de la serie 'Rex, un policía diferente'"));
        perros.add(new PerroFamoso("Chips", soporte.getRazaPerroByName(NombreRazaPerro.PASTOR_ALEMAN), LocalDate.of(1940, 1, 1), "Nueva York (EE.UU.)", "Héroe de guerra condecorado en la Segunda Guerra Mundial"));
        perros.add(new PerroFamoso("Stubby", soporte.getRazaPerroByName(NombreRazaPerro.BULLDOG), LocalDate.of(1916, 1, 1), "Connecticut (EE.UU.)", "Perro héroe en la Primera Guerra Mundial"));
        perros.add(new PerroFamoso("Bruiser", soporte.getRazaPerroByName(NombreRazaPerro.CHIHUHUA), LocalDate.of(2000, 1, 1), "EE.UU.", "Compañero de Elle en 'Una rubia muy legal'"));
        perros.add(new PerroFamoso("Smoky", soporte.getRazaPerroByName(NombreRazaPerro.YORKSHIRE_TERRIER), LocalDate.of(1943, 1, 1), "Papúa Nueva Guinea", "Perro mensajero en la Segunda Guerra Mundial"));

        // La clase PerroFamoso implementa Comparable, por lo que podemos usar Collections.sort() o stream().sorted()
        Collections.sort(perros);
        return perros;
    }

    // --- MÉTODOS CON STREAMS DEL EJERCICIO 4 ---

    // a)
    public static List<String> nombresDeRaza(List<PerroFamoso> listaPerros, String raza) {
        return listaPerros.stream()
                .filter(p -> p.getRaza().getNombreRaza().toString().equalsIgnoreCase(raza))
                .map(Perro::getNombre) // Equivalente a p -> p.getNombre()
                .collect(Collectors.toList());
    }

    // b)
    public static Map<String, Long> contarPorRaza(List<PerroFamoso> listaPerros) {
        return listaPerros.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getRaza().getNombreRaza().toString(), // Clave del mapa
                        Collectors.counting() // Valor del mapa (conteo de elementos por clave)
                ));
    }

    // c)
    public static List<PerroFamoso> nacidosAntesDe(List<PerroFamoso> listaPerros, int anyo) {
        return listaPerros.stream()
                .filter(p -> p.getFechaNacimiento().getYear() < anyo)
                .collect(Collectors.toList());
    }

    // d)
    public static long contarPosterioresA(List<PerroFamoso> listaPerros, int anyo) {
        return listaPerros.stream()
                .filter(p -> p.getFechaNacimiento().getYear() >= anyo)
                .count();
    }

    // e)
    public static List<PerroFamoso> ordenadosLimitados(List<PerroFamoso> listaPerros, String texto, int n) {
        return listaPerros.stream()
                .filter(p -> p.getMotivoFama().toLowerCase().contains(texto.toLowerCase()))
                .sorted(Comparator.comparing(p -> p.getRaza().getNombreRaza().toString()))
                .limit(n)
                .collect(Collectors.toList());
    }

//    public static List<String> nombresDeRaza(List<PerroFamoso> listaPerros, String raza){
//        List<String> nombresDeRaza = new ArrayList<>();
//
//        for (PerroFamoso perro : listaPerros) {
//            if (perro.getRaza().equals(raza)) {
//                nombresDeRaza.add(perro.getNombre());
//            }
//        }
//
//        nombresDeRaza.stream().sorted();
//
//        return nombresDeRaza;
//    }
//
//    public static Map<String, Long> contarPorRaza(List<PerroFamoso> listaPerros){
//        Map<String, Long> contarPorRaza = new HashMap<>();
//
//        long totalDePerros = listaPerros.stream().count();
//
//        return contarPorRaza;
//    }
//
//    public static List<PerroFamoso> nacidosAntesDe(List<PerroFamoso> listaPerros, int anyo){
//        List<PerroFamoso> perrosNacidosEn = new ArrayList<>();
//
//        listaPerros.stream().filter(perro -> {if (perro.getFechaNacimiento().getYear()<anyo){perrosNacidosEn.add(perro);};return true;});
//
//        return perrosNacidosEn;
//    }
//
//    public static long contarPosterioresA(List<PerroFamoso> listaPerros, int anyo){
//        long totalDePosterioresA = 0;
//
//        listaPerros.stream().filter()
//    }

}
