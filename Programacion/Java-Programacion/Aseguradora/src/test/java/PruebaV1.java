// src/test/java/pruebaV1.java
import modelos.*;

import java.time.LocalDate;

public class PruebaV1 {
    public static void main(String[] args) {
        Direccion direccion = new Direccion(1, TipoVia.CALLE, "Gran Via", 10, "2B", "28013", "Madrid", new Provincia("1","Madrid"));
        Persona persona = new Persona(1, "Juan", "Perez", "Gomez", "12345678A", LocalDate.of(1990, 1, 1), direccion);
        Conductor conductor = new Conductor(2, "Ana", "Lopez", "Martinez", "87654321B", LocalDate.of(1985, 5, 5), direccion, LocalDate.of(2005, 5, 5), 12, 5);
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", "1234ABC", LocalDate.of(2015, 6, 15), "Rojo", persona);
        Coche coche = new Coche(2, "Ford", "Focus", "5678DEF", LocalDate.of(2018, 3, 20), "Azul", persona, 5, Coche.TipoCombusible.GASOLINA, Coche.TipoTraccion.DELANTERA, false);
        Moto moto = new Moto(3, "Yamaha", "R1", "9101GHI", LocalDate.of(2020, 8, 25), "Negro", persona, 1000, false);

        System.out.println(persona);
        System.out.println(conductor);
        System.out.println(vehiculo);
        System.out.println(coche);
        System.out.println(moto);
    }
}