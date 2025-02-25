import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;
import utilidades.UtilidadesTarifa;

import java.time.LocalDate;
import java.util.Collections;

public class PruebaV4 {
    public static void main(String[] args) {
        SoporteVehiculos soporte = SoporteVehiculos.getInstance();

        // Crear datos básicos
        Provincia prov = new Provincia("46", "Valencia");
        Direccion dir = new Direccion(1, TipoVia.CALLE, "Colón", 50, "", "46001", "Valencia", prov);
        Persona tomador = new Persona(1, "Pedro", "Ramírez", "López", "12345678Z", LocalDate.of(1980, 12, 1), dir,
                Sexo.masculino, "España", "pedro@example.com", "600777888");
        Conductor conductor = new Conductor(1, "Pedro", "Ramírez", "López", "12345678Z", LocalDate.of(1980, 12, 1), dir,
                LocalDate.of(2000, 5, 20), 12, 10);
        Coche coche = new Coche(1, soporte.getMarcaByName("Volkswagen"), new com.aseguradora.utils.Modelo("Golf", 110, 130, 160),
                "1111BBB", LocalDate.of(2019, 2, 10), "Gris", tomador, 5, TipoCombustible.HIBRIDO,
                TipoTraccion.DELANTERA, false);

        // Crear cotización
        Cotizacion cot = new Cotizacion(1, 1001, LocalDate.now(), LocalDate.now().plusDays(10), coche, tomador, conductor,
                Collections.emptyList(), true, 1, 0, 0, 0, Cotizacion.Modalidad.TRIE);
        UtilidadesTarifa.calcularTodasLasTarifas(cot);
        cot.setModalidadElegida(Cotizacion.Modalidad.TRIE);
        System.out.println("Cotización: " + cot);

        // Crear anualidad
        AnualidadPoliza anualidad = new AnualidadPoliza(1, "XYZ/2025/000001", AnualidadPoliza.EstadoPoliza.VIGENTE, null,
                cot, AnualidadPoliza.ModoPago.IBAN, false, tomador, conductor, Collections.emptyList(),
                cot.getPrecioTRIE(), UtilidadesTarifa.calcularTarifa(cot), LocalDate.now(), LocalDate.now().plusYears(1), null);
        System.out.println("Anualidad: " + anualidad);

        // Crear póliza
        Poliza poliza = new Poliza(1, "XYZ/2025/000001", Collections.singletonList(anualidad), Poliza.EstadoPoliza.VIGENTE,
                null, cot, tomador, conductor, Collections.emptyList(), cot.getPrecioTRIE(), UtilidadesTarifa.calcularTarifa(cot),
                LocalDate.now(), LocalDate.now().plusYears(1), null);
        System.out.println("Póliza: " + poliza);
    }
}