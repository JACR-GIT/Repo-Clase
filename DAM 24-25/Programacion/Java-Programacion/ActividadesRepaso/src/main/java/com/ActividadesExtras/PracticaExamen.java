package com.ActividadesExtras;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PracticaExamen {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Juan Pérez", "Ventas", 35000, 2018),
                new Empleado("Ana Gómez", "Ventas", 42000, 2016),
                new Empleado("Carlos Ruiz", "IT", 55000, 2020),
                new Empleado("Marta Sanz", "IT", 60000, 2015),
                new Empleado("Pedro Marín", "Recursos Humanos", 32000, 2021)
        );

        List<Producto> productos = new ArrayList<>(Arrays.asList( // Usamos ArrayList para poder modificarla
                new Producto("P001", "Laptop Pro", "Electrónica", Arrays.asList("oferta", "nuevo"), 10.00),
                new Producto("P002", "Teclado Mecánico", "Electrónica", Arrays.asList("gaming"), 20.00),
                new Producto("P003", "Silla de Oficina", "Mobiliario", Arrays.asList(), 9.00), // Sin tags
                new Producto("P004", "Ratón Inalámbrico", "Electrónica", Arrays.asList("ergonomico"), 20.00),
                new Producto("P005", "Mesa de Escritorio", "Mobiliario", Arrays.asList("madera", "oferta"), 50.00)
        ));
    }

//    Ejercicio 1: Filtrado y Transformación con Streams (Lambdas)
//    Implementa los siguientes métodos en tu clase PracticaExamen:
//    a) getNombresEmpleadosPorDepartamento(List<Empleado> empleados, String departamento)
//    Tarea: Devuelve una List<String> que contenga solo los nombres de los empleados que pertenecen al departamento especificado. La lista de nombres debe estar ordenada alfabéticamente.
//    Pistas: filter, map, sorted, collect.

    public static List<String> getNombresEmpleadosPorDepartamento(List<Empleado> empleados, String departamento) {
        // 1. Guardamos el resultado del stream en la variable que vamos a devolver.
        // 2. Usamos getters (getDepartamento(), getNombre()).
        // 3. Añadimos .sorted() para ordenar alfabéticamente.
        return empleados.stream()
                .filter(empleado -> empleado.getDepartamento().equalsIgnoreCase(departamento))
                .map(Empleado::getNombre) // Usando referencia a método, es más limpio
                .sorted()
                .collect(Collectors.toList());
    }

    //    b) getSalarioPromedioPorDepartamento(List<Empleado> empleados, String departamento)
//    Tarea: Devuelve un double con el salario promedio de todos los empleados del departamento especificado. Si no hay empleados en ese departamento, debe devolver 0.0.
//    Pistas: filter, mapToDouble, average, orElse.
    public static double getSalarioPromedioPorDepartamento(List<Empleado> empleados, String departamento) {
        return empleados.stream()
                .filter(empleado -> empleado.getDepartamento().equalsIgnoreCase(departamento))
                .mapToDouble(Empleado::getSalario) // Referencia a método
                .average()
                .orElse(0.0);
    }

    //    c) incrementarSalario(List<Empleado> empleados, String departamento, double incremento)
//    Tarea: Devuelve una nueva List<Empleado> con todos los empleados originales, pero aquellos que pertenecen al departamento especificado deben tener su salario incrementado por el incremento dado. (Ej: salario * (1 + incremento)). Los empleados de otros departamentos no se modifican.
//    Pistas: map (para transformar condicionalmente), collect.
    public static List<Empleado> incrementarSalario(List<Empleado> empleados, String departamento, double incremento) {
        return empleados.stream()
                .map(empleado -> {
                    // Si el empleado no es del departamento, lo devolvemos tal cual.
                    if (!empleado.getDepartamento().equalsIgnoreCase(departamento)) {
                        return empleado;
                    } else {
                        // Si es del departamento, CREAMOS UN NUEVO EMPLEADO con el salario actualizado.
                        return new Empleado(
                                empleado.getNombre(),
                                empleado.getDepartamento(),
                                empleado.getSalario() * (1 + incremento),
                                empleado.getAnioContratacion()
                        );
                    }
                })
                .collect(Collectors.toList());
    }

    //    Ejercicio 2: Agrupación y Recolección con Streams
