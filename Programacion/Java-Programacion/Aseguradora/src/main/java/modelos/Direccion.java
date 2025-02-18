package modelos;

import java.util.Objects;

public class Direccion {
    private int id;
    private TipoVia tipoVia;
    private String nombreVia;
    private int numero;
    private String restoDireccion;
    private String codigoPostal;
    private String localidad;
    private Provincia provincia;

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

    public int hashCode() {
        return Objects.hash(id, tipoVia, nombreVia, numero, restoDireccion, codigoPostal, localidad, provincia);
    }
}