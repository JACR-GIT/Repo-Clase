package com.Actividad1;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class LectorProductos {

    public List<ProductoNoPedecedero> leerProductosNoPerecederos(String rutaArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(rutaArchivo);
            if (inputStream == null) {
                throw new FileNotFoundException("No se ha encontrado el archivo " + rutaArchivo + " en resources.");
            }
            Reader reader = new InputStreamReader(inputStream);
            CsvToBean<ProductoNoPedecedero> csvToBean = new CsvToBeanBuilder<ProductoNoPedecedero>(reader)
                    .withType(ProductoNoPedecedero.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<ProductoPedecedero> leerProductosPedecedero(String rutaArchivo) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(rutaArchivo);
            if (inputStream == null) {
                throw new FileNotFoundException("No se ha encontrado el archivo " + rutaArchivo + " en resources.");
            }
            Reader reader = new InputStreamReader(inputStream);
            CsvToBean<ProductoPedecedero> csvToBean = new CsvToBeanBuilder<ProductoPedecedero>(reader)
                    .withType(ProductoPedecedero.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}