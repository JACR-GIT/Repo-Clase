package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aseguradora {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private List<Vehiculo> vehiculosAsegurados;
    private List<Poliza> listaPolizas;

    // ==================== CONSTRUCTORES ====================

    public Aseguradora(int id, String nombre, Direccion direccion, String telefono, List<Vehiculo> vehiculosAsegurados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.vehiculosAsegurados = vehiculosAsegurados;
        this.listaPolizas = new ArrayList<>();
    }

    public Aseguradora() {
        this.id = 0;
        this.nombre = "";
        this.direccion = new Direccion();
        this.telefono = "";
        this.vehiculosAsegurados = new ArrayList<>();
        this.listaPolizas = new ArrayList<>();
    }

    public Aseguradora(Aseguradora aseguradora2) {
        this.id = aseguradora2.id;
        this.nombre = aseguradora2.nombre;
        this.direccion = new Direccion(aseguradora2.direccion);
        this.telefono = aseguradora2.telefono;
        this.vehiculosAsegurados = new ArrayList<>(aseguradora2.vehiculosAsegurados);
        this.listaPolizas = new ArrayList<>(aseguradora2.listaPolizas);
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Poliza> getListaPolizas() {
        return listaPolizas;
    }

    public void setListaPolizas(List<Poliza> listaPolizas) {
        this.listaPolizas = listaPolizas;
    }

    // ==================== MÉTODOS ====================

    public void addPoliza(Poliza poliza) {
        listaPolizas.add(poliza);
    }

    public void removePoliza(Poliza poliza) {
        listaPolizas.remove(poliza);
    }

    public String toString() {
        return "Aseguradora{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", telefono='" + telefono + '\'' +
                ", vehiculosAsegurados=" + vehiculosAsegurados +
                ", listaPolizas=" + listaPolizas +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aseguradora that = (Aseguradora) obj;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}