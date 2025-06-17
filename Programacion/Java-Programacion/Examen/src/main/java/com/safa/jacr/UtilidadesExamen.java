package com.safa.jacr;

import com.joey.utils.*;
import com.sun.jdi.IntegerType;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UtilidadesExamen {
    //Actividad 1
    public static Map<Integer, List<String>> agrupaRazasPorLongitud(List<PerroConChip> listaRazas) {
        Map<Integer, List<String>> mapa = listaRazas.stream()
                .collect(Collectors.groupingBy(
                        perroConChip -> perroConChip.getRaza().getNombreRaza().toString().length(),
                        Collectors.mapping(r -> r.getRaza().getNombreRaza().toString(), Collectors.toList())
                ));

        mapa.values().forEach(Collections::reverse);
        return mapa;
    }

    //Actividad 2
    private static final List<Character> caracteresValidos =
            Arrays.asList('A', 'C', 'E', 'G', 'I');

    public static boolean validaCodigo(String codigo) {
        String patron = "^VAC-([0-9]){4}([0-9]){4}/([0-9]){4}-([A-Za-z]){1}";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(codigo);

        if (!matcher.matches()) {
            return false;
        }

        if (matcher.matches()) {
            int anio = Integer.parseInt(matcher.group(2));
            int anioActual = java.time.Year.now().getValue();
            return anio >= 2010 && anio < (anioActual+1);
        }

        String numerosContro = matcher.group(3).toString();
        char caracter = numerosContro.charAt(3);
        String letraControl = matcher.group(4).toUpperCase();

//        for (char c : caracteresValidos) {
//            switch (letraControl) {
//                case 'A' -> !caracter == 1;
//                case 'C'->  !caracter == 3;
//                case 'E' -> !caracter == 5;
//                case 'G' -> !caracter == 7;
//                case 'I' -> !caracter == 9;
//            }
//        }

        return true;
    }

    //Actividad 3
//    public static List<String> sitiosBaratos(List<Opcion> l, double maxPrecio){
//        return l.stream().filter(o -> o.getPrecio() <= maxPrecio)
//                .sorted(Comparator.comparing(Opcion::getDistancia))
//                .;
//    }

//    public static Map<String, List<Opcion>> agrupaPorRangoDistancia(List<Opcion> l){
//        return l.stream()
//                .collect(Collectors.groupingBy(
//                        Opcion::getDistancia,
//                        Collectors.toList()
//                ));
//    }

    public static double precioMedioDePros(List<Opcion> l, String pro){
        return l.stream().filter(opcion -> opcion.getPros().contains(pro))
                .map(opcion -> opcion.getPrecio())
                .reduce(0.0, Double::sum);
    }

    public static List<Opcion> ordenarPorDistanciaYPuntuacion(List<Opcion> l){
        return l.stream()
                .sorted(Comparator
                        .comparing(Opcion::getDistancia)
                        .thenComparing(Opcion::getPuntuacion, Comparator.reverseOrder())
                        .thenComparing(Opcion::getNombre)
                )
                .collect(Collectors.toList());
    }
    //Actividad 4
    public static List<PerroConChip> creaPerros() {
        List<PerroConChip> perros = new ArrayList<>();
        SoporteJoey soporte = SoporteJoey.getInstance();

        perros.add(new PerroConChip("Hachiko", soporte.getRazaPerroByName(NombreRazaPerro.AKITA_INU), LocalDate.of(1923, 11, 10), "1", true));
        perros.add(new PerroConChip("Snoopy", soporte.getRazaPerroByName(NombreRazaPerro.BEAGLE), LocalDate.of(1950, 10, 2), "2", false));
        perros.add(new PerroConChip("Gordo", soporte.getRazaPerroByName(NombreRazaPerro.MASTIN), LocalDate.of(2008, 1, 1), "3", true));
        perros.add(new PerroConChip("Barry", soporte.getRazaPerroByName(NombreRazaPerro.MASTIN), LocalDate.of(1800, 1, 1), "4", false));
        perros.add(new PerroConChip("Rex", soporte.getRazaPerroByName(NombreRazaPerro.PASTOR_ALEMAN), LocalDate.of(1994, 1, 1), "5", true));

        Collections.sort(perros);
        return perros;
    }
}
