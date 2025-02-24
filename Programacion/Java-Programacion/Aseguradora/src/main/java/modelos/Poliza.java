package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    //Setters y Getters


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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return id == poliza.id && Double.compare(precioModalidad, poliza.precioModalidad) == 0 && Double.compare(precioFinal, poliza.precioFinal) == 0 && Objects.equals(numero, poliza.numero) && Objects.equals(anualidades, poliza.anualidades) && estadoPoliza == poliza.estadoPoliza && Objects.equals(motivoAnulacion, poliza.motivoAnulacion) && Objects.equals(ultimaCotizacionBase, poliza.ultimaCotizacionBase) && Objects.equals(tomador, poliza.tomador) && Objects.equals(conductorPrincipal, poliza.conductorPrincipal) && Objects.equals(conductoresOcasionales, poliza.conductoresOcasionales) && Objects.equals(fechaInicioAnualidad, poliza.fechaInicioAnualidad) && Objects.equals(fechaFinAnualidad, poliza.fechaFinAnualidad) && Objects.equals(fechaAnulacion, poliza.fechaAnulacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, anualidades, estadoPoliza, motivoAnulacion, ultimaCotizacionBase, tomador, conductorPrincipal, conductoresOcasionales, precioModalidad, precioFinal, fechaInicioAnualidad, fechaFinAnualidad, fechaAnulacion);
    }
}
