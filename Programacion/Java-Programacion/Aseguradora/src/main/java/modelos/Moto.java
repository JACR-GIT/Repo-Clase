package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Moto extends Vehiculo {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int cilindradaCC; // Cilindrada en centímetros cúbicos de la moto.
    private boolean tieneSidecar; // Indica si la moto tiene sidecar.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo.
     * Crea una moto con todos los atributos.
     *
     * @param id                Identificador único de la moto.
     * @param marca             Marca de la moto.
     * @param modelo            Modelo de la moto.
     * @param matricula         Matrícula de la moto.
     * @param fechaMatriculacion Fecha de matriculación de la moto.
     * @param color             Color de la moto.
     * @param duenyoActual      Dueño actual de la moto.
     * @param cilindradaCC      Cilindrada en centímetros cúbicos de la moto.
     * @param tieneSidecar      Indica si la moto tiene sidecar.
     */
    public Moto(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual,
                int cilindradaCC, boolean tieneSidecar) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.cilindradaCC = cilindradaCC;
        this.tieneSidecar = tieneSidecar;
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Moto() {
        this.cilindradaCC = 0;
        this.tieneSidecar = false;
    }

    /**
     * Constructor de copia.
     * Crea una nueva moto a partir de otra existente.
     *
     * @param moto2 Moto de la cual se copiarán los atributos.
     */
    public Moto(Moto moto2) {
        super(moto2); // Llama al constructor de copia de la clase base (Vehiculo).
        this.cilindradaCC = moto2.cilindradaCC;
        this.tieneSidecar = moto2.tieneSidecar;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getCilindradaCC() {
        return cilindradaCC;
    }

    public void setCilindradaCC(int cilindradaCC) {
        this.cilindradaCC = cilindradaCC;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena de la moto.
     *
     * @return Cadena que representa la moto.
     */
    @Override
    public String toString() {
        return "Moto{" +
                "cilindradaCC=" + cilindradaCC +
                ", tieneSidecar=" + tieneSidecar +
                '}';
    }

    /**
     * Compara si dos motos son iguales basándose en todos sus atributos.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // Llama al equals de la clase base (Vehiculo).
        Moto moto = (Moto) o;
        return cilindradaCC == moto.cilindradaCC &&
                tieneSidecar == moto.tieneSidecar;
    }

    /**
     * Devuelve el código hash de la moto basado en todos sus atributos.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cilindradaCC, tieneSidecar);
    }
}