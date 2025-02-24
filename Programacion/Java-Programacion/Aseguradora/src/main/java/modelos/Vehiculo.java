package modelos;

import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import utilidades.UtilidadesVehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Vehiculo {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único del vehículo.
    private Marca marca; // Marca del vehículo.
    private Modelo modelo; // Modelo del vehículo.
    private String matricula; // Matrícula del vehículo.
    private LocalDate fechaMatriculacion; // Fecha de matriculación del vehículo.
    private String color; // Color del vehículo.
    private Persona duenyoActual; // Dueño actual del vehículo.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea un vehículo con todos los atributos.
     *
     * @param id                Identificador único del vehículo.
     * @param marca             Marca del vehículo.
     * @param modelo            Modelo del vehículo.
     * @param matricula         Matrícula del vehículo.
     * @param fechaMatriculacion Fecha de matriculación del vehículo.
     * @param color             Color del vehículo.
     * @param duenyoActual      Dueño actual del vehículo.
     * @throws IllegalArgumentException Si la fecha de matriculación o la matrícula no son válidas.
     */
    public Vehiculo(int id, Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        if (!UtilidadesVehiculo.validaFechaMatriculacion(fechaMatriculacion)) {
            throw new IllegalArgumentException("Fecha de matriculación no válida.");
        }
        if (!UtilidadesVehiculo.esMatriculaValida(matricula)) {
            throw new IllegalArgumentException("Matrícula no válida.");
        }
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.color = color;
        this.duenyoActual = duenyoActual;
    }

    /**
     * Constructor con marca y modelo como String.
     * Crea un vehículo con marca y modelo como cadenas de texto.
     *
     * @param id                Identificador único del vehículo.
     * @param marca             Marca del vehículo como String.
     * @param modelo            Modelo del vehículo como String.
     * @param matricula         Matrícula del vehículo.
     * @param fechaMatriculacion Fecha de matriculación del vehículo.
     * @param color             Color del vehículo.
     * @param duenyoActual      Dueño actual del vehículo.
     * @throws IllegalArgumentException Si la fecha de matriculación, la matrícula, la marca o el modelo no son válidos.
     */
    public Vehiculo(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        if (!UtilidadesVehiculo.validaFechaMatriculacion(fechaMatriculacion)) {
            throw new IllegalArgumentException("Fecha de matriculación no válida.");
        }
        if (!UtilidadesVehiculo.esMatriculaValida(matricula)) {
            throw new IllegalArgumentException("Matrícula no válida.");
        }
        if (!UtilidadesVehiculo.validarMarca(marca)) {
            throw new IllegalArgumentException("Marca no válida.");
        }
        if (!UtilidadesVehiculo.validarModelo(modelo)) {
            throw new IllegalArgumentException("Modelo no válido.");
        }

        this.id = id;
        this.marca = new Marca(marca, new ArrayList<Modelo>());
        this.modelo = new Modelo(modelo, 0, 0, 0);
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.color = color;
        this.duenyoActual = duenyoActual;
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Vehiculo() {
        this.id = 0;
        this.marca = null;
        this.modelo = null;
        this.matricula = "ninguno";
        this.fechaMatriculacion = LocalDate.now();
        this.color = "ninguno";
        this.duenyoActual = null;
    }

    /**
     * Constructor de copia.
     * Crea un nuevo vehículo a partir de otro existente.
     *
     * @param vehiculo2 Vehículo del cual se copiarán los atributos.
     */
    public Vehiculo(Vehiculo vehiculo2) {
        this.id = vehiculo2.id;
        this.marca = vehiculo2.marca;
        this.modelo = vehiculo2.modelo;
        this.matricula = vehiculo2.matricula;
        this.fechaMatriculacion = vehiculo2.fechaMatriculacion;
        this.color = vehiculo2.color;
        this.duenyoActual = vehiculo2.duenyoActual;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Persona getDuenyoActual() {
        return duenyoActual;
    }

    public void setDuenyoActual(Persona duenyoActual) {
        this.duenyoActual = duenyoActual;
    }

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena del vehículo.
     *
     * @return Cadena que representa al vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", color='" + color + '\'' +
                ", duenyoActual=" + duenyoActual +
                '}';
    }

    /**
     * Compara si dos vehículos son iguales basándose en todos sus atributos.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id &&
                Objects.equals(marca, vehiculo.marca) &&
                Objects.equals(modelo, vehiculo.modelo) &&
                Objects.equals(matricula, vehiculo.matricula) &&
                Objects.equals(fechaMatriculacion, vehiculo.fechaMatriculacion) &&
                Objects.equals(color, vehiculo.color) &&
                Objects.equals(duenyoActual, vehiculo.duenyoActual);
    }

    /**
     * Devuelve el código hash del vehículo basado en todos sus atributos.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
    }
}