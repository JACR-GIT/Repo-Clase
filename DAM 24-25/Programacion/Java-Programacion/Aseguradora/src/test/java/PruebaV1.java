import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;

import java.time.LocalDate;

public class PruebaV1 {
    public static void main(String[] args) {

        SoporteVehiculos soporte = SoporteVehiculos.getInstance();

        // Crear una dirección
        Direccion dir = new Direccion(1, TipoVia.CALLE, "Mayor", 10, "1A", "28001", "Madrid", new Provincia("Madrid", "28"));
        // Crear una persona
        Persona p = new Persona(1, "Juan", "Pérez", "Gómez", "12345678Z", LocalDate.of(1990, 5, 15), dir);
        // Crear un conductor
        Conductor c = new Conductor(2, "Ana", "López", "Martín", "87654321X", LocalDate.of(1985, 8, 20), dir,
                LocalDate.of(2005, 1, 10), 12, 5);
        // Crear un coche
        Coche coche = new Coche(1, soporte.getMarcaByName("Seat"), new com.aseguradora.utils.Modelo("Leon", 100, 120, 150), "1234BCD", LocalDate.of(2018, 3, 25), "Azul", p, 4,
                TipoCombustible.GASOLINA, TipoTraccion.DELANTERA, false);
        // Crear una moto
        Moto moto = new Moto(2, "Honda", "CBR", "5678XYZ", LocalDate.of(2020, 6, 15), "Negro", c, 500, false);

        // Mostrar por consola
        System.out.println(p);
        System.out.println(c);
        System.out.println(coche);
        System.out.println(moto);
    }
}