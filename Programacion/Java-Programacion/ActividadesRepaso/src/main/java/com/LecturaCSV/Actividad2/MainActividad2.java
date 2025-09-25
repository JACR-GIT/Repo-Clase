package com.LecturaCSV.Actividad2;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.tools.javac.Main;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class MainActividad2 {
    public static void main(String[] args) {
        try {
            InputStream inputStream =
                    Main.class.getClassLoader().getResourceAsStream("libros.csv");
            if (inputStream == null) {
                throw new FileNotFoundException("No se ha encontrado el archivo " +
                        "libros.csv en resources.");
            }
            Reader reader = new InputStreamReader(inputStream);
            CsvToBean<Libro> csvToBean = new CsvToBeanBuilder<Libro>(reader)
                    .withType(Libro.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Libro> libros = csvToBean.parse();
            System.out.println("Libros leídos del CSV:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

}
