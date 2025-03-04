package com.safa.jacr;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.examen.dam1.*;

public class UtilidadesExamen {
    //Actividad 1
    public static String saludaSegunHora(List<String> listaNombres) {
        LocalTime horaActual = LocalTime.now();
        int hora = horaActual.getHour();
        String saludo = (hora < 6 || hora >= 20) ? "Buenas noches" :
                (hora < 12) ? "Buenos días" : "Buenas tardes";

        if (listaNombres == null || listaNombres.isEmpty()) return saludo;

        StringBuilder resultado = new StringBuilder(saludo + ", ");
        int size = listaNombres.size();
        for (int i = 0; i < size; i++) {
            if (size == 1) {
                resultado.append(listaNombres.get(i)).append(".");
            } else if (i == size - 1) {
                resultado.append("y ").append(listaNombres.get(i)).append(".");
            } else if (i == size - 2) {
                resultado.append(listaNombres.get(i)).append(" ");
            } else {
                resultado.append(listaNombres.get(i)).append(", ");
            }
        }
        return resultado.toString();
    }
    //Actividad 2
    public static boolean validaNombreJugador (String nombre){
        String patron = "^[A-Za-z][A-Za-z0-9_.]{3,13}[A-Za-z0-9]";
        boolean valido = false;

        if (nombre == null || nombre.length() < 5 || nombre.length() > 15) return false;

        if (nombre.matches(patron)) {
            System.out.println("Nombre del jugador valido.");
            valido = true;
        }

        return valido;
    }

    //Actividad 4
    public List<Autor> listAutoresVivos() {
        return SoporteHeroes.getInstance().getListaAutores().stream().filter(Autores -> Autores.getFechaDefuncion() == null)
                .collect(Collectors.toList());
    }

    public List<Obra> listObrasVivos() {
        List<Obra> todasObras = SoporteHeroes.getInstance().getListaObras();
        List<Obra> obrasVivas = new ArrayList<>();

        for (int i = 0; i < todasObras.size(); i++) {
            Obra obra = todasObras.get(i);
            List<Autor> autores = obra.getAutoria();
            boolean todosVivos = true;

            for (int j = 0; j < autores.size(); j++) {
                if (autores.get(j).getFechaDefuncion() != null) {
                    todosVivos = false;
                }
            }
            if (todosVivos) {
                obrasVivas.add(obra);
            }
        }
        return obrasVivas;
    }

    public List<Personaje> listPersonajesFemeninos() {
        List<Personaje> listaPersonajes = SoporteHeroes.getInstance().getListaPersonajes();
        List<Personaje> copiaListaPersonajes = new ArrayList<>();

        for (int i = 0; i < listaPersonajes.size(); i++) {
            copiaListaPersonajes.add(listaPersonajes.get(i));
        }

        Iterator<Personaje> iterador = copiaListaPersonajes.iterator();
        while (iterador.hasNext()) {
            Personaje p = iterador.next();
            if (p.getSexo() != Sexo.FEMENINO) {
                iterador.remove();
            }
        }
        return copiaListaPersonajes;
    }

    public double getPorcentajeFemeninos() {
        List<Personaje> personajes = SoporteHeroes.getInstance().getListaPersonajes();
        int total = personajes.size();
        int femeninos = 0;

        for (int i = 0; i < total; i++) {
            if (personajes.get(i).getSexo() == Sexo.FEMENINO) {
                femeninos++;
            }
        }
        double porcentaje = (femeninos * 100.0) / total;
        porcentaje = Math.round(porcentaje * 100) / 100.0;
        return porcentaje;
    }

    public void muestraNoHumanos() {

    }
}
