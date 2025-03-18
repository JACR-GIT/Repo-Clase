package Primeros_30.Ejercicio_20;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Libro> proveedor =() -> new Libro("Java Avanzado");

        Libro libro = proveedor.get();

        System.out.println(libro);
    }
}

