package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cotizacion {

    // ==================== ENUMERACIONES ====================

    public enum Modalidad {
        TERC, // Terceros básico.
        TAMP, // Terceros ampliado.
        TRIE  // Todo riesgo.
    }

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la cotización.
    private int codigo; // Código de la cotización (visible para el cliente).
    private LocalDate fechaCotizacion; // Fecha en la que se crea la cotización.
    private LocalDate fechaInicio; // Fecha en la que se inicia el seguro.
    private Vehiculo vehiculo; // Vehículo que se quiere asegurar.
    private Persona tomador; // Persona a nombre de quien estaría el seguro (el que paga).
    private Conductor conductorPrincipal; // Conductor principal del vehículo.
    private List<Conductor> conductoresOcasionales; // Lista de conductores ocasionales.
    private boolean tieneAparcamientoPrivado; // Indica si el vehículo tiene aparcamiento privado.
    private int numSini5; // Número de siniestros con culpa en los últimos 5 años.
    private double precioTERC; // Precio de la modalidad de terceros básico.
    private double precioTAMP; // Precio de la modalidad de terceros ampliado.
    private double precioTRIE; // Precio de la modalidad de todo riesgo.
    private Modalidad modalidadElegida; // Modalidad de seguro elegida por el cliente.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una cotización con todos los atributos.
     *
     * @param id                       Identificador único de la cotización.
     * @param codigo                   Código de la cotización (visible para el cliente).
     * @param fechaCotizacion          Fecha en la que se crea la cotización.
     * @param fechaInicio              Fecha en la que se inicia el seguro.
     * @param vehiculo                 Vehículo que se quiere asegurar.
     * @param tomador                  Persona a nombre de quien estaría el seguro (el que paga).
     * @param conductorPrincipal       Conductor principal del vehículo.
     * @param conductoresOcasionales   Lista de conductores ocasionales.
     * @param tieneAparcamientoPrivado Indica si el vehículo tiene aparcamiento privado.
     * @param numSini5                 Número de siniestros con culpa en los últimos 5 años.
     * @param precioTERC               Precio de la modalidad de terceros básico.
     * @param precioTAMP               Precio de la modalidad de terceros ampliado.
     * @param precioTRIE               Precio de la modalidad de todo riesgo.
     * @param modalidadElegida         Modalidad de seguro elegida por el cliente.
     */
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

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
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

    /**
     * Constructor de copia.
     * Crea una nueva cotización a partir de otra existente.
     *
     * @param cotizacion2 Cotización de la cual se copiarán los atributos.
     */
    public Cotizacion(Cotizacion cotizacion2) {
        this.id = cotizacion2.id;
        this.codigo = cotizacion2.codigo;
        this.fechaCotizacion = cotizacion2.fechaCotizacion;
        this.fechaInicio = cotizacion2.fechaInicio;
        this.vehiculo = new Vehiculo(cotizacion2.vehiculo); // Copia profunda del vehículo.
        this.tomador = new Persona(cotizacion2.tomador); // Copia profunda del tomador.
        this.conductorPrincipal = new Conductor(cotizacion2.conductorPrincipal); // Copia profunda del conductor principal.
        this.conductoresOcasionales = new ArrayList<>(cotizacion2.conductoresOcasionales); // Copia profunda de la lista de conductores ocasionales.
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

    /**
     * Compara si dos cotizaciones son iguales basándose en su identificador único (id).
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cotizacion cotizacion = (Cotizacion) o;
        return id == cotizacion.id;
    }

    /**
     * Devuelve el código hash de la cotización basado en su identificador único (id).
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Devuelve una representación en cadena de la cotización.
     *
     * @return Cadena que representa la cotización.
     */
    @Override
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