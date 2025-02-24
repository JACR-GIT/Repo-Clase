package modelos;

import java.util.Objects;

public class Provincia {

    // ==================== PROPIEDADES O VARIABLES ====================

    private String codigo; // Código de la provincia.
    private String nombre; // Nombre de la provincia.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una provincia con todos los atributos.
     *
     * @param codigo Código de la provincia.
     * @param nombre Nombre de la provincia.
     */
    public Provincia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Provincia() {
        this.codigo = "";
        this.nombre = "";
    }

    /**
     * Constructor de copia.
     * Crea una nueva provincia a partir de otra existente.
     *
     * @param provincia Provincia de la cual se copiarán los atributos.
     */
    public Provincia(Provincia provincia) {
        this.codigo = provincia.codigo;
        this.nombre = provincia.nombre;
    }

    /**
     * Constructor que recibe solo el nombre de la provincia.
     * El código se inicializa como una cadena vacía.
     *
     * @param nombre Nombre de la provincia.
     */
    public Provincia(String nombre) {
        this.codigo = "";
        this.nombre = nombre;
    }

    // ==================== GETTERS Y SETTERS ====================

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena de la provincia.
     *
     * @return Cadena que representa la provincia.
     */
    @Override
    public String toString() {
        return "Provincia{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    /**
     * Compara si dos provincias son iguales basándose en su código y nombre.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(codigo, provincia.codigo) &&
                Objects.equals(nombre, provincia.nombre);
    }

    /**
     * Devuelve el código hash de la provincia basado en su código y nombre.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}