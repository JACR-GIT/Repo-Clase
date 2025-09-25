package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cotizacion {

    // ==================== ENUMERACIONES ====================

    public enum Modalidad {
        TERC,
        TAMP,
        TRIE
    }

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id;
    private int codigo;
    private LocalDate fechaCotizacion;
    private LocalDate fechaInicio;
    private Vehiculo vehiculo;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private boolean tieneAparcamientoPrivado;
    private int numSini5;
    private double precioTERC;
    private double precioTAMP;
    private double precioTRIE;
    private Modalidad modalidadElegida;

    // ==================== CONSTRUCTORES ====================

    public Cotizacion(int id, int codigo, LocalDate fechaCotizacion, LocalDate fechaInicio, Vehiculo vehiculo,
                      Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales,
                      boolean tieneAparcamientoPrivado, int numSini5, double precioTERC, double precioTAMP,
                      double precioTRIE, Modalidad modalidadElegida) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCotizacion = fechaCotizacion;
        this.fechaInicio = fechaInicio;
        this.vehiculo = vehiculo;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.tieneAparcamientoPrivado = tieneAparcamientoPrivado;
        this.numSini5 = numSini5;
        this.precioTERC = precioTERC;
        this.precioTAMP = precioTAMP;
        this.precioTRIE = precioTRIE;
        this.modalidadElegida = modalidadElegida;
    }

    public Cotizacion() {
        this.id = 0;
        this.codigo = 0;
        this.fechaCotizacion = LocalDate.now();
        this.fechaInicio = LocalDate.now();
        this.vehiculo = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = new ArrayList<>();
        this.tieneAparcamientoPrivado = false;
        this.numSini5 = 0;
        this.precioTERC = 0.0;
        this.precioTAMP = 0.0;
        this.precioTRIE = 0.0;
        this.modalidadElegida = Modalidad.TERC;
    }

    public Cotizacion(Cotizacion cotizacion2) {
        this.id = cotizacion2.id;
        this.codigo = cotizacion2.codigo;
        this.fechaCotizacion = cotizacion2.fechaCotizacion;
        this.fechaInicio = cotizacion2.fechaInicio;
        this.vehiculo = new Vehiculo(cotizacion2.vehiculo);
        this.tomador = new Persona(cotizacion2.tomador);
        this.conductorPrincipal = new Conductor(cotizacion2.conductorPrincipal);
        this.conductoresOcasionales = new ArrayList<>(cotizacion2.conductoresOcasionales);
        this.tieneAparcamientoPrivado = cotizacion2.tieneAparcamientoPrivado;
        this.numSini5 = cotizacion2.numSini5;
        this.precioTERC = cotizacion2.precioTERC;
        this.precioTAMP = cotizacion2.precioTAMP;
        this.precioTRIE = cotizacion2.precioTRIE;
        this.modalidadElegida = cotizacion2.modalidadElegida;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(LocalDate fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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

    public boolean isTieneAparcamientoPrivado() {
        return tieneAparcamientoPrivado;
    }

    public void setTieneAparcamientoPrivado(boolean tieneAparcamientoPrivado) {
        this.tieneAparcamientoPrivado = tieneAparcamientoPrivado;
    }

    public int getNumSini5() {
        return numSini5;
    }

    public void setNumSini5(int numSini5) {
        this.numSini5 = numSini5;
    }

    public double getPrecioTERC() {
        return precioTERC;
    }

    public void setPrecioTERC(double precioTERC) {
        this.precioTERC = precioTERC;
    }

    public double getPrecioTAMP() {
        return precioTAMP;
    }

    public void setPrecioTAMP(double precioTAMP) {
        this.precioTAMP = precioTAMP;
    }

    public double getPrecioTRIE() {
        return precioTRIE;
    }

    public void setPrecioTRIE(double precioTRIE) {
        this.precioTRIE = precioTRIE;
    }

    public Modalidad getModalidadElegida() {
        return modalidadElegida;
    }

    public void setModalidadElegida(Modalidad modalidadElegida) {
        this.modalidadElegida = modalidadElegida;
    }

    // ==================== MÉTODOS ====================

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cotizacion cotizacion = (Cotizacion) o;
        return id == cotizacion.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "Cotizacion{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", fechaCotizacion=" + fechaCotizacion +
                ", fechaInicio=" + fechaInicio +
                ", vehiculo=" + vehiculo +
                ", tomador=" + tomador +
                ", conductorPrincipal=" + conductorPrincipal +
                ", tieneAparcamientoPrivado=" + tieneAparcamientoPrivado +
                ", numSini5=" + numSini5 +
                ", precioTERC=" + precioTERC +
                ", precioTAMP=" + precioTAMP +
                ", precioTRIE=" + precioTRIE +
                ", modalidadElegida=" + modalidadElegida +
                '}';
    }
}