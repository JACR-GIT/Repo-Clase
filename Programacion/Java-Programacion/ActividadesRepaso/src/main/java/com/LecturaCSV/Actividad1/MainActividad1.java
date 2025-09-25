package com.LecturaCSV.Actividad1;

public class MainActividad1 {
    public static void main(String[] args) {
        LectorProductos lector = new LectorProductos();
        lector.leerYSepararProductos("productos.csv");
    }
}