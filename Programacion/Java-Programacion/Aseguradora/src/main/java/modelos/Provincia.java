package modelos;

import java.util.Objects;

public class Provincia {

    // ==================== PROPIEDADES O VARIABLES ====================

    private String codigo; // Código de la provincia.
    private String nombre; // Nombre de la provincia.

    // ==================== CONSTRUCTORES ====================

    public Provincia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Provincia() {
        this.codigo = "";
        this.nombre = "";
    }

    public Provincia(Provincia provincia) {
        this.codigo = provincia.codigo;
        this.nombre = provincia.nombre;
    }

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

    public String toString() {
        return "Provincia{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(codigo, provincia.codigo) &&
                Objects.equals(nombre, provincia.nombre);
    }

    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}