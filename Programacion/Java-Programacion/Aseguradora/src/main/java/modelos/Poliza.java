package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Poliza {

    // ==================== ENUMERACIONES ====================


    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    // ==================== PROPIEDADES O VARIABLES ====================

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

    // ==================== CONSTRUCTORES ====================

    public Poliza(int id, String numero, List<AnualidadPoliza> anualidades, EstadoPoliza estadoPoliza, String motivoAnulacion,
                  Cotizacion ultimaCotizacionBase, Persona tomador, Conductor conductorPrincipal,
                  List<Conductor> conductoresOcasionales, double precioModalidad, double precioFinal,
                  LocalDate fechaInicioAnualidad, LocalDate fechaFinAnualidad, LocalDate fechaAnulacion) {
        this.id = id;
        this.numero = numero;
        this.anualidades = anualidades;
        this.estadoPoliza = estadoPoliza;
        this.motivoAnulacion = motivoAnulacion;
        this.ultimaCotizacionBase = ultimaCotizacionBase;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.precioModalidad = precioModalidad;
        this.precioFinal = precioFinal;
        this.fechaInicioAnualidad = fechaInicioAnualidad;
        this.fechaFinAnualidad = fechaFinAnualidad;
        this.fechaAnulacion = fechaAnulacion;
    }

    public Poliza() {
        this.id = 0;
        this.numero = "";
        this.anualidades = new ArrayList<>();
        this.estadoPoliza = EstadoPoliza.VIGENTE;
        this.motivoAnulacion = "";
        this.ultimaCotizacionBase = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = new ArrayList<>();
        this.precioModalidad = 0.0;
        this.precioFinal = 0.0;
        this.fechaInicioAnualidad = LocalDate.now();
        this.fechaFinAnualidad = LocalDate.now().plusYears(1);
        this.fechaAnulacion = null;
    }

    public Poliza(Poliza poliza2) {
        this.id = poliza2.id;
        this.numero = poliza2.numero;
        this.anualidades = new ArrayList<>(poliza2.anualidades);
        this.estadoPoliza = poliza2.estadoPoliza;
        this.motivoAnulacion = poliza2.motivoAnulacion;
        this.ultimaCotizacionBase = new Cotizacion(poliza2.ultimaCotizacionBase);
        this.tomador = new Persona(poliza2.tomador);
        this.conductorPrincipal = new Conductor(poliza2.conductorPrincipal);
        this.conductoresOcasionales = new ArrayList<>(poliza2.conductoresOcasionales);
        this.precioModalidad = poliza2.precioModalidad;
        this.precioFinal = poliza2.precioFinal;
        this.fechaInicioAnualidad = poliza2.fechaInicioAnualidad;
        this.fechaFinAnualidad = poliza2.fechaFinAnualidad;
        this.fechaAnulacion = poliza2.fechaAnulacion;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<AnualidadPoliza> getAnualidades() {
        return anualidades;
    }

    public void setAnualidades(List<AnualidadPoliza> anualidades) {
        this.anualidades = anualidades;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public Cotizacion getUltimaCotizacionBase() {
        return ultimaCotizacionBase;
    }

    public void setUltimaCotizacionBase(Cotizacion ultimaCotizacionBase) {
        this.ultimaCotizacionBase = ultimaCotizacionBase;
    }

    public Persona getTomador() {
        return tomador;
    }

    public void setTomador(Persona tomador) {
        this.tomador = tomador;
    }

    public Conductor getConductorPrincipal() {
        return conductorPrincipal;
    }

    public void setConductorPrincipal(Conductor conductorPrincipal) {
        this.conductorPrincipal = conductorPrincipal;
    }

    public List<Conductor> getConductoresOcasionales() {
        return conductoresOcasionales;
    }

    public void setConductoresOcasionales(List<Conductor> conductoresOcasionales) {
        this.conductoresOcasionales = conductoresOcasionales;
    }

    public double getPrecioModalidad() {
        return precioModalidad;
    }

    public void setPrecioModalidad(double precioModalidad) {
        this.precioModalidad = precioModalidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public LocalDate getFechaInicioAnualidad() {
        return fechaInicioAnualidad;
    }

    public void setFechaInicioAnualidad(LocalDate fechaInicioAnualidad) {
        this.fechaInicioAnualidad = fechaInicioAnualidad;
    }

    public LocalDate getFechaFinAnualidad() {
        return fechaFinAnualidad;
    }

    public void setFechaFinAnualidad(LocalDate fechaFinAnualidad) {
        this.fechaFinAnualidad = fechaFinAnualidad;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return id == poliza.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "Poliza{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", estadoPoliza=" + estadoPoliza +
                ", motivoAnulacion='" + motivoAnulacion + '\'' +
                ", precioModalidad=" + precioModalidad +
                ", precioFinal=" + precioFinal +
                ", fechaInicioAnualidad=" + fechaInicioAnualidad +
                ", fechaFinAnualidad=" + fechaFinAnualidad +
                ", fechaAnulacion=" + fechaAnulacion +
                '}';
    }
}