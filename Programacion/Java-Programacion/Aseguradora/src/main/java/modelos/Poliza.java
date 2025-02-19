package modelos;

import java.time.LocalDate;
import java.util.List;

public class Poliza {

    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    // Propiedades
    private int id;
    private String numero;
    private List<AnualidadPoliza> anualidades;
    private EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion ultimaCotizacionBase;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;
}
