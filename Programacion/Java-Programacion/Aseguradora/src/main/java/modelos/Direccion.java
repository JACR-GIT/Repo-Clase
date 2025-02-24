package modelos;

import java.util.Objects;

public class Direccion {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la dirección.
    private TipoVia tipoVia; // Tipo de vía (calle, avenida, etc.).
    private String nombreVia; // Nombre de la vía.
    private int numero; // Número de la vía.
    private String restoDireccion; // Resto de la dirección (piso, puerta, etc.).
    private String codigoPostal; // Código postal de la dirección.
    private String localidad; // Localidad de la dirección.
    private Provincia provincia; // Provincia de la dirección.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una dirección con todos los atributos.
     *
     * @param id             Identificador único de la dirección.
     * @param tipoVia        Tipo de vía (calle, avenida, etc.).
     * @param nombreVia      Nombre de la vía.
     * @param numero         Número de la vía.
     * @param restoDireccion Resto de la dirección (piso, puerta, etc.).
     * @param codigoPostal   Código postal de la dirección.
     * @param localidad      Localidad de la dirección.
     * @param provincia      Provincia de la dirección.
     */
    public Direccion(int id, TipoVia tipoVia, String nombreVia, int numero, String restoDireccion, String codigoPostal, String localidad, Provincia provincia) {
        this.id = id;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.restoDireccion = restoDireccion;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Direccion() {
        this.id = 0;
        this.tipoVia = null;
        this.nombreVia = "ninguno";
        this.numero = 1;
        this.restoDireccion = "ninguno";
        this.codigoPostal = "ninguno";
        this.localidad = "ninguno";
        this.provincia = null;
    }

    /**
     * Constructor de copia.
     * Crea una nueva dirección a partir de otra existente.
     *
     * @param direccion2 Dirección de la cual se copiarán los atributos.
     */
    public Direccion(Direccion direccion2) {
        this.id = direccion2.id;
        this.tipoVia = direccion2.tipoVia;
        this.nombreVia = direccion2.nombreVia;
        this.numero = direccion2.numero;
        this.restoDireccion = direccion2.restoDireccion;
        this.codigoPostal = direccion2.codigoPostal;
        this.localidad = direccion2.localidad;
        this.provincia = direccion2.provincia;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoVia getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(TipoVia tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRestoDireccion() {
        return restoDireccion;
    }

    public void setRestoDireccion(String restoDireccion) {
        this.restoDireccion = restoDireccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena de la dirección.
     *
     * @return Cadena que representa la dirección.
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", tipoVia=" + tipoVia +
                ", nombreVia='" + nombreVia + '\'' +
                ", numero=" + numero +
                ", restoDireccion='" + restoDireccion + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    /**
     * Compara si dos direcciones son iguales basándose en todos sus atributos.
     *
     * @param obj Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Direccion direccion = (Direccion) obj;
        return id == direccion.id &&
                numero == direccion.numero &&
                Objects.equals(tipoVia, direccion.tipoVia) &&
                Objects.equals(nombreVia, direccion.nombreVia) &&
                Objects.equals(restoDireccion, direccion.restoDireccion) &&
                Objects.equals(codigoPostal, direccion.codigoPostal) &&
                Objects.equals(localidad, direccion.localidad) &&
                Objects.equals(provincia, direccion.provincia);
    }

    /**
     * Devuelve el código hash de la dirección basado en todos sus atributos.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, tipoVia, nombreVia, numero, restoDireccion, codigoPostal, localidad, provincia);
    }
}