//    Implementa los siguientes métodos:
//    a) agruparEmpleadosPorDepartamento(List<Empleado> empleados)
//    Tarea: Devuelve un Map<String, List<Empleado>> donde las claves son los nombres de los departamentos y los valores son las listas de empleados que pertenecen a cada departamento.
//    Pistas: collect, Collectors.groupingBy.
    public static Map<String, List<Empleado>> agruparEmpleadosPorDepartamento(List<Empleado> empleados) {
        // Cuando solo quieres agrupar los objetos completos, no necesitas un segundo colector.
        return empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));
    }

    //    b) contarProductosPorCategoria(List<Producto> productos)
//    Tarea: Devuelve un Map<String, Long> donde las claves son las categorías de los productos y los valores son la cantidad de productos en cada categoría.
//    Pistas: collect, Collectors.groupingBy, Collectors.counting.
    public static Map<String, Long> contarProductosPorCategoria(List<Producto> productos) {
        Map<String, Long> productosPorCategoria = productos.stream().collect(Collectors.groupingBy(producto -> producto.categoria, Collectors.counting()));
        return productosPorCategoria;
    }

    //    Ejercicio 3: Expresiones Regulares y Validación
//    Implementa el siguiente método:
//    a) validarFormatoMatricula(String matricula)
//    Tarea: Devuelve true si la matrícula cumple el formato español moderno: cuatro dígitos seguidos de tres letras consonantes (no se permiten vocales, ni la Ñ, ni la Q). La validación no debe distinguir entre mayúsculas y minúsculas en las letras.
//    Ejemplos válidos: "1234BCF", "9876zxt", "0001GHL".
//    Ejemplos inválidos: "1234AEI", "123A BCF", "12345BCF", "1234BC".
//    Pistas: Pattern, Matcher. El regex es la parte clave. Una clase de caracteres para consonantes podría ser [BCDFGHJKLMNPRSTVWXYZ].
    public static boolean validarFormatoMatricula(String matricula) {
        // El patrón define exactamente lo que buscamos:
        // \\d{4} -> cuatro dígitos.
        // [BCDFGHJKLMNPRSTVWXYZ]{3} -> tres caracteres del conjunto de consonantes.
        // (?i) al principio hace que el resto del patrón sea case-insensitive.
        String patron = "(?i)^\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$";

        // El método matches() de String es un atajo para Pattern y Matcher.
        // Devuelve true si TODA la cadena coincide con el patrón.
        return matricula.matches(patron);
    }

    //    Ejercicio 4: Comparación de Objetos (Comparable/Comparator)
//    a) getEmpleadoMejorPagado(List<Empleado> empleados)
//    Tarea: Devuelve el objeto Empleado con el salario más alto de toda la lista. Si la lista está vacía, devuelve null.
//    Pistas: stream, max, Comparator.comparing, Optional.
    public static Empleado getEmpleadoMejorPagado(List<Empleado> empleados) {
        Empleado empleadoMejorPagado = empleados.stream().max(Comparator.comparing(Empleado::getSalario)).orElse(null);
        return empleadoMejorPagado;
    }

    //    b) ordenarProductos(List<Producto> productos)
//    Tarea: Devuelve una nueva lista de Producto ordenada por los siguientes criterios, en este orden de prioridad:
//    Primero por categoría, en orden alfabético.
//    Si la categoría es la misma, entonces por nombre, en orden alfabético.
//    Pistas: sorted, Comparator.comparing(...).thenComparing(...).
    public static List<Producto> ordenarProductos(List<Producto> productos) {
        return productos.stream()
                .sorted(Comparator
                        .comparing(Producto::getCategoria) // Primer criterio
                        .thenComparing(Producto::getNombre)   // Segundo criterio
                )
                .collect(Collectors.toList());
    }

    //    Ejercicio 5: Iteradores y Estructuras de Datos
//    a) eliminarProductosSinTags(List<Producto> productos)
//    Tarea: Modifica la lista de productos original eliminando todos aquellos productos cuya lista de tags esté vacía. Debes usar un Iterator para hacer esto de forma segura. No uses removeIf de la colección ni streams para este ejercicio, el objetivo es practicar el uso explícito de Iterator.
//            Pistas: list.iterator(), while(iterator.hasNext()), iterator.next(), iterator.remove().
    public static void eliminarProductosSinTags(List<Producto> productos) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            // 1. Obtenemos el siguiente producto
            Producto productoActual = iterator.next();

            // 2. Comprobamos la condición
            if (productoActual.getTags().isEmpty()) {
                // 3. Si se cumple, lo eliminamos de forma segura usando el iterador
                iterator.remove();
            }
        }
    }


    //Ejercicio 1: Manipulación Avanzada de Streams
    //a) getEmpleadosContratadosDespuesDe(List<Empleado> empleados, int anio)
    //Tarea: Devuelve una List<Empleado> que contenga únicamente a los empleados contratados a partir del año especificado (inclusive). La lista debe estar ordenada de los más recientes a los más antiguos (por año de contratación).
    public static List<Empleado> getEmpleadosContratadosDespuesDe(List<Empleado> empleados, int anio) {
        return empleados.stream()
                .filter(empleado -> empleado.getAnioContratacion() >= anio) // Corregido a >=
                .sorted(Comparator.comparing(Empleado::getAnioContratacion).reversed()) // .reversed() para orden descendente
                .collect(Collectors.toList());
    }
    //b) getTodosLosTagsUnicos(List<Producto> productos)
    //Tarea: Devuelve un Set<String> con todas las etiquetas (tags) únicas de todos los productos. El Set resultante no debe contener duplicados y las etiquetas deben estar en mayúsculas.
    //Ejemplo: Si un producto tiene ["oferta", "nuevo"] y otro tiene ["nuevo", "gaming"], el resultado debería ser {"OFERTA", "NUEVO", "GAMING"}.
    public static Set<String> getTodosLosTagsUnicos(List<Producto> productos) {
        return productos.stream()
                .flatMap(producto -> producto.getTags().stream()) // APLANA el Stream<List<String>> a Stream<String>
                .map(String::toUpperCase) // Convierte cada tag a mayúsculas
                .collect(Collectors.toSet()); // Recolecta en un Set, que elimina duplicados automáticamente
    }
    //c) getNombresDeProductosEnOferta(List<Producto> productos)
    //Tarea: Devuelve una List<String> con los nombres de todos los productos que tengan la etiqueta "oferta" (sin importar mayúsculas/minúsculas). La lista final debe estar ordenada alfabéticamente.
    public static List<String> getNombresDeProductosEnOferta(List<Producto> productos) {
        return productos.stream()
                // El filtro debe buscar de forma case-insensitive
                .filter(producto -> producto.getTags().stream().anyMatch(tag -> tag.equalsIgnoreCase("oferta")))
                .map(Producto::getNombre)
                .sorted() // Añadimos la ordenación alfabética
                .collect(Collectors.toList());
    }
    //Ejercicio 2: Estructuras de Datos Complejas con Streams
    //a) getSalarioTotalPorDepartamento(List<Empleado> empleados)
    //Tarea: Devuelve un Map<String, Double> donde las claves son los departamentos y los valores son la suma total de los salarios de todos los empleados de ese departamento.
    public static Map<String, Double> getSalarioTotalPorDepartamento(List<Empleado> empleados){
        return empleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.summingDouble(Empleado::getSalario)));
    }
    //b) getProductoMasCaroPorCategoria(List<Producto> productos)
    //Nota: La clase Producto no tiene precio. Añádele un atributo double precio y modifica el constructor y los getters para poder resolver este ejercicio.
    //Tarea: Devuelve un Map<String, Producto> donde las claves son las categorías y los valores son el Producto más caro dentro de esa categoría. Si hay dos productos con el mismo precio máximo, puedes devolver cualquiera de los dos.
    public static Map<String, Producto> getProductoMasCaroPorCategoria(List<Producto> productos) {
        return productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        // collectingAndThen permite aplicar una transformación final al resultado de un colector
                        Collectors.collectingAndThen(
                                // 1. Primero, encontramos el máximo (que devuelve un Optional)
                                Collectors.maxBy(Comparator.comparing(Producto::getPrecio)),
                                // 2. Luego, desempaquetamos el Optional (o devolvemos null si está vacío)
                                optionalProducto -> optionalProducto.orElse(null)
                        )
                ));
    }
    //Ejercicio 3: Expresiones Regulares y Manipulación de Strings
    //a) validarFormatoCorreoEmpresa(String correo)
    //Tarea: Devuelve true si el String correo sigue el formato de un correo electrónico corporativo específico: nombre.apellido@miempresa.com.
    //El nombre y el apellido solo pueden contener letras (sin acentos, sin ñ).
    //La validación debe ser insensible a mayúsculas/minúsculas en el dominio (@miempresa.com o @MiEmpresa.COM son válidos).
    //Ejemplos válidos: "juan.perez@miempresa.com", "ana.gomez@MIEMPRESA.COM".
    //Ejemplos inválidos: "juan_perez@miempresa.com", "juanperez@miempresa.com", "juan.perez@gmail.com", "juan.perez2@miempresa.com".
    public static boolean validarFormatoCorreoEmpresa(String correo) {
        // (?i) al principio del grupo del dominio lo hace case-insensitive
        // ^ y $ aseguran que toda la cadena coincide, no solo una parte.
        String patron = "^[a-zA-Z]+\\.[a-zA-Z]+@(?i)miempresa\\.com$";
        return correo.matches(patron);
    }
    //b) extraerPartesDeFactura(String codigoFactura)
    //Tarea: Dada una cadena de factura con el formato "FACT-YYYY-NNNNN" (donde YYYY es el año y NNNNN es un número de 5 dígitos), devuelve un Map<String, Integer>
    // con dos entradas: una clave "anio" con el valor del año, y una clave "numero" con el valor del número de factura. Si el formato no es válido, devuelve un mapa vacío.
    //        Ejemplo: Para "FACT-2023-00123", debe devolver {anio=2023, numero=123}.
    public static Map<String, Integer> extraerPartesDeFactura(String codigoFactura) {
        Map<String, Integer> partes = new HashMap<>();
        // Creamos grupos de captura con paréntesis para el año y el número.
        String patron = "^FACT-(\\d{4})-(\\d{5})$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(codigoFactura);

        // Si el formato coincide...
        if (matcher.matches()) {
            // ...extraemos los grupos capturados y los convertimos a Integer.
            int anio = Integer.parseInt(matcher.group(1));
            int numero = Integer.parseInt(matcher.group(2));
            partes.put("anio", anio);
            partes.put("numero", numero);
        }

        return partes; // Devuelve el mapa (lleno o vacío)
    }
    //Ejercicio 4: Comparadores y Ordenación Múltiple
    //a) ordenarEmpleadosMultiCriterio(List<Empleado> empleados)
    //Tarea: Devuelve una nueva lista de Empleado ordenada según los siguientes criterios:
    //Primero por departamento, en orden alfabético.
    //Dentro del mismo departamento, por salario, de mayor a menor.
    //Si el salario es el mismo, por nombre, en orden alfabético.
    public static List<Empleado> ordenarEmpleadosMultiCriterio(List<Empleado> empleados) {
        return empleados.stream()
                .sorted(Comparator
                        .comparing(Empleado::getDepartamento) // 1. Dpto (ascendente por defecto)
                        .thenComparing(Empleado::getSalario, Comparator.reverseOrder()) // 2. Salario (descendente)
                        .thenComparing(Empleado::getNombre)      // 3. Nombre (ascendente por defecto)
                )
                .collect(Collectors.toList());
    }
    //Ejercicio 5: Iteradores y Modificación Segura
    //a) aumentarSalarioAntiguos(List<Empleado> empleados, int anioLimite, double porcentajeAumento)
    //Tarea: Modifica la lista de empleados original. Para cada empleado contratado antes del anioLimite (no inclusive),
    // incrementa su salario en el porcentaje dado. Debes usar un Iterator para recorrer la lista y un ListIterator para poder modificarla.
    //Nota: Iterator no permite modificar, pero ListIterator sí. Investiga cómo usar listIterator.set(nuevoObjeto).
    public static void aumentarSalarioAntiguos(List<Empleado> empleados, int anioLimite, double porcentajeAumento) {
        // Obtenemos un ListIterator, que permite modificar.
        ListIterator<Empleado> iterator = empleados.listIterator();

        while (iterator.hasNext()) {
            Empleado actual = iterator.next();
            if (actual.getAnioContratacion() < anioLimite) {
                // Creamos una NUEVA instancia del empleado con el salario actualizado.
                Empleado modificado = new Empleado(
                        actual.getNombre(),
                        actual.getDepartamento(),
                        actual.getSalario() * (1 + porcentajeAumento),
                        actual.getAnioContratacion()
                );
                // Usamos set() para reemplazar el objeto que acabamos de leer con el nuevo.
                iterator.set(modificado);
            }
        }
    }
}