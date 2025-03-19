package com.safa.jacr;

import com.joey.utils.Opcion;
import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;
import com.joey.utils.SoporteJoey;

import java.util.ArrayList;
import java.util.List;

import static com.joey.utils.NombreRazaPerro.*;

public class Main {

    //Actividad 1
    public static void muestraOpcionesOrdenadas(List<Opcion> opciones) {
        List<Opcion> opcionesCuestanMenos200 = opciones.stream().filter(opcion -> (opcion.getPrecio()<200)).toList();
        List<Opcion> opcionesCercanas = opcionesCuestanMenos200.stream().filter(opcion -> (opcion.getDistancia()<50)).toList();
        List<Opcion> opcionesPuntuacion = opcionesCercanas.stream().sorted().toList();
        List<Opcion> opcionesPrecios = opcionesPuntuacion.stream().sorted((a, b) -> b.getPrecio().compareTo(a.getPrecio())).toList();
        for (Opcion opcion : opcionesPrecios) {
            System.out.println("Puntuacion: " + opcion.getPuntuacion());
            opcion.toString();
        }
    }

    //Actividad 2

    //Actividad 3
    public static boolean esDocumentoValido(String nombreDocumento){
        String patron = "^['Ley'-'Decreto'-'Reglamento'-'Orden']{1}' '[1-31]{1}/(1-2){1}0([1-9]{1})([1-9]{1})";
        return nombreDocumento.matches(patron);
    }

    //Actividad 4


    public static void main(String[] args) {

        //Acividad 1


        //Actividad 3
        System.out.println(esDocumentoValido("Ley 12/2024 de Protección de Datos"));
        System.out.println(esDocumentoValido("Ley 0001/2025 de Ministerio de Igualdad"));
        System.out.println(esDocumentoValido("Decreto 120/1999 de Seguridad Industrial"));
        System.out.println(esDocumentoValido("Regla 15/2018"));
        System.out.println(esDocumentoValido("Ley 21/1918 de Ministerio de Transportes"));
        System.out.println(esDocumentoValido("Ley 5/23 de Consumo"));

        //Actividad 4

        List<PerroDeJose> perrosDeJose = List.of(
                new PerroDeJose("Chuli" ,getRazaNombre.getRazaPerroByName(BEAGLE), null,null),
                new PerroDeJose("Cala" ,getRazaNombre.getRazaPerroByName(MASTIN), null,null),
                new PerroDeJose("Lila" ,getRazaNombre.getRazaPerroByName(YORKSHIRE_TERRIER), null,null)
        );
    }
}
