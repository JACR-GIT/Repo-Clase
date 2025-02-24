package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Poliza {

    // ==================== ENUMERACIONES ====================

    /**
     * Enumeración que representa los estados posibles de una póliza.
     */
    public enum EstadoPoliza {
        VIGENTE, ANULADA, VENCIDA
    }

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la póliza.
    private String numero; // Número de la póliza.
    private List<AnualidadPoliza> anualidades; // Lista de anualidades asociadas a la póliza.
    private EstadoPoliza estadoPoliza; // Estado actual de la póliza.
    private String motivoAnulacion; // Motivo de anulación de la póliza (si está anulada).
    private Cotizacion ultimaCotizacionBase; // Última cotización base asociada a la póliza.
    private Persona tomador; // Tomador de la póliza (persona que contrata el seguro).
    private Conductor conductorPrincipal; // Conductor principal asociado a la póliza.
    private List<Conductor> conductoresOcasionales; // Lista de conductores ocasionales asociados a la póliza.
    private double precioModalidad; // Precio de la modalidad de seguro seleccionada.
    private double precioFinal; // Precio final de la póliza (incluyendo posibles ajustes).
    private LocalDate fechaInicioAnualidad; // Fecha de inicio de la anualidad.
    private LocalDate fechaFinAnualidad; // Fecha de fin de la anualidad.
    private LocalDate fechaAnulacion; // Fecha de anulación de la póliza (si está anulada).

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una póliza con todos los atributos.
     *
     * @param id                   Identificador único de la póliza.
     * @param numero               Número de la póliza.
     * @param anualidades          Lista de anualidades asociadas a la póliza.
     * @param estadoPoliza         Estado actual de la póliza.
     * @param motivoAnulacion      Motivo de anulación de la póliza (si está anulada).
     * @param ultimaCotizacionBase Última cotización base asociada a la póliza.
     * @param tomador              Tomador de la póliza (persona que contrata el seguro).
     * @param conductorPrincipal   Conductor principal asociado a la póliza.
     * @param conductoresOcasionales Lista de conductores ocasionales asociados a la póliza.
     * @param precioModalidad      Precio de la modalidad de seguro seleccionada.
     * @param precioFinal          Precio final de la póliza (incluyendo posibles ajustes).
     * @param fechaInicioAnualidad Fecha de inicio de la anualidad.
     * @param fechaFinAnualidad    Fecha de fin de la anualidad.
     * @param fechaAnulacion       Fecha de anulación de la póliza (si está anulada).
     */
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

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
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

    /**
     * Constructor de copia.
     * Crea una nueva póliza a partir de otra existente.
     *
     * @param poliza2 Póliza de la cual se copiarán los atributos.
     */
    public Poliza(Poliza poliza2) {
        this.id = poliza2.id;
        this.numero = poliza2.numero;
        this.anualidades = new ArrayList<>(poliza2.anualidades); // Copia profunda de la lista de anualidades.
        this.estadoPoliza = poliza2.estadoPoliza;
        this.motivoAnulacion = poliza2.motivoAnulacion;
        this.ultimaCotizacionBase = new Cotizacion(poliza2.ultimaCotizacionBase); // Copia profunda de la cotización.
        this.tomador = new Persona(poliza2.tomador); // Copia profunda del tomador.
        this.conductorPrincipal = new Conductor(poliza2.conductorPrincipal); // Copia profunda del conductor principal.
        this.conductoresOcasionales = new ArrayList<>(poliza2.conductoresOcasionales); // Copia profunda de la lista de conductores ocasionales.
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

    // ==================== MÉTODOS ====================

    /**
     * Compara si dos pólizas son iguales basándose en su identificador único (id).
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return id == poliza.id;
    }

    /**
     * Devuelve el código hash de la póliza basado en su identificador único (id).
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de la póliza.
     *
     * @return Cadena que representa la póliza.
     */
    @Override
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