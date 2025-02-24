import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;
import utilidades.UtilidadesTarifa;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PruebaContratacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SoporteVehiculos soporte = SoporteVehiculos.getInstance();

        // Pedir tipo de vehículo
        System.out.println("¿Coche (1) o Moto (2)?");
        Vehiculo vehiculo = null;
        while (vehiculo == null) {
            try {
                int tipo = Integer.parseInt(scanner.nextLine());
                System.out.println("Marca:");
                String marca = scanner.nextLine();
                System.out.println("Modelo:");
                String modelo = scanner.nextLine();
                System.out.println("Matrícula:");
                String matricula = scanner.nextLine();
                System.out.println("Fecha matriculación (dd/MM/yyyy):");
                LocalDate fechaMat = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Color:");
                String color = scanner.nextLine();

                if (tipo == 1) {
                    System.out.println("Número de puertas:");
                    int puertas = Integer.parseInt(scanner.nextLine());
                    System.out.println("Combustible (GASOLINA/DIESEL/ELECTRICO/HIBRIDO):");
                    Coche.TipoCombustible comb = Coche.TipoCombustible.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Tracción (DELANTERA/TRASERA/TOTAL):");
                    Coche.TipoTraccion trac = Coche.TipoTraccion.valueOf(scanner.nextLine().toUpperCase());
                    vehiculo = new Coche(1, marca, modelo, matricula, fechaMat, color, null, puertas, comb, trac, false);
                } else {
                    System.out.println("Cilindrada (CC):");
                    int cc = Integer.parseInt(scanner.nextLine());
                    System.out.println("¿Sidecar? (s/n):");
                    boolean sidecar = scanner.nextLine().equalsIgnoreCase("s");
                    vehiculo = new Moto(1, marca, modelo, matricula, fechaMat, color, null, cc, sidecar);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Intenta de nuevo.");
            }
        }

        // Pedir datos del tomador
        System.out.println("Datos del tomador:");
        Persona tomador = null;
        while (tomador == null) {
            try {
                System.out.println("NIF:");
                String nif = scanner.nextLine();
                System.out.println("Nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Apellido1:");
                String ape1 = scanner.nextLine();
                System.out.println("Apellido2:");
                String ape2 = scanner.nextLine();
                System.out.println("Fecha nacimiento (dd/MM/yyyy):");
                LocalDate fechaNac = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Código postal:");
                String cp = scanner.nextLine();
                System.out.println("Localidad:");
                String loc = scanner.nextLine();
                System.out.println("Provincia:");
                String prov = scanner.nextLine();
                Direccion dir = new Direccion(1, TipoVia.CALLE, "Principal", 1, "", cp, loc, new Provincia(prov));
                tomador = new Persona(1, nombre, ape1, ape2, nif, fechaNac, dir, Sexo.otro, "España", "", "");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Intenta de nuevo.");
            }
        }

        // Conductor principal
        System.out.println("¿Conductor principal es el tomador? (s/n):");
        Conductor conductor = null;
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            conductor = new Conductor(tomador.getId(), tomador.getNombre(), tomador.getApellido1(), tomador.getApellido2(),
                    tomador.getNif(), tomador.getFechaNacimiento(), tomador.getDireccion(), LocalDate.now().minusYears(5), 12, 5);
        } else {
            // Similar al tomador, pero separado (omitido por brevedad, implementar si necesario)
        }

        // Conductores ocasionales
        ArrayList<Conductor> ocasionales = new ArrayList<>();
        System.out.println("¿Conductor adicional? (s/n):");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            // Similar al tomador, añadir a la lista (omitido por brevedad)
        }

        // Cotización
        System.out.println("¿Parking privado? (s/n):");
        boolean parking = scanner.nextLine().equalsIgnoreCase("s");
        System.out.println("Siniestros en 5 años:");
        int siniestros = Integer.parseInt(scanner.nextLine());
        Cotizacion cot = new Cotizacion(1, 1003, LocalDate.now(), LocalDate.now().plusDays(1), vehiculo, tomador, conductor,
                ocasionales, parking, siniestros, 0, 0, 0, Cotizacion.Modalidad.TERC);
        UtilidadesTarifa.calcularTodasLasTarifas(cot);

        // Mostrar opciones
        System.out.println("1. Terceros: " + cot.getPrecioTERC());
        System.out.println("2. Terceros Ampliado: " + cot.getPrecioTAMP());
        System.out.println("3. Todo Riesgo: " + cot.getPrecioTRIE());
        System.out.println("Elige (1-3) o 0 para cancelar:");
        int eleccion = Integer.parseInt(scanner.nextLine());
        if (eleccion == 0) {
            System.out.println("Cancelado.");
            return;
        }
        cot.setModalidadElegida(eleccion == 1 ? Cotizacion.Modalidad.TERC : eleccion == 2 ? Cotizacion.Modalidad.TAMP : Cotizacion.Modalidad.TRIE);

        // Pago
        System.out.println("Pago (1: IBAN, 2: Tarjeta):");
        AnualidadPoliza.ModoPago modo = Integer.parseInt(scanner.nextLine()) == 1 ? AnualidadPoliza.ModoPago.IBAN : AnualidadPoliza.ModoPago.TARJETA;
        System.out.println("¿Fraccionado? (s/n):");
        boolean fracc = scanner.nextLine().equalsIgnoreCase("s");
        double precioFinal = fracc ? UtilidadesTarifa.calcularTarifa(cot) * 1.05 : UtilidadesTarifa.calcularTarifa(cot);

        // Crear póliza
        AnualidadPoliza anualidad = new AnualidadPoliza(1, "DEF/2025/000003", AnualidadPoliza.EstadoPoliza.VIGENTE, null,
                cot, modo, fracc, tomador, conductor, ocasionales, UtilidadesTarifa.calcularTarifa(cot), precioFinal,
                LocalDate.now(), LocalDate.now().plusYears(1), null);
        Poliza poliza = new Poliza(1, "DEF/2025/000003", Collections.singletonList(anualidad), Poliza.EstadoPoliza.VIGENTE,
                null, cot, tomador, conductor, ocasionales, UtilidadesTarifa.calcularTarifa(cot), precioFinal,
                LocalDate.now(), LocalDate.now().plusYears(1), null);

        // Resumen
        System.out.println("Póliza contratada:");
        System.out.println("Número: " + poliza.getNumero());
        System.out.println("Tomador: " + poliza.getTomador().getNombre() + " " + poliza.getTomador().getApellido1());
        System.out.println("Vehículo: " + poliza.getUltimaCotizacionBase().getVehiculo().getMatricula());
        System.out.println("Modalidad: " + poliza.getUltimaCotizacionBase().getModalidadElegida());
        System.out.println("Precio final: " + poliza.getPrecioFinal());

        scanner.close();
    }
}