import modelos.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PruebaContratacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos del vehículo
        System.out.println("Ingrese los datos del vehículo:");
        System.out.print("Tipo (Coche/Moto): ");
        String tipoVehiculo = scanner.nextLine();
        Vehiculo vehiculo;
        if (tipoVehiculo.equalsIgnoreCase("Coche")) {
            vehiculo = new Coche();
        } else {
            vehiculo = new Moto();
        }
        // Rellenar otros datos del vehículo...

        // Solicitar datos del tomador
        System.out.println("Ingrese los datos del tomador:");
        System.out.print("Nombre: ");
        String nombreTomador = scanner.nextLine();
        System.out.print("NIF: ");
        String nifTomador = scanner.nextLine();
        // Rellenar otros datos del tomador...

        Persona tomador = new Persona(nombreTomador, nifTomador, new Direccion());

        // Solicitar datos del conductor principal
        System.out.println("Ingrese los datos del conductor principal (o 'mismo' si es el mismo que el tomador):");
        System.out.print("Nombre: ");
        String nombreConductor = scanner.nextLine();
        Persona conductorPrincipal;
        if (nombreConductor.equalsIgnoreCase("mismo")) {
            conductorPrincipal = tomador;
        } else {
            System.out.print("NIF: ");
            String nifConductor = scanner.nextLine();
            conductorPrincipal = new Persona(nombreConductor, nifConductor, new Direccion());
        }

        // Solicitar datos de conductores adicionales
        System.out.println("¿Hay conductores adicionales? (si/no): ");
        String hayConductoresAdicionales = scanner.nextLine();
        List<Conductor> conductoresOcasionales = new ArrayList<>();
        if (hayConductoresAdicionales.equalsIgnoreCase("si")) {
            System.out.print("Nombre del conductor adicional: ");
            String nombreConductorAdicional = scanner.nextLine();
            System.out.print("NIF del conductor adicional: ");
            String nifConductorAdicional = scanner.nextLine();
            conductoresOcasionales.add(new Conductor(nombreConductorAdicional, nifConductorAdicional, new Direccion()));
        }

        // Crear la cotización y la póliza
        Cotizacion cotizacion = new Cotizacion();
        // Rellenar otros datos de la cotización...

        Poliza poliza = new Poliza();
        poliza.setTomador(tomador);
        poliza.setConductorPrincipal(conductorPrincipal);
        poliza.setConductoresOcasionales(conductoresOcasionales);
        poliza.setUltimaCotizacionBase(cotizacion);

        // Mostrar resumen de la póliza
        System.out.println("Resumen de la póliza:");
        System.out.println(poliza);

        scanner.close();
    }
}