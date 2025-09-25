package com.EstructurasEIteradores.Actividad5;

import java.lang.reflect.Array;
import java.util.*;

public class MainActividad5 {
    public static void main(String[] args) {
        String parrafo = "En la programación, la práctica de la programación es esencial para mejorar" +
                " las habilidades de programación. Practicar programación todos los días ayuda a entender" +
                " mejor los conceptos de programación y a escribir código de programación más eficiente.";

        parrafo = parrafo.replaceAll("[,\\.]", "");
        String[] palabrasParrafo = parrafo.split(" ");

        Set<String> palabrasUnicas = new HashSet();
        palabrasUnicas.addAll(Arrays.asList(palabrasParrafo));

        int numPalabras = palabrasUnicas.size();

        System.out.println("Palabra unicas: " + palabrasUnicas);
        System.out.println("Palabra unicas: " + numPalabras);

    }
}
