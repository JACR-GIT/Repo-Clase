package com.EstructurasEIteradores.Actividad6;

public class Configuracion {

    public static final String version = "1.0.0";
    public static int contadorInstancias;

    public static void mostrarInfo(String version, int contadorInstancias) {
        System.out.println("Version: " + version);
        System.out.println("Contador instancias: " + contadorInstancias);
    }
}
