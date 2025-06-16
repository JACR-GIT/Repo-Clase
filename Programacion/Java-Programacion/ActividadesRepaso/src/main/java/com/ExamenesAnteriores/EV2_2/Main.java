package com.ExamenesAnteriores.EV2_2;

import com.joey.utils.NombreRazaPerro;
import com.joey.utils.Opcion;
import com.joey.utils.RazaPerro;
import com.joey.utils.SoporteJoey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Actividad 1:");
        muestraOpcionesOrdenadas();

        System.out.println("\nActividad 2:");
        System.out.println(creaMapaOpciones());

        System.out.println("\nActividad 3:");
        System.out.println(esDocumentoValido("Ley 12/2024 de Protección de Datos"));
        System.out.println(esDocumentoValido("Ley 0001/2025 de Ministerio de Igualdad"));
        System.out.println(esDocumentoValido("Decreto 120/1999 de Seguridad Industrial"));
        System.out.println(esDocumentoValido("Regla 15/2018"));
        System.out.println(esDocumentoValido("Ley 21/1918 de Ministerio de Transportes"));
        System.out.println(esDocumentoValido("Ley 5/23 de Consumo"));

        System.out.println("\nActividad 4:");
        System.out.println("Lista de perros ordenados:");
        System.out.println(listaOrdenadaPerroJose());
        System.out.println("\nLista hermanos ordenados:");
        listaAsignacionHermanos(listaOrdenadaPerroJose());
        System.out.println("\nLista de parque que se pueden ir:");
        muestraParquesMayoria(listaOrdenadaPerroJose(), SoporteJoey.getInstance().getPerrosParques());
    }

    //Actividad 1
    public static void muestraOpcionesOrdenadas(){
        List<Opcion> listaOpciones = SoporteJoey.getInstance().getOpciones();

        listaOpciones.stream().filter(opcion -> opcion.getDistancia()<=50 && opcion.getPrecio()<200).sorted(
                Comparator.comparingInt(Opcion::getPuntuacion).reversed()
                .thenComparingDouble(Opcion::getPrecio)).
                forEach(opcion -> System.out.println("\n>> Puntuacion: " + opcion.getPuntuacion() +
                        "\n----------\n" + "| Opcion | " + opcion.getNombre() + "\n----------" +
                        "\n\t Descripcion : " + opcion.getDescripcion() +
                        "\n\t Precio : " + opcion.getPrecio() + "€" +
                        "\n\t Distancia : " + opcion.getDistancia() +"Km"));

    }

    //Actividad2
    public static Map<Integer, List<String>> creaMapaOpciones(){
        List<Opcion> listaOpciones = SoporteJoey.getInstance().getOpciones();

        return listaOpciones.stream()
                .collect(Collectors.groupingBy(
                        Opcion::getPuntuacion,
                        TreeMap::new,
                        Collectors.mapping(
                                opcion -> opcion.getNombre().toUpperCase(),
                                Collectors.toList()
                        )
                ));
    }

    //Actividad 3
    public static boolean esDocumentoValido(String nombreDocumento){
        String patron = "^(Ley|Decreto|Reglamento|Orden) ([1-9][0-9]{0,3})/(\\d{4})(?: de .+)?$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(patron);
        java.util.regex.Matcher matcher = pattern.matcher(nombreDocumento);

        if (matcher.matches()) {
            int anio = Integer.parseInt(matcher.group(3));
            int anioActual = java.time.Year.now().getValue();
            return anio >= 1975 && anio <= anioActual;
        }
        return false;
    }

    //Actividad 4
    public static List<PerroDeJose> listaOrdenadaPerroJose(){
        List<PerroDeJose> listaPerrosJose = new ArrayList<>();
        listaPerrosJose.add(new PerroDeJose("Chuli", SoporteJoey.getInstance().getRazaPerroByName(NombreRazaPerro.BEAGLE), null,null));
        listaPerrosJose.add(new PerroDeJose("Cala", SoporteJoey.getInstance().getRazaPerroByName(NombreRazaPerro.MASTIN), null,null));
        listaPerrosJose.add(new PerroDeJose("Lila", SoporteJoey.getInstance().getRazaPerroByName(NombreRazaPerro.YORKSHIRE_TERRIER), null,null));

        listaPerrosJose.sort(Comparator.comparing(PerroDeJose::getNombre));

        return listaPerrosJose;
    }

    public static void listaAsignacionHermanos(List<PerroDeJose> listaPerrosJose){
        List<String> listaHermanos = SoporteJoey.getInstance().getHermanosJose();
        listaHermanos.sort(String::compareToIgnoreCase);

        for (int i = 0; i < listaPerrosJose.size() && i < listaHermanos.size(); i++) {
            listaPerrosJose.get(i).setPaseadoPor(listaHermanos.get(i));
        }

        for (PerroDeJose perro : listaPerrosJose) {
            System.out.println(perro);
        }
    }

    public static boolean sonMayoria(List<PerroDeJose> listaPerrosJose, Map<NombreRazaPerro, Integer> mapaParque) {
        // Obtener las razas de los perros de Jose
        List<NombreRazaPerro> razasJose = listaPerrosJose.stream()
                .map(perro -> perro.getRaza().getNombreRaza())
                .collect(Collectors.toList());

        // Contar cuántos perros de esas razas hay en el parque
        int perrosJoseEnParque = razasJose.stream()
                .mapToInt(raza -> mapaParque.getOrDefault(raza, 0))
                .sum();

        // Añadir los perros de Jose (uno por cada perro)
        int totalPerrosJose = listaPerrosJose.size();
        int totalRazasJose = perrosJoseEnParque + totalPerrosJose;

        // Sumar todos los perros del parque y añadir los de Jose
        int totalParque = mapaParque.values().stream().mapToInt(Integer::intValue).sum() + totalPerrosJose;

        // Son mayoría si hay más de la mitad
        return totalRazasJose > totalParque / 2;
    }

    // Iterar sobre todos los parques y mostrar si se puede ir o no
    public static void muestraParquesMayoria(List<PerroDeJose> listaPerrosJose, Map<String, Map<NombreRazaPerro, Integer>> parques) {
        for (Map.Entry<String, Map<NombreRazaPerro, Integer>> entry : parques.entrySet()) {
            String nombreParque = entry.getKey();
            Map<NombreRazaPerro, Integer> mapaParque = entry.getValue();
            boolean puedeIr = sonMayoria(listaPerrosJose, mapaParque);
            System.out.println("¿Puede ir al parque " + nombreParque + "? " + (puedeIr ? "SÍ" : "NO"));
        }
    }
}
