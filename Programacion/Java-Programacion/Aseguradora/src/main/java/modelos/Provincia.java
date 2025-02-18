package modelos;

import java.util.Objects;

public class Provincia {

    private String codigo;
    private String nombre;

    //Constructor
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

    //Setter y Getter
    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setcodigo (String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(codigo, provincia.codigo) && Objects.equals(nombre, provincia.nombre);
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}
