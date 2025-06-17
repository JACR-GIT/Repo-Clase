package com.safa.jacr;

import com.joey.utils.Opcion;
import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;
import com.joey.utils.SoporteJoey;

import java.util.ArrayList;
import java.util.List;

import static com.joey.utils.NombreRazaPerro.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Acividad 4");
        List<PerroConChip> perrosConChip = UtilidadesExamen.creaPerros();
        System.out.println(perrosConChip);
        System.out.println("\nActividad 1");
        System.out.println(UtilidadesExamen.agrupaRazasPorLongitud(perrosConChip));
        System.out.println("\nActividad 2");
        System.out.println(UtilidadesExamen.validaCodigo("VAC-2023/2413-LC"));
        System.out.println(UtilidadesExamen.validaCodigo("VAC-2026/3127-LG"));
        System.out.println(UtilidadesExamen.validaCodigo("VAC-2012/0000-LZ"));
        System.out.println(UtilidadesExamen.validaCodigo("VAC-2018/2342-LB"));
        System.out.println("\nActividad 3");
        List<Opcion> listaOpciones = SoporteJoey.getInstance().getOpciones();
        //System.out.println(UtilidadesExamen.sitiosBaratos(listaOpciones, 20));
        //System.out.println(UtilidadesExamen.agrupaPorRangoDistancia(listaOpciones));
        System.out.println(UtilidadesExamen.precioMedioDePros(listaOpciones, "Plan"));
        System.out.println(UtilidadesExamen.ordenarPorDistanciaYPuntuacion(listaOpciones));


    }
}
