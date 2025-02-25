import modelos.*;
import utilidades.UtilidadesPersonas;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaV2 {
    public static void main(String[] args) {
        // Crear dirección y persona
        Direccion dir = new Direccion(1, TipoVia.AVENIDA, "Castellana", 100, "Piso 3", "28046", "Madrid", new Provincia("Madrid", "28"));
        Persona p = new Persona(1, "Carlos", "García", "Ruiz", "12345678Z", LocalDate.of(1988, 10, 10), dir,
                Sexo.masculino, "España", "carlos@example.com", "600555666");

        // Probar NIF y edad
        System.out.println("NIF válido: " + UtilidadesPersonas.esNIFValido(p));
        System.out.println("Edad Persona: " + UtilidadesPersonas.getEdad(p) + " años");

        // Crear vehículos
        Coche coche = new Coche(1, "Seat", "Ibiza", "9876KLM", LocalDate.of(2015, 4, 12), "Rojo", p, 5,
                TipoCombustible.DIESEL, TipoTraccion.DELANTERA, false);
        Moto moto = new Moto(2, "Yamaha", "MT-07", "4321PQR", LocalDate.of(2019, 7, 20), "Blanco", p, 700, true);

        // Probar métodos de UtilidadesVehiculo
        System.out.println("Edad coche: " + UtilidadesVehiculo.calculaEdad(coche) + " años");
        System.out.println("Fecha válida: " + UtilidadesVehiculo.validaFechaMatriculacion(coche.getFechaMatriculacion()));
        System.out.println("Vehículos de Carlos: " + UtilidadesVehiculo.getVehiculos(Arrays.asList(coche, moto), p));

        // Crear aseguradora
        Aseguradora a = new Aseguradora(1, "SegurosXYZ", dir, "912345678", new ArrayList<>());
        a.getVehiculosAsegurados().add(coche);
        System.out.println(a);
    }
}