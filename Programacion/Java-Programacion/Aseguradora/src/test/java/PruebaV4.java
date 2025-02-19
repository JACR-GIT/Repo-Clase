import modelos.*;
import utilidades.UtilidadesTarifa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PruebaV4 {
    public static void main(String[] args) {
        // Create a sample Cotizacion
        Persona tomador = new Persona(1, "Juan", "Perez", "Gomez", "12345678A", LocalDate.of(1980, 1, 1), new Direccion(1, null, "Calle Falsa", 1, "", "28001", "Madrid", new Provincia("28", "Madrid")));
        Conductor conductorPrincipal = new Conductor(2, "Ana", "Lopez", "Martinez", "87654321B", LocalDate.of(2000, 5, 15), new Direccion(1, null, "Calle Falsa", 1, "", "28001", "Madrid", new Provincia("28", "Madrid")));
        List<Conductor> conductoresOcasionales = new ArrayList<>();
        conductoresOcasionales.add(new Conductor(3, "Carlos", "Garcia", "Fernandez", "11223344C", LocalDate.of(1998, 8, 25), new Direccion(1, null, "Calle Falsa", 1, "", "28001", "Madrid", new Provincia("28", "Madrid")));

        Cotizacion cotizacion = new Cotizacion(1, 1001, LocalDate.now(), LocalDate.of(2024, 1, 1), new Vehiculo(), tomador, conductorPrincipal, conductoresOcasionales, false, 2, 500.0, 600.0, 700.0, Cotizacion.Modalidad.TERC);

        // Calculate the customized tariff
        UtilidadesTarifa utilidadesTarifa = new UtilidadesTarifa();
        double tarifaFinal = utilidadesTarifa.calcularTarifa(cotizacion);

        // Print the result
        System.out.println("Tarifa final: " + tarifaFinal);
    }
}