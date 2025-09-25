package com.EstructurasEIteradores.Actividad2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainAdctividad2 {
    public static void main(String[] args) {
        Set<String> listaSinDuplicados = new HashSet<String>();
        List<String> listaDNIs = List.of(
                "12345678A",
                "87654321B",
                "12345678A", // duplicado
                "11223344C",
                "55667788D",
                "87654321B", // duplicado
                "99887766E");

        for (String listaDNI : listaDNIs) {
            if (!listaSinDuplicados.add(listaDNI)) {
                System.out.println("DNI duplicado detectado: " + listaDNI);
            }
        }
        int alumnosUnicos = listaSinDuplicados.size();

        System.out.println("Lista: " + listaSinDuplicados);
        System.out.println("Alumnos: " + alumnosUnicos);
    }
}
