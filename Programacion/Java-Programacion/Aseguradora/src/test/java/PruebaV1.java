import java.time.LocalDate;

import modelos.*;

public class PruebaV1 {
    public static void main(String[] args) {
        // Crear un objeto de Direccion
        Direccion direccion = new Direccion(1, TipoVia.AVENIDA, "Gran Vía", 45, "Piso 3, Puerta B", "28013", "Madrid", "Madrid");

        // Crear un objeto de Persona
        Persona persona = new Persona(1, "Carlos", "Gómez", "Fernández", "12345678X", LocalDate.of(1990, 3, 15), direccion);

        // Crear un objeto de Conductor
        Conductor conductor = new Conductor(2, "Laura", "Martínez", "Ruiz", "87654321Y", LocalDate.of(1985, 7, 22), direccion,
                LocalDate.of(2003, 5, 10), 12, 10);

        // Crear un objeto de Vehiculo
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", "1234ABC", LocalDate.of(2015, 6, 10), "Rojo", persona);

        // Crear un objeto de Moto
        Moto moto = new Moto(2, "Yamaha", "YZF-R6", "5678XYZ", LocalDate.of(2020, 3, 5), "Azul", conductor, 600, false);

        // Crear un objeto de Coche
        Coche coche = new Coche(3, "Ford", "Focus", "9101DEF", LocalDate.of(2018, 9, 20), "Negro", persona, 5,
                Coche.TipoCombusible.GASOLINA, Coche.TipoTraccion.DELANTERA, false);

        // Mostrar los objetos en consola
        System.out.println("Objeto Direccion:");
        System.out.println(direccion);

        System.out.println("\nObjeto Persona:");
        System.out.println(persona);

        System.out.println("\nObjeto Conductor:");
        System.out.println(conductor);

        System.out.println("\nObjeto Vehiculo:");
        System.out.println(vehiculo);

        System.out.println("\nObjeto Moto:");
        System.out.println(moto);

        System.out.println("\nObjeto Coche:");
        System.out.println(coche);
    }
}
