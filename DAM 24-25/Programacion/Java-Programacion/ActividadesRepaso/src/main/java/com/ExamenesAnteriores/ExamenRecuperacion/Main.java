package com.ExamenesAnteriores.ExamenRecuperacion;

import com.joey.utils.Opcion;
import com.joey.utils.SoporteJoey;

import java.time.LocalDate;
import java.util.*;

import static com.ExamenesAnteriores.ExamenRecuperacion.UtilidadesExamen.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- EJERCICIO 1: Clasificación por Tamaño ---");
        UtilidadesExamen.clasificaPorTamanyo().forEach((tamanyo, nombres) -> {
            System.out.println("Tamaño: " + tamanyo);
            System.out.println("  Razas: " + nombres);
        });

        System.out.println("\n--- EJERCICIO 2: Validación de Código ---");
        System.out.println("ABc-123Vxs -> " + UtilidadesExamen.validaCodigo("ABc-123Vxs")); // false (no existe s)
        System.out.println("AfQ-123vXB -> " + UtilidadesExamen.validaCodigo("AfQ-123vXB")); // true
        System.out.println("aBCF-123VxS -> " + UtilidadesExamen.validaCodigo("aBCF-123VxS")); // false (formato)
        System.out.println("ABC-1-VXs -> " + UtilidadesExamen.validaCodigo("ABC-1-VXs")); // false (formato)
        System.out.println("ABc112VXS -> " + UtilidadesExamen.validaCodigo("ABc112VXS")); // false (formato)
        System.out.println("112VxS -> " + UtilidadesExamen.validaCodigo("112VxS")); // false (formato)

        System.out.println("\n--- EJERCICIO 3: Mapa con Valoraciones ---");
        UtilidadesExamen.ejercicioOpciones().forEach((clave, valor) -> {
            System.out.println("Clave " + clave + ": " + valor);
        });

        System.out.println("\n--- EJERCICIO 4: Perretes Famosos ---");
        List<PerroFamoso> perrosFamosos = UtilidadesExamen.creaPerros();
        System.out.println("Lista de perros famosos ordenados por nombre:");
        perrosFamosos.forEach(System.out::println);

        System.out.println("\n--- Métodos con Streams ---");

        System.out.println("\na) Nombres de perros de raza 'Pastor Aleman':");
        System.out.println(UtilidadesExamen.nombresDeRaza(perrosFamosos, "Pastor Alemán"));

        System.out.println("\nb) Conteo de perros por raza:");
        System.out.println(UtilidadesExamen.contarPorRaza(perrosFamosos));

        System.out.println("\nc) Perros nacidos antes del año 1950:");
        UtilidadesExamen.nacidosAntesDe(perrosFamosos, 1950).forEach(System.out::println);

        System.out.println("\nd) Número de perros nacidos a partir del año 2000 (inclusive):");
        System.out.println(UtilidadesExamen.contarPosterioresA(perrosFamosos, 2000));

        System.out.println("\ne) Los 3 primeros perros cuyo motivo de fama contiene 'guerra', ordenados por raza:");
        UtilidadesExamen.ordenadosLimitados(perrosFamosos, "guerra", 3).forEach(System.out::println);
    }



}
