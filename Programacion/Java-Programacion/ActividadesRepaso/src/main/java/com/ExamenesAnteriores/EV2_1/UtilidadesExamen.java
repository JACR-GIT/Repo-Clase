//package com.ExamenesAnteriores.EV2_1;
//
//import com.examen.dam1.*;
//
//import java.time.LocalTime;
//import java.util.*;
//import java.util.regex.Pattern;
//
//public class UtilidadesExamen {
//
//    public static String saludaSegunHora(List<String> listaNombres){
//        LocalTime localTime = LocalTime.now();
//        int horaActual = localTime.getHour();
//        String saludo = "";
//
//        if (horaActual >= 20 &&  horaActual < 6 ){
//            saludo = "Buenas noches";
//        }else if (horaActual >= 6 && horaActual < 12){
//            saludo = "Buenos dias";
//        }else if (horaActual >= 12 && horaActual < 20){
//            saludo = "Buenas tardes";
//        }
//
//        if (listaNombres == null || listaNombres.isEmpty()){
//            return saludo + ".";
//        }else if (listaNombres.size() == 1) {
//            return saludo + ", " + listaNombres.get(0);
//        } else if (listaNombres.size() == 2) {
//            return saludo + ", " + listaNombres.get(0) + " y " + listaNombres.get(1);
//        }else {
//            String nombres = String.join(", ", listaNombres.subList(0, listaNombres.size() - 1) ); //listaNombres.subList(0, listaNombres.size() - 1) obtiene todos los nombres menos el último. String.join(", ", ...) une esos nombres con comas.
//            nombres += " y " + listaNombres.get(listaNombres.size() - 1);
//            return saludo + ", " + nombres;
//        }
//    }
//
//    public static boolean validarNombreJugador(String nombreJugador){
//        if (nombreJugador == null || nombreJugador.length() < 5 || nombreJugador.length() > 15) return false;
//        String patron = "^[A-Za-z][A-Za-z0-9_.]{3,13}[A-Za-z0-9]$";
//
//        return Pattern.matches(patron, nombreJugador);
//    }
//
//    public static List<Autor> listaAutoresVivos(List<Autor> listaAutores){
//        List<Autor> autoresVivos = new ArrayList<>();
//        for (Autor autor : listaAutores){
//            if (autor != null && autor.getFechaDefuncion() == null){
//                autoresVivos.add(autor);
//            }
//        }
//        return autoresVivos;
//    }
//
//    public static List<Obra> listObrasVivos(List<Obra> listObras){
//        List<Obra> obrasVivos = new ArrayList<>();
//        for  (Obra obra : listObras){
//            boolean autorMuerto = false;
//            if (obra != null && obra.getAutoria() != null){
//                for(Autor autor : obra.getAutoria()){
//                    if (autor != null && autor.getFechaDefuncion() != null){
//                        autorMuerto = true;
//                    }
//                }
//            }
//            if (!autorMuerto){
//                obrasVivos.add(obra);
//            }
//        }
//        return obrasVivos;
//    }
//
//    public static List<Personaje> listPersonajesFemeninos(List<Personaje> listPersonajes){
//        List<Personaje> personajesFemeninos = new ArrayList<>();
//        if (listPersonajes != null) {
//            Iterator<Personaje> listaIterator= listPersonajes.iterator();
//            while (listaIterator.hasNext()) {
//                Personaje personaje = listaIterator.next();
//                if (personaje != null && personaje.getSexo() == Sexo.FEMENINO) {
//                    personajesFemeninos.add(personaje);
//                }
//            }
//        }
//        return personajesFemeninos;
//    }
//
//    public static double getPorcentajeFemeninos(double personajesFemeninos, double personajesTotal){
//        double porcenetaje = ((personajesFemeninos/personajesTotal) * 100);
//        return porcenetaje;
//    }
//
//    public static void muestraNoHumanos(List<Personaje> listPersonajes){
//        List <Personaje> personajesNoHumanos = new ArrayList<>();
//        for (Personaje personaje : listPersonajes){
//            if (personaje != null && personaje.getRaza() != Raza.HUMANO){
//                personajesNoHumanos.add(personaje);
//            }
//        }
//
//        personajesNoHumanos.sort(Comparator.comparing((Personaje p) -> p.getObra().getPrimeraPublicacion()).thenComparing(Personaje::getNombre)); //Para poner orden descendente a los nombres: .thenComparing(Personaje::getNombre, Comparator.reverseOrder())
//
//        for (Personaje personaje : personajesNoHumanos) {
//            if (personaje.getNombreIdentidad() != null) {
//                System.out.println(personaje.getNombreIdentidad() + " (" + personaje.getNombre() + " )" + " - " +  personaje.getObra().getNombre());
//            } else {
//                System.out.println(personaje);
//            }
//        }
//    }
//
//    public static List<Personaje> listaSaiyanos (List<Personaje> listaPersonajes){
//        List<Personaje> saiyanos = new ArrayList<>();
//        for (Personaje personajes : listaPersonajes){
//            if (personajes != null && (personajes.getRaza() == Raza.SAIYANO || personajes.getRaza() == Raza.SAIYANO_MESTIZO)){
//                saiyanos.add(personajes);
//            }
//        }
//        return saiyanos;
//    }
//
//    public static Map<Integer, List<Saiyano>> devuelveMapaSaiyano(List<Saiyano> listaSaiyanos) {
//        Map<Integer, List<Saiyano>> mapa = new TreeMap<>();
//        for (Saiyano s : listaSaiyanos) {
//            int numTrans = s.getListaTransformaciones() != null ? s.getListaTransformaciones().size() : 0;
//            mapa.computeIfAbsent(numTrans, k -> new ArrayList<>()).add(s);
//        }
//        return mapa;
//
//    }
//}
