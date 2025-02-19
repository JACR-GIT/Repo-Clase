package modelos;

import java.util.List;
import java.util.Objects;

public class Aseguradora {

    private int ide;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private List<Vehiculo> vehiculosAsegurados;

    public Aseguradora(int ide, String nombre, Direccion direccion, String telefono, List<Vehiculo> vehiculosAsegurados) {
        this.ide = ide;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.vehiculosAsegurados = vehiculosAsegurados;
    }

    public Aseguradora() {
        this.ide = 0;
        this.nombre = "";
        this.direccion = new Direccion();
        this.telefono = "";
        this.vehiculosAsegurados = null;
    }

    public Aseguradora(Aseguradora aseguradora2) {
        this.ide = aseguradora2.ide;
        this.nombre = aseguradora2.nombre;
        this.direccion = aseguradora2.direccion;
        this.telefono = aseguradora2.telefono;
        this.vehiculosAsegurados = aseguradora2.vehiculosAsegurados;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Vehiculo> getVehiculosAsegurados() {
        return vehiculosAsegurados;
    }

    public void setVehiculosAsegurados(List<Vehiculo> vehiculosAsegurados) {
        this.vehiculosAsegurados = vehiculosAsegurados;
    }

    public String toString() {
        return "Aseguradora{" +
                "ide=" + ide +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", telefono='" + telefono + '\'' +
                ", vehiculosAsegurados=" + vehiculosAsegurados +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aseguradora that = (Aseguradora) obj;
        return ide == that.ide;
    }

    public int hashCode() {
        return Objects.hash(ide, nombre, direccion, telefono, vehiculosAsegurados);
    }
}
