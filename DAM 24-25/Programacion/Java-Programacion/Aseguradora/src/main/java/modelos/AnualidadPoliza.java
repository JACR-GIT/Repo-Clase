package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnualidadPoliza {

    // ==================== ENUMERACIONES ====================

    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    public enum ModoPago {
        IBAN, TARJETA
    }

    // ==================== PROPIEDADES O VARIABLES ====================

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

    // ==================== CONSTRUCTORES ====================

    public AnualidadPoliza(int id, String numero, EstadoPoliza estadoPoliza, String motivoAnulacion,
                           Cotizacion cotizacionBase, ModoPago modoPago, boolean esPagoFraccionado,
                           Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales,
                           double precioModalidad, double precioFinal, LocalDate fechaInicioAnualidad,
                           LocalDate fechaFinAnualidad, LocalDate fechaAnulacion) {
        this.id = id;
        this.numero = numero;
        this.estadoPoliza = estadoPoliza;
        this.motivoAnulacion = motivoAnulacion;
        this.cotizacionBase = cotizacionBase;
        this.modoPago = modoPago;
        this.esPagoFraccionado = esPagoFraccionado;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.precioModalidad = precioModalidad;
        this.precioFinal = precioFinal;
        this.fechaInicioAnualidad = fechaInicioAnualidad;
        this.fechaFinAnualidad = fechaFinAnualidad;
        this.fechaAnulacion = fechaAnulacion;
    }

    public AnualidadPoliza() {
        this.id = 0;
        this.numero = "";
        this.estadoPoliza = EstadoPoliza.VIGENTE;
        this.motivoAnulacion = "";
        this.cotizacionBase = null;
        this.modoPago = ModoPago.IBAN;
        this.esPagoFraccionado = false;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = new ArrayList<>();
        this.precioModalidad = 0.0;
        this.precioFinal = 0.0;
        this.fechaInicioAnualidad = LocalDate.now();
        this.fechaFinAnualidad = LocalDate.now().plusYears(1);
        this.fechaAnulacion = null;
    }

    public AnualidadPoliza(AnualidadPoliza anualidadPoliza2) {
        this.id = anualidadPoliza2.id;
        this.numero = anualidadPoliza2.numero;
        this.estadoPoliza = anualidadPoliza2.estadoPoliza;
        this.motivoAnulacion = anualidadPoliza2.motivoAnulacion;
        this.cotizacionBase = new Cotizacion(anualidadPoliza2.cotizacionBase);
        this.modoPago = anualidadPoliza2.modoPago;
        this.esPagoFraccionado = anualidadPoliza2.esPagoFraccionado;
        this.tomador = new Persona(anualidadPoliza2.tomador);
        this.conductorPrincipal = new Conductor(anualidadPoliza2.conductorPrincipal);
        this.conductoresOcasionales = new ArrayList<>(anualidadPoliza2.conductoresOcasionales);
        this.precioModalidad = anualidadPoliza2.precioModalidad;
        this.precioFinal = anualidadPoliza2.precioFinal;
        this.fechaInicioAnualidad = anualidadPoliza2.fechaInicioAnualidad;
        this.fechaFinAnualidad = anualidadPoliza2.fechaFinAnualidad;
        this.fechaAnulacion = anualidadPoliza2.fechaAnulacion;
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

    public Cotizacion getCotizacionBase() {
        return cotizacionBase;
    }

    public void setCotizacionBase(Cotizacion cotizacionBase) {
        this.cotizacionBase = cotizacionBase;
    }

    public ModoPago getModoPago() {
        return modoPago;
    }

    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }

    public boolean isEsPagoFraccionado() {
        return esPagoFraccionado;
    }

    public void setEsPagoFraccionado(boolean esPagoFraccionado) {
        this.esPagoFraccionado = esPagoFraccionado;
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

    // ==================== MÉTODOS ====================

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AnualidadPoliza that = (AnualidadPoliza) o;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "AnualidadPoliza{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", estadoPoliza=" + estadoPoliza +
                ", motivoAnulacion='" + motivoAnulacion + '\'' +
                ", modoPago=" + modoPago +
                ", esPagoFraccionado=" + esPagoFraccionado +
                ", precioModalidad=" + precioModalidad +
                ", precioFinal=" + precioFinal +
                ", fechaInicioAnualidad=" + fechaInicioAnualidad +
                ", fechaFinAnualidad=" + fechaFinAnualidad +
                ", fechaAnulacion=" + fechaAnulacion +
                '}';
    }
}