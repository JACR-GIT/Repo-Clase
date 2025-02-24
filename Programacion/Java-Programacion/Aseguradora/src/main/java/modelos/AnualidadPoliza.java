package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnualidadPoliza {

    // ==================== ENUMERACIONES ====================

    /**
     * Enumeración que representa los estados posibles de una anualidad de póliza.
     */
    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    /**
     * Enumeración que representa los modos de pago disponibles para una anualidad de póliza.
     */
    public enum ModoPago {
        IBAN, TARJETA
    }

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la anualidad de póliza.
    private String numero; // Número de la anualidad de póliza.
    private EstadoPoliza estadoPoliza; // Estado actual de la anualidad de póliza.
    private String motivoAnulacion; // Motivo de anulación de la anualidad de póliza (si está anulada).
    private Cotizacion cotizacionBase; // Cotización base asociada a la anualidad de póliza.
    private ModoPago modoPago; // Modo de pago seleccionado para la anualidad de póliza.
    private boolean esPagoFraccionado; // Indica si el pago de la anualidad es fraccionado.
    private Persona tomador; // Tomador de la póliza (persona que contrata el seguro).
    private Conductor conductorPrincipal; // Conductor principal asociado a la anualidad de póliza.
    private List<Conductor> conductoresOcasionales; // Lista de conductores ocasionales asociados a la anualidad de póliza.
    private double precioModalidad; // Precio de la modalidad de seguro seleccionada.
    private double precioFinal; // Precio final de la anualidad de póliza (incluyendo posibles ajustes).
    private LocalDate fechaInicioAnualidad; // Fecha de inicio de la anualidad.
    private LocalDate fechaFinAnualidad; // Fecha de fin de la anualidad.
    private LocalDate fechaAnulacion; // Fecha de anulación de la anualidad de póliza (si está anulada).

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una anualidad de póliza con todos los atributos.
     *
     * @param id                   Identificador único de la anualidad de póliza.
     * @param numero               Número de la anualidad de póliza.
     * @param estadoPoliza         Estado actual de la anualidad de póliza.
     * @param motivoAnulacion      Motivo de anulación de la anualidad de póliza (si está anulada).
     * @param cotizacionBase       Cotización base asociada a la anualidad de póliza.
     * @param modoPago             Modo de pago seleccionado para la anualidad de póliza.
     * @param esPagoFraccionado    Indica si el pago de la anualidad es fraccionado.
     * @param tomador              Tomador de la póliza (persona que contrata el seguro).
     * @param conductorPrincipal   Conductor principal asociado a la anualidad de póliza.
     * @param conductoresOcasionales Lista de conductores ocasionales asociados a la anualidad de póliza.
     * @param precioModalidad      Precio de la modalidad de seguro seleccionada.
     * @param precioFinal          Precio final de la anualidad de póliza (incluyendo posibles ajustes).
     * @param fechaInicioAnualidad Fecha de inicio de la anualidad.
     * @param fechaFinAnualidad    Fecha de fin de la anualidad.
     * @param fechaAnulacion       Fecha de anulación de la anualidad de póliza (si está anulada).
     */
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

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
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

    /**
     * Constructor de copia.
     * Crea una nueva anualidad de póliza a partir de otra existente.
     *
     * @param anualidadPoliza2 Anualidad de póliza de la cual se copiarán los atributos.
     */
    public AnualidadPoliza(AnualidadPoliza anualidadPoliza2) {
        this.id = anualidadPoliza2.id;
        this.numero = anualidadPoliza2.numero;
        this.estadoPoliza = anualidadPoliza2.estadoPoliza;
        this.motivoAnulacion = anualidadPoliza2.motivoAnulacion;
        this.cotizacionBase = new Cotizacion(anualidadPoliza2.cotizacionBase); // Copia profunda de la cotización.
        this.modoPago = anualidadPoliza2.modoPago;
        this.esPagoFraccionado = anualidadPoliza2.esPagoFraccionado;
        this.tomador = new Persona(anualidadPoliza2.tomador); // Copia profunda del tomador.
        this.conductorPrincipal = new Conductor(anualidadPoliza2.conductorPrincipal); // Copia profunda del conductor principal.
        this.conductoresOcasionales = new ArrayList<>(anualidadPoliza2.conductoresOcasionales); // Copia profunda de la lista de conductores ocasionales.
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

    /**
     * Compara si dos anualidades de póliza son iguales basándose en su identificador único (id).
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AnualidadPoliza that = (AnualidadPoliza) o;
        return id == that.id;
    }

    /**
     * Devuelve el código hash de la anualidad de póliza basado en su identificador único (id).
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de la anualidad de póliza.
     *
     * @return Cadena que representa la anualidad de póliza.
     */
    @Override
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