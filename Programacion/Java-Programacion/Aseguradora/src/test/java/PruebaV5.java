import modelos.*;
import utilidades.UtilidadesAseguradora;
import utilidades.UtilidadesTarifa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class PruebaV5 {
    public static void main(String[] args) {
        // Crear datos básicos
        Provincia prov = new Provincia("41", "Sevilla");
        Direccion dir = new Direccion(1, TipoVia.AVENIDA, "Reyes Católicos", 20, "", "41001", "Sevilla", prov);
        Persona tomador = new Persona(1, "Sofía", "Moreno", "Vega", "12345678Z", LocalDate.of(1992, 7, 14), dir,
                Sexo.femenino, "España", "sofia@example.com", "600999000");
        Conductor conductor = new Conductor(1, "Sofía", "Moreno", "Vega", "12345678Z", LocalDate.of(1992, 7, 14), dir,
                LocalDate.of(2012, 9, 1), 12, 8);
        Coche coche = new Coche(1, "Renault", "Clio", "2222CCC", LocalDate.of(2022, 11, 30), "Blanco", tomador, 5,
                TipoCombustible.GASOLINA, TipoTraccion.DELANTERA, false);

        // Crear cotización y póliza
        Cotizacion cot = new Cotizacion(1, 1002, LocalDate.now(), LocalDate.now().plusDays(5), coche, tomador, conductor,
                Collections.emptyList(), false, 0, 0, 0, 0, Cotizacion.Modalidad.TAMP);
        UtilidadesTarifa.calcularTodasLasTarifas(cot);
        AnualidadPoliza anualidad = new AnualidadPoliza(1, "ABC/2025/000002", AnualidadPoliza.EstadoPoliza.VIGENTE, null,
                cot, AnualidadPoliza.ModoPago.TARJETA, true, tomador, conductor, Collections.emptyList(),
                cot.getPrecioTAMP(), UtilidadesTarifa.calcularTarifa(cot), LocalDate.now(), LocalDate.now().plusYears(1), null);
        Poliza poliza = new Poliza(1, "ABC/2025/000002", Collections.singletonList(anualidad), Poliza.EstadoPoliza.VIGENTE,
                null, cot, tomador, conductor, Collections.emptyList(), cot.getPrecioTAMP(), UtilidadesTarifa.calcularTarifa(cot),
                LocalDate.now(), LocalDate.now().plusYears(1), null);

        // Crear aseguradora
        Aseguradora a = new Aseguradora(1, "AseguradoraABC", dir, "954123456", new ArrayList<>());
        a.addPoliza(poliza);
        System.out.println(a);

        // Probar UtilidadesAseguradora
        UtilidadesAseguradora util = new UtilidadesAseguradora();
        System.out.println("Póliza recuperada: " + util.recuperarPoliza(a, "ABC/2025/000002"));
        System.out.println("Pólizas activas: " + util.recuperarPolizasActivas(a));
        System.out.println("Pólizas por tomador: " + util.recuperarPolizasPorTomador(a, "12345678Z"));
        System.out.println("Pólizas por conductor: " + util.recuperarPolizasPorConductor(a, "12345678Z"));
    }
}