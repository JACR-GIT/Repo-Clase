package com.ExamenesAnteriores.EV2_1;

import com.examen.dam1.Autor;
import com.examen.dam1.Obra;
import com.examen.dam1.Personaje;
import com.examen.dam1.SoporteHeroes;

import java.util.*;

import static com.ExamenesAnteriores.EV2_1.Estrellas.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int actividad;

        do {
            System.out.println("Selecciona una actividad del 1 al 6.");
            actividad = Integer.parseInt(sc.nextLine());

            switch (actividad) {
                case 1 -> actividad1();
                case 2 -> actividad2();
                case 3 -> actividad3();
                case 4 -> actividad4();
                case 5 -> actividad5();
            }
        } while (actividad != 6);

        sc.close();

    }

    public static void actividad1(){
        System.out.println(UtilidadesExamen.saludaSegunHora(null));
        System.out.println(UtilidadesExamen.saludaSegunHora(new ArrayList<>()));
        System.out.println(UtilidadesExamen.saludaSegunHora(List.of("Juan")));
        System.out.println(UtilidadesExamen.saludaSegunHora(List.of("Juan","Nati", "Vanesa")));
    }

    public static void actividad2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte nombre del jugador");
        String nombre = sc.nextLine();

        System.out.println(UtilidadesExamen.validarNombreJugador(nombre) ? "Nombre Valido" : "Nombre No Valido");
    }

    public static void actividad3(){
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Monitor", "MON001"));
        listaProductos.add(new Producto("Teclado", "TEC001"));
        listaProductos.add(new Producto("Monitor", "MON002"));
        listaProductos.add(new Producto("Raton", "MON001")); // Duplicado

        // Ordenar lista
        Collections.sort(listaProductos);
        System.out.println("Lista ordenada:");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }

        // Set para evitar duplicados
        Set<Producto> setProductos = new TreeSet<>(listaProductos);
        System.out.println("Set (sin duplicados):");
        for (Producto p : setProductos) {
            System.out.println(p);
        }

        // Valoraciones
        List<Valoracion> valoraciones = new ArrayList<>();
        valoraciones.add(new Valoracion(new Producto("Monitor", "MON001"), CINCO, "Buen producto"));
        valoraciones.add(new Valoracion(new Producto("Teclado", "TEC001"), UNA, "Regular"));
        valoraciones.add(new Valoracion(new Producto("Monitor", "MON002"), CUATRO, "Correcto"));
        valoraciones.add(new Valoracion(new Producto("Monitor", "MON001"), TRES, "Esta bien"));

        Collections.sort(valoraciones);
        System.out.println("Valoraciones ordenadas:");
        for (Valoracion v : valoraciones) {
            System.out.println(v);
        }
    }

    public static void actividad4(){
        List<Autor> listaAutores = SoporteHeroes.getInstance().getListaAutores();
        System.out.println("Lista Autores Vivos: \n");
        List<Autor> autoresVivos = UtilidadesExamen.listaAutoresVivos(listaAutores);
        for (Autor autor : autoresVivos) {
            System.out.println(autor);
        }

        List<Obra> listaObras = SoporteHeroes.getInstance().getListaObras();
        System.out.println("\nLista Obras Con Autores Vivos: \n");
        List<Obra> obrasConAutoresVivos = UtilidadesExamen.listObrasVivos(listaObras);
        for (Obra obra : obrasConAutoresVivos) {
            System.out.println(obra);
            System.out.println(obra.getAutoria());
        }

        List<Personaje> listaPersonajes = SoporteHeroes.getInstance().getListaPersonajes();
        System.out.println("\nLista Personajes Femeninos: \n");
        List<Personaje> listaPerFem = UtilidadesExamen.listPersonajesFemeninos(listaPersonajes);
        for (Personaje p : listaPerFem) {
            System.out.println(p);
        }
        double totalPersonajes = listaPersonajes.size();
        double totalPersonajesFemeninos = listaPerFem.size();

        double porcentajeFem = UtilidadesExamen.getPorcentajeFemeninos(totalPersonajesFemeninos,totalPersonajes);

        System.out.println("\nPorcentaje personajes femeninos: " + String.format("%.2f", porcentajeFem) + "%");
        System.out.println("\nPersonajes no humanos ordenados:\n");
        UtilidadesExamen.muestraNoHumanos(listaPersonajes);
    }

    public static void actividad5() {
        List<Personaje> listaPersonajes = SoporteHeroes.getInstance().getListaPersonajes();

        // Lista de transformaciones
        List<Transformacion> listaTransformaciones = Arrays.asList(
                new Transformacion("SSJ", 1000),
                new Transformacion("SSJ2", 10000),
                new Transformacion("SSJ3", 100000),
                new Transformacion("SSJG", 1000000),
                new Transformacion("SSJGSJ", 10000000),
                new Transformacion("UI", 100000000),
                new Transformacion("UE", 100000000),
                new Transformacion("Beast", 100000000),
                new Transformacion("Definitivo", 100000)
        );

        // Método auxiliar para buscar transformación por nombre
        java.util.function.Function<String, Transformacion> getTrans = nombre ->
                listaTransformaciones.stream().filter(t -> t.getNombre().equals(nombre)).findFirst().orElse(null);

        // Filtrar y convertir a Saiyano
        List<Saiyano> listaPersonajesSaiyan = new ArrayList<>();
        for (Personaje p : listaPersonajes) {
            if (p != null && (p.getRaza().name().contains("SAIYANO"))) {
                listaPersonajesSaiyan.add(new Saiyano(p, new ArrayList<>()));
            }
        }

        // Asignar transformaciones a cada Saiyano
        for (Saiyano p : listaPersonajesSaiyan) {
            switch (p.getNombre()) {
                case "Son Goku" -> p.setListaTransformaciones(Arrays.asList(
                        getTrans.apply("SSJ"), getTrans.apply("SSJ2"), getTrans.apply("SSJ3"),
                        getTrans.apply("SSJG"), getTrans.apply("SSJGSJ"), getTrans.apply("UI")));
                case "Vegeta" -> p.setListaTransformaciones(Arrays.asList(
                        getTrans.apply("SSJ"), getTrans.apply("SSJ2"), getTrans.apply("SSJG"),
                        getTrans.apply("SSJGSJ"), getTrans.apply("UE")));
                case "Son Gohan" -> p.setListaTransformaciones(Arrays.asList(
                        getTrans.apply("SSJ"), getTrans.apply("SSJ2"),
                        getTrans.apply("Beast"), getTrans.apply("Definitivo")));
                case "Son Goten", "Trunks" -> p.setListaTransformaciones(List.of(getTrans.apply("SSJ")));
            }
        }

        // Obtener y mostrar el mapa
        Map<Integer, List<Saiyano>> mapa = UtilidadesExamen.devuelveMapaSaiyano(listaPersonajesSaiyan);
        System.out.println("Mapa de Saiyanos por número de transformaciones:");
        for (Map.Entry<Integer, List<Saiyano>> entry : mapa.entrySet()) {
            System.out.println("Transformaciones: " + entry.getKey());
            for (Saiyano p : entry.getValue()) {
                System.out.println(" - " + p.getNombre());
            }
        }
    }
}
