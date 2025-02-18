package modelos;

import java.time.LocalDate;
import java.util.List;

public class AnualidadPoliza {

    //Propiedades
    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    public enum ModoPago {
        IBAN, TARJETA
    }
    private int id;
    private String numero;
    private EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion cotizacionBase;
    private ModoPago modoPago;
    private boolean esPagoFraccionado;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;

}
