package com.Actividad1;

import com.Actividad1.ProductoNoPedecedero;
import com.Actividad1.ProductoPedecedero;
import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActividad1 {
    public static void main(String[] args) {
        LectorProductos lector = new LectorProductos();
        lector.leerYSepararProductos("productos.csv");
    }
}