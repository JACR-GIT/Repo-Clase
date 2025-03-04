package com.safa.jacr;

import com.safa.jacr.UtilidadesExamen;
import java.time.LocalTime;
import java.util.*;
import com.examen.dam1.*;

public class Main {
    public static void mostrarMenu() {
        System.out.println("\nMenú de Ejercicios");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
        System.out.println("5. Ejercicio 5");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción (1-6): ");
    }

    private static int leerOpcionValida(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void ejecutarEjercicio1() {
        System.out.println("Ejecutando Ejercicio 1...\n");
        System.out.println(UtilidadesExamen.saludaSegunHora(null));
        System.out.println(UtilidadesExamen.saludaSegunHora(new ArrayList<>()));
        System.out.println(UtilidadesExamen.saludaSegunHora(List.of("Juan")));
        System.out.println(UtilidadesExamen.saludaSegunHora(List.of("Juan", "Nati", "Vanesa")));
    }

    public static void ejecutarEjercicio2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ejecutando Ejercicio 2...\n");
        System.out.print("Inserte nombre del jugador");
        String nombre = scanner.nextLine();
        boolean esValido = UtilidadesExamen.validaNombreJugador(nombre);
        System.out.println("Nombre: " + nombre + " -> " + (esValido ? "Válido" : "No válido"));
    }

    private static void ejecutarEjercicio3() {
        System.out.println("Ejecutando Ejercicio 3...\n");
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Monitor", "MON001"));
        listaProductos.add(new Producto("Teclado", "TEC001"));
        listaProductos.add(new Producto("Monitor", "MON002"));
        System.out.println("Lista ordenada de productos:");
        listaProductos.forEach(p -> System.out.println(p.getNombre() + " (" + p.getCodigo() + ")"));

        Set<Producto> setProductos = new HashSet<>(listaProductos);
        System.out.println("\nConjunto de productos (sin duplicados por código):");
        setProductos.forEach(p -> System.out.println(p.getNombre() + " (" + p.getCodigo() + ")"));

        // Valoraciones
        List<Valoracion> valoraciones = new ArrayList<>();
        valoraciones.add(new Valoracion(new Producto("Monitor", "MON001"), 5, "Buen producto"));
        valoraciones.add(new Valoracion(new Producto("Teclado", "TEC001"), 1, "Regular"));
        Collections.sort(valoraciones);
        System.out.println("\nValoraciones ordenadas:");
        valoraciones.forEach(System.out::println);
    }

    private static void ejecutarEjercicio4() {
        System.out.println("Ejecutando Ejercicio 4...\n");
        UtilidadesExamen util = new UtilidadesExamen();
        System.out.println("Autores vivos:");
        List<Autor> vivos = util.listAutoresVivos();
        for (int i = 0; i < vivos.size(); i++) {
            System.out.println(vivos.get(i).getNombre());
        }

        System.out.println("\nObras de autores vivos:");
        List<Obra> obras = util.listObrasVivos();
        for (int i = 0; i < obras.size(); i++) {
            System.out.println(obras.get(i).getNombre());
        }

        System.out.println("\nPersonajes femeninos:");
        List<Personaje> femeninos = util.listPersonajesFemeninos();
        for (int i = 0; i < femeninos.size(); i++) {
            System.out.println(femeninos.get(i).getNombre());
        }

        System.out.println("\nPorcentaje femenino: " + util.getPorcentajeFemeninos() + "%");

        System.out.println("\nPersonajes no humanos:");
        util.muestraNoHumanos();
    }

    private static void ejecutarEjercicio5() {
        System.out.println("Ejecutando Ejercicio 5...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = leerOpcionValida(scanner);

            switch (opcion) {
                case 1 -> ejecutarEjercicio1();
                case 2 -> ejecutarEjercicio2();
                case 3 -> ejecutarEjercicio3();
                case 4 -> ejecutarEjercicio4();
                case 5 -> ejecutarEjercicio5();
                case 6 -> System.out.println("¡Adios!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}