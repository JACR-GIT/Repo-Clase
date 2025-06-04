package com.Actividad1;

import com.Actividad1.ProductoNoPedecedero;
import com.Actividad1.ProductoPedecedero;
import com.Main;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LectorProductos {

    public void leerYSepararProductos (String rutaArchivo){
        try {
            InputStream inputStream =
                    Main.class.getClassLoader().getResourceAsStream(rutaArchivo);
            if (inputStream == null) {
                throw new FileNotFoundException("No se ha encontrado el archivo en resources.");
            }
            Reader reader = new InputStreamReader(inputStream);
            CsvToBean<ProductoCSV> csvToBean = new CsvToBeanBuilder<ProductoCSV>(reader)
                    .withType(ProductoCSV.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<ProductoCSV> productoCSVS = csvToBean.parse();
            System.out.println("Libros leídos del CSV:");
            for (ProductoCSV libro : productoCSVS) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
