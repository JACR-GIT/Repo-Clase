import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;
import utilidades.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PruebaContratacion {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static void main(String[] args) {
        System.out.println("=== SIMULACIÓN DE CONTRATACIÓN DE PÓLIZA ===");
        SoporteVehiculos soporte = SoporteVehiculos.getInstance();

        // Crear objetos necesarios
        Vehiculo vehiculo = crearVehiculo();
        Persona tomador = crearTomador();
        Conductor conductorPrincipal = crearConductor(tomador);
        List<Conductor> conductoresOcasionales = crearConductoresOcasionales();
        Cotizacion cotizacion = crearCotizacion(vehiculo, tomador, conductorPrincipal, conductoresOcasionales);

        // Calcular y mostrar tarifas
        UtilidadesTarifa.calcularTodasLasTarifas(cotizacion);
        mostrarOpcionesCotizacion(cotizacion);

        // Elegir modalidad
        Cotizacion.Modalidad modalidadElegida = elegirModalidad();
        if (modalidadElegida == null) {
            System.out.println("Contratación cancelada por el usuario.");
            return;
        }
        cotizacion.setModalidadElegida(modalidadElegida);

        // Crear anualidad y póliza
        AnualidadPoliza anualidad = crearAnualidad(cotizacion);
        Poliza poliza = crearPoliza(anualidad, cotizacion);

        // Mostrar resumen
        mostrarResumen(poliza);

        scanner.close();
    }

    private static Vehiculo crearVehiculo() {
        while (true) {
            try {
                System.out.println("\n=== Datos del Vehículo ===");
                System.out.print("¿Coche (1) o Moto (2)? ");
                int tipo = Integer.parseInt(scanner.nextLine());

                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                if (!UtilidadesVehiculo.validarMarca(marca)) throw new IllegalArgumentException("Marca no válida");

                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                if (!UtilidadesVehiculo.validarModelo(marca, modelo)) throw new IllegalArgumentException("Modelo no válido");

                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine();
                if (!UtilidadesVehiculo.esMatriculaValida(matricula)) throw new IllegalArgumentException("Matrícula no válida");

                System.out.print("Fecha de matriculación (yyyy/MM/dd): ");
                LocalDate fechaMatriculacion = LocalDate.parse(scanner.nextLine(), formatter);
                if (!UtilidadesVehiculo.validaFechaMatriculacion(fechaMatriculacion)) throw new IllegalArgumentException("Fecha de matriculación inválida");

                System.out.print("Color: ");
                String color = scanner.nextLine();

                if (tipo == 1) {
                    System.out.print("Número de puertas: ");
                    int puertas = Integer.parseInt(scanner.nextLine());
                    System.out.print("Combustible (GASOLINA/DIESEL/ELECTRICO/HIBRIDO): ");
                    TipoCombustible combustible = TipoCombustible.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Tracción (DELANTERA/TRASERA/INTEGRAL): ");
                    TipoTraccion traccion = TipoTraccion.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("¿Es todoterreno? (s/n): ");
                    boolean esTodoTerreno = scanner.nextLine().equalsIgnoreCase("s");

                    return new Coche(1, marca, modelo, matricula, fechaMatriculacion, color, null, puertas, combustible, traccion, esTodoTerreno);
                } else if (tipo == 2) {
                    System.out.print("Cilindrada (CC): ");
                    int cc = Integer.parseInt(scanner.nextLine());
                    System.out.print("¿Tiene sidecar? (s/n): ");
                    boolean sidecar = scanner.nextLine().equalsIgnoreCase("s");

                    return new Moto(1, marca, modelo, matricula, fechaMatriculacion, color, null, cc, sidecar);
                } else {
                    System.out.println("Tipo de vehículo no válido.");
                }
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static Persona crearTomador() {
        while (true) {
            try {
                System.out.println("\n=== Datos del Tomador ===");
                System.out.print("NIF: ");
                String nif = scanner.nextLine();
                if (!UtilidadesPersonas.esNIFValido(nif)) throw new IllegalArgumentException("NIF no válido");

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Primer apellido: ");
                String ape1 = scanner.nextLine();
                System.out.print("Segundo apellido: ");
                String ape2 = scanner.nextLine();
                System.out.print("Fecha de nacimiento (yyyy/MM/dd): ");
                LocalDate fechaNac = LocalDate.parse(scanner.nextLine(), formatter);

                Direccion direccion = crearDireccion();
                return new Persona(1, nombre, ape1, ape2, nif, fechaNac, direccion, Sexo.otro, "España", "", "");
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static Direccion crearDireccion() {
        while (true) {
            try {
                System.out.println("\n=== Dirección del Tomador ===");
                System.out.print("Tipo de vía (CALLE/AVENIDA/PLAZA, etc.): ");
                TipoVia tipoVia = TipoVia.valueOf(scanner.nextLine().toUpperCase());
                System.out.print("Nombre de la vía: ");
                String nombreVia = scanner.nextLine();
                System.out.print("Número: ");
                int numero = Integer.parseInt(scanner.nextLine());
                System.out.print("Resto (piso, puerta, etc.): ");
                String resto = scanner.nextLine();
                System.out.print("Código postal: ");
                String cp = scanner.nextLine();
                if (!UtilidadesDireccion.esCPValido(cp)) throw new IllegalArgumentException("Código postal no válido");
                System.out.print("Localidad: ");
                String localidad = scanner.nextLine();
                System.out.print("Provincia: ");
                String provincia = scanner.nextLine();
                String codProvincia = UtilidadesDireccion.obtenerCodigoProvincia(provincia);
                if (codProvincia == null) throw new IllegalArgumentException("Provincia no válida");

                return new Direccion(1, tipoVia, nombreVia, numero, resto, cp, localidad, new Provincia(codProvincia, provincia));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static Conductor crearConductor(Persona tomador) {
        while (true) {
            try {
                System.out.println("\n=== Conductor Principal ===");
                System.out.print("¿Es el mismo que el tomador? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.print("Fecha del carnet (yyyy/MM/dd): ");
                    LocalDate fechaCarnet = LocalDate.parse(scanner.nextLine(), formatter);
                    return new Conductor(tomador.getId(), tomador.getNombre(), tomador.getApellido1(), tomador.getApellido2(),
                            tomador.getNif(), tomador.getFechaNacimiento(), tomador.getDireccion(), fechaCarnet, 12, 5);
                } else {
                    Persona conductor = crearTomador(); // Reutilizamos para crear una persona distinta
                    System.out.print("Fecha del carnet (yyyy/MM/dd): ");
                    LocalDate fechaCarnet = LocalDate.parse(scanner.nextLine(), formatter);
                    return new Conductor(conductor.getId(), conductor.getNombre(), conductor.getApellido1(), conductor.getApellido2(),
                            conductor.getNif(), conductor.getFechaNacimiento(), conductor.getDireccion(), fechaCarnet, 12, 0);
                }
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static List<Conductor> crearConductoresOcasionales() {
        List<Conductor> ocasionales = new ArrayList<>();
        System.out.print("\n¿Añadir conductor ocasional? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            Conductor ocasional = crearConductor(null); // Null para no vincular al tomador
            ocasionales.add(ocasional);
        }
        return ocasionales;
    }

    private static Cotizacion crearCotizacion(Vehiculo vehiculo, Persona tomador, Conductor conductor, List<Conductor> ocasionales) {
        while (true) {
            try {
                System.out.println("\n=== Datos de la Cotización ===");
                System.out.print("Fecha de inicio (yyyy/MM/dd): ");
                LocalDate fechaInicio = LocalDate.parse(scanner.nextLine(), formatter);
                System.out.print("¿Tiene parking privado? (s/n): ");
                boolean parking = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("Número de siniestros en los últimos 5 años: ");
                int siniestros = Integer.parseInt(scanner.nextLine());

                return new Cotizacion(1, 1003, LocalDate.now(), fechaInicio, vehiculo, tomador, conductor,
                        ocasionales, parking, siniestros, 0, 0, 0, Cotizacion.Modalidad.TERC);
            } catch (DateTimeParseException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static void mostrarOpcionesCotizacion(Cotizacion cotizacion) {
        System.out.println("\n=== Opciones de Seguro ===");
        System.out.printf("1. Terceros (TERC): %.2f€%n", cotizacion.getPrecioTERC());
        System.out.printf("2. Terceros Ampliado (TAMP): %.2f€%n", cotizacion.getPrecioTAMP());
        System.out.printf("3. Todo Riesgo (TRIE): %.2f€%n", cotizacion.getPrecioTRIE());
    }

    private static Cotizacion.Modalidad elegirModalidad() {
        while (true) {
            try {
                System.out.print("\nElija una opción (1-3) o 0 para cancelar: ");
                int eleccion = Integer.parseInt(scanner.nextLine());
                switch (eleccion) {
                    case 0: return null;
                    case 1: return Cotizacion.Modalidad.TERC;
                    case 2: return Cotizacion.Modalidad.TAMP;
                    case 3: return Cotizacion.Modalidad.TRIE;
                    default: System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número válido.");
            }
        }
    }

    private static AnualidadPoliza crearAnualidad(Cotizacion cotizacion) {
        while (true) {
            try {
                System.out.println("\n=== Pago de la Anualidad ===");
                System.out.print("Método de pago (1: IBAN, 2: TARJETA): ");
                int modoInt = Integer.parseInt(scanner.nextLine());
                AnualidadPoliza.ModoPago modo = (modoInt == 1) ? AnualidadPoliza.ModoPago.IBAN : AnualidadPoliza.ModoPago.TARJETA;
                System.out.print("¿Fraccionado? (s/n): ");
                boolean fraccionado = scanner.nextLine().equalsIgnoreCase("s");
                double precioBase = UtilidadesTarifa.calcularTarifa(cotizacion);
                double precioFinal = fraccionado ? precioBase * 1.05 : precioBase;

                return new AnualidadPoliza(1, "DEF/2025/000003", AnualidadPoliza.EstadoPoliza.VIGENTE, null, cotizacion,
                        modo, fraccionado, cotizacion.getTomador(), cotizacion.getConductorPrincipal(),
                        cotizacion.getConductoresOcasionales(), precioBase, precioFinal, LocalDate.now(), LocalDate.now().plusYears(1), null);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Por favor, intenta de nuevo.");
            }
        }
    }

    private static Poliza crearPoliza(AnualidadPoliza anualidad, Cotizacion cotizacion) {
        return new Poliza(1, "DEF/2025/000003", Collections.singletonList(anualidad), Poliza.EstadoPoliza.VIGENTE,
                null, cotizacion, cotizacion.getTomador(), cotizacion.getConductorPrincipal(),
                cotizacion.getConductoresOcasionales(), anualidad.getPrecioModalidad(), anualidad.getPrecioFinal(),
                LocalDate.now(), LocalDate.now().plusYears(1), null);
    }

    private static void mostrarResumen(Poliza poliza) {
        System.out.println("\n=== Resumen de la Póliza ===");
        System.out.println("Número: " + poliza.getNumero());
        System.out.println("Estado: " + poliza.getEstadoPoliza());
        System.out.println("Tomador: " + poliza.getTomador().getNombre() + " " + poliza.getTomador().getApellido1());
        System.out.println("Vehículo: " + poliza.getUltimaCotizacionBase().getVehiculo().getMarca() + " " + poliza.getUltimaCotizacionBase().getVehiculo().getModelo());
        System.out.println("Modalidad: " + poliza.getUltimaCotizacionBase().getModalidadElegida());
        System.out.printf("Precio final: %.2f€%n", poliza.getPrecioFinal());
        System.out.println("Fecha de inicio: " + poliza.getFechaInicioAnualidad());
        System.out.println("Fecha de fin: " + poliza.getFechaFinAnualidad());
        System.out.println("Método de pago: " + poliza.getAnualidades().get(0).getModoPago());
        System.out.println("Fraccionado: " + (poliza.getAnualidades().get(0).isEsPagoFraccionado() ? "Sí" : "No"));
        System.out.println("¡Póliza contratada con éxito!");
    }
}