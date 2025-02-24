package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aseguradora {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la aseguradora.
    private String nombre; // Nombre de la aseguradora.
    private Direccion direccion; // Dirección de la aseguradora.
    private String telefono; // Número de teléfono de la aseguradora.
    private List<Vehiculo> vehiculosAsegurados; // Lista de vehículos asegurados por la aseguradora.
    private List<Poliza> listaPolizas; // Lista de pólizas de la aseguradora.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una aseguradora con todos los atributos.
     *
     * @param id                 Identificador único de la aseguradora.
     * @param nombre             Nombre de la aseguradora.
     * @param direccion          Dirección de la aseguradora.
     * @param telefono           Número de teléfono de la aseguradora.
     * @param vehiculosAsegurados Lista de vehículos asegurados por la aseguradora.
     */
    public Aseguradora(int id, String nombre, Direccion direccion, String telefono, List<Vehiculo> vehiculosAsegurados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.vehiculosAsegurados = vehiculosAsegurados;
        this.listaPolizas = new ArrayList<>(); // Inicializa la lista de pólizas como una lista vacía.
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Aseguradora() {
        this.id = 0;
        this.nombre = "";
        this.direccion = new Direccion();
        this.telefono = "";
        this.vehiculosAsegurados = new ArrayList<>(); // Inicializa la lista de vehículos asegurados como una lista vacía.
        this.listaPolizas = new ArrayList<>(); // Inicializa la lista de pólizas como una lista vacía.
    }

    /**
     * Constructor de copia.
     * Crea una nueva aseguradora a partir de otra existente.
     *
     * @param aseguradora2 Aseguradora de la cual se copiarán los atributos.
     */
    public Aseguradora(Aseguradora aseguradora2) {
        this.id = aseguradora2.id;
        this.nombre = aseguradora2.nombre;
        this.direccion = new Direccion(aseguradora2.direccion); // Copia profunda de la dirección.
        this.telefono = aseguradora2.telefono;
        this.vehiculosAsegurados = new ArrayList<>(aseguradora2.vehiculosAsegurados); // Copia profunda de la lista de vehículos.
        this.listaPolizas = new ArrayList<>(aseguradora2.listaPolizas); // Copia profunda de la lista de pólizas.
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

    /**
     * Añade una póliza a la lista de pólizas de la aseguradora.
     *
     * @param poliza Póliza a añadir.
     */
    public void addPoliza(Poliza poliza) {
        listaPolizas.add(poliza);
    }

    /**
     * Elimina una póliza de la lista de pólizas de la aseguradora.
     *
     * @param poliza Póliza a eliminar.
     */
    public void removePoliza(Poliza poliza) {
        listaPolizas.remove(poliza);
    }

    /**
     * Devuelve una representación en cadena de la aseguradora.
     *
     * @return Cadena que representa la aseguradora.
     */
    @Override
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

    /**
     * Compara si dos aseguradoras son iguales basándose en su identificador único (id).
     *
     * @param obj Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aseguradora that = (Aseguradora) obj;
        return id == that.id;
    }

    /**
     * Devuelve el código hash de la aseguradora basado en su identificador único (id).
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}