package Julian_30.Ejer_23;

import java.util.function.BiFunction;

public class Estudiante {
    String nombre;
    int edad;
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String toString() { return nombre + " (" + edad + ")"; }
}

