import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;
import utilidades.UtilidadesDireccion;
import utilidades.UtilidadesPersonas;

import java.time.LocalDate;

public class PruebaV3 {
    public static void main(String[] args) {
        SoporteVehiculos soporte = SoporteVehiculos.getInstance();

        // Crear dirección con provincia
        Provincia prov = new Provincia("08", "Barcelona");
        Direccion dir = new Direccion(1, TipoVia.PLAZA, "Catalunya", 1, "", "08001", "Barcelona", prov);
        System.out.println("CP válido: " + UtilidadesDireccion.esCPValido(dir.getCodigoPostal()));

        // Crear persona
            Persona p = new Persona(1, "Marta", "Sánchez", "Díaz", "87654321X", LocalDate.of(1995, 3, 22), dir,
                    Sexo.femenino, "España", "marta@example.com", "600111222");
            System.out.println(p);

        // Crear conductor
            Conductor conductor = new Conductor(2, "Luis", "Martínez", "Gómez", "12345678Z", LocalDate.of(2000, 1, 15), dir,
                    LocalDate.of(2018, 6, 10), 12, 2);
            System.out.println(conductor);

        // Crear coche
            Coche coche = new Coche(1, soporte.getMarcaByName("Ford"), new com.aseguradora.utils.Modelo("Focus", 100, 120, 150),
                    "5678XYZ", LocalDate.of(2021, 9, 5), "Negro", null, 4, TipoCombustible.ELECTRICO,
                    TipoTraccion.TRASERA, false);
            System.out.println(coche);
            System.out.println("Tarifa: " + soporte.calcularTarifa("Ford", "Focus", 2021));
    }
}