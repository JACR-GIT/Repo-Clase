package com.ActividadesExtras;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PracticaExamen2 {
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

    //    Bloque de Ejercicios de Desafío
    //    Ejercicio 1: Análisis de Datos con Streams
    //    a) getDepartamentosConSalarioPromedioSuperiorA(List<Empleado> empleados, double umbralSalario)
    //    Tarea: Devuelve un List<String> con los nombres de los departamentos cuyo salario promedio sea superior al umbralSalario especificado. La lista de departamentos debe estar ordenada alfabéticamente.
    //    Desafío: Tendrás que agrupar, calcular un promedio para cada grupo, y luego filtrar los grupos basados en ese promedio calculado. Esto requiere una operación en dos fases.
    public static List<String> getDepartamentosConSalarioPromedioSuperiorA(List<Empleado> empleados, double umbralSalario) {
        // PASO 1: Agrupar por departamento y calcular el promedio de salario para cada uno.
        Map<String, Double> salariosPromedioPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.averagingDouble(Empleado::getSalario) // Este colector calcula el promedio
                ));

        // PASO 2 a 5: Filtrar el mapa resultante y extraer los nombres.
        return salariosPromedioPorDepto.entrySet().stream() // Creamos un stream de las entradas del mapa (k, v)
                .filter(entry -> entry.getValue() > umbralSalario) // Filtramos por el valor (salario promedio)
                .map(Map.Entry::getKey) // Nos quedamos solo con la clave (nombre del departamento)
                .sorted() // Ordenamos alfabéticamente
                .collect(Collectors.toList());
    }
    //    b) getTagsMasComunes(List<Producto> productos)
    //    Tarea: Devuelve un Map<String, Long> que contenga los 3 tags más frecuentes en toda la lista de productos y su frecuencia (cuántas veces aparecen). Si hay empates en la frecuencia,
    //    puedes devolver cualquiera de los tags empatados. El tag debe estar en minúsculas.
    //    Desafío: Necesitas aplanar todos los tags, contarlos, ordenar el resultado por frecuencia y quedarte solo con los 3 primeros.
    public static Map<String, Long> getTagsMasComunes(List<Producto> productos) {
        // PASO 1 y 2: Aplanar, agrupar y contar en un solo paso.
        Map<String, Long> conteoDeTags = productos.stream()
                .flatMap(producto -> producto.getTags().stream()) // Stream<List<String>> -> Stream<String>
                .map(String::toLowerCase) // Pasamos a minúsculas como pide el enunciado
                .collect(Collectors.groupingBy(
                        tag -> tag, // Agrupamos por el propio tag
                        Collectors.counting() // Contamos cuántas veces aparece cada uno
                ));

        // PASO 3 a 5: Ordenar, limitar y recolectar.
        return conteoDeTags.entrySet().stream() // Creamos un stream de las entradas del mapa de conteo
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Ordenamos por valor (conteo) descendente
                .limit(3) // Nos quedamos con los 3 primeros
                .collect(Collectors.toMap( // Volvemos a crear un mapa
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
    //    Ejercicio 2: Refactorización y Principios de Diseño
    //    a) crearReporteSalarialPorDepartamento(List<Empleado> empleados)
    //    Tarea: Devuelve un Map<String, String> donde la clave es el nombre del departamento y el valor es un String formateado que resume las estadísticas salariales de ese departamento.
    //    El formato del string debe ser: "Promedio: €XX,XXX.XX, Máximo: €XX,XXX.XX, Mínimo: €XX,XXX.XX". Los números deben estar formateados con dos decimales.
    //    Desafío: Este ejercicio pone a prueba tu habilidad para usar colectores que calculan varias estadísticas a la vez (Collectors.summarizingDouble) y luego transformar el resultado.
    public static Map<String, String> crearReporteSalarialPorDepartamento(List<Empleado> empleados) {
        // PASO 1: Agrupar y obtener el objeto de estadísticas.
        Map<String, DoubleSummaryStatistics> estadisticasPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summarizingDouble(Empleado::getSalario)
                ));

        // PASO 2: Transformar el mapa de estadísticas en un mapa de strings formateados.
        return estadisticasPorDepto.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // La clave sigue siendo la misma (el departamento)
                        entry -> { // El valor se calcula a partir del objeto de estadísticas
                            DoubleSummaryStatistics stats = entry.getValue();
                            return String.format(
                                    "Promedio: €%,.2f, Máximo: €%,.2f, Mínimo: €%,.2f",
                                    stats.getAverage(),
                                    stats.getMax(),
                                    stats.getMin()
                            );
                        }
                ));
    }
    //    Ejercicio 3: Expresiones Regulares y Lógica Compleja
    //    a) validarYExtraerToken(String header)
    //    Tarea: Implementa un método que valida un header de autorización y extrae un token. El formato del header debe ser Bearer [token].
    //    El token debe ser una cadena de 32 caracteres exactamente, compuesta únicamente por letras (mayúsculas o minúsculas) y números.
    //    El método debe devolver un Optional<String>. Si el header es válido en formato y contenido del token, devuelve un Optional con el token. Si no, devuelve un Optional.empty().
    //    Ejemplo válido: Para "Bearer a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6", devuelve Optional["a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6"].
    //    Ejemplos inválidos: "Token abc", "Bearer abc", "Bearer abc_123...".
    //    Desafío: La regex debe validar tanto la estructura "Bearer" como el contenido del token (longitud y caracteres permitidos) en una sola expresión.
    public static Optional<String> validarYExtraerToken(String header) {
        if (header == null) {
            return Optional.empty();
        }

        // PASO 1: La regex con el grupo de captura.
        String patron = "^Bearer ([a-zA-Z0-9]{32})$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(header);

        // PASO 3 y 4: Si coincide, extrae el grupo 1. Si no, el Optional estará vacío.
        if (matcher.matches()) {
            return Optional.of(matcher.group(1));
        } else {
            return Optional.empty();
        }
    }
    //    Ejercicio 4: Lógica de Negocio y Streams
    //    a) asignarBonificacionPorAntiguedadYSalario(List<Empleado> empleados, int anioActual)
    //    Tarea: Calcula un mapa de bonificaciones. Devuelve un Map<Empleado, Double> donde solo se incluyen los empleados que tienen derecho a una bonificación. Las reglas de bonificación son:
    //    Solo los empleados con más de 5 años de antigüedad (calculado respecto al anioActual) son elegibles.
    //    La bonificación base es del 5% del salario.
    //    Si además de tener más de 5 años de antigüedad, el empleado pertenece al departamento de "IT", su bonificación es del 7.5% del salario.
    //    Desafío: Combina múltiples filter (o una lógica de filtro compleja) y luego usa collect para crear un mapa donde el valor se calcula a partir del propio empleado.
    public static Map<Empleado, Double> asignarBonificacionPorAntiguedadYSalario(List<Empleado> empleados, int anioActual) {
        // PASO 1: Filtrar por la condición base (antigüedad).
        return empleados.stream()
                .filter(e -> (anioActual - e.getAnioContratacion()) > 5)
                // PASO 2: Coleccionar en un mapa con lógica condicional para el valor.
                .collect(Collectors.toMap(
                        empleado -> empleado, // La clave es el objeto Empleado
                        empleado -> { // El valor se calcula
                            if (empleado.getDepartamento().equals("IT")) {
                                return empleado.getSalario() * 0.075; // Bonificación del 7.5%
                            } else {
                                return empleado.getSalario() * 0.05;  // Bonificación del 5%
                            }
                        }
                ));
    }
    //    Ejercicio 5: Iteradores y Estado
    //    a) procesarLoteDeProductos(List<Producto> lote, Set<String> idsProcesados)
    //    Tarea: Simula el procesamiento de un lote de productos. Este método modifica la lista original lote y el conjunto idsProcesados. Debes usar un Iterator para recorrer el lote.
    //    Para cada producto en el lote, comprueba si su id ya existe en el Set<String> idsProcesados.
    //    Si el id ya existe (es un duplicado), elimina el producto del lote.
    //    Si el id no existe, añádelo al Set idsProcesados para marcarlo como procesado y déjalo en la lista.
    //    Desafío: Este ejercicio simula un escenario común donde necesitas recorrer una colección mientras interactúas y modificas otra, manteniendo un estado (idsProcesados).
    //    El uso de un Iterator es crucial para eliminar elementos de forma segura durante la iteración.
    // El método es void porque modifica las colecciones que le pasan.
    public static void procesarLoteDeProductos(List<Producto> lote, Set<String> idsProcesados) {
        Iterator<Producto> iterator = lote.iterator();
        while (iterator.hasNext()) {
            Producto productoActual = iterator.next();
            // El método .add() de un Set devuelve false si el elemento ya estaba presente.
            // Usamos esta propiedad para comprobar y añadir en un solo paso.
            if (!idsProcesados.add(productoActual.getId())) {
                // Si add() devuelve false, es un duplicado. Lo eliminamos.
                iterator.remove();
            }
        }
    }
}
