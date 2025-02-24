package modelos;

import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Coche extends Vehiculo {

    // ==================== ENUMERACIONES ====================

    public enum TipoCombustible {
        GASOLINA, DIESEL, ELECTRICO, HIBRIDO
    }

    public enum TipoTraccion {
        DELANTERA, TRASERA, INTEGRAL
    }

    // ==================== PROPIEDADES O VARIABLES ====================

    private int numeroPuertas;
    private TipoCombustible tipoCombustible;
    private TipoTraccion traccion;
    private boolean esTodoTerreno;

    // ==================== CONSTRUCTORES ====================

    public Coche(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual,
                 int numeroPuertas, TipoCombustible tipoCombustible, TipoTraccion traccion, boolean esTodoTerreno) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
        this.esTodoTerreno = esTodoTerreno;
    }

    public Coche(int id, Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual,
                 int numeroPuertas, TipoCombustible tipoCombustible, TipoTraccion traccion, boolean esTodoTerreno) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
        this.esTodoTerreno = esTodoTerreno;
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Coche() {
        this.numeroPuertas = 0;
        this.tipoCombustible = null;
        this.traccion = null;
        this.esTodoTerreno = false;
    }

    /**
     * Constructor de copia.
     * Crea un nuevo coche a partir de otro existente.
     *
     * @param coche2 Coche del cual se copiarán los atributos.
     */
    public Coche(Coche coche2) {
        super(coche2); // Llama al constructor de copia de la clase base (Vehiculo).
        this.numeroPuertas = coche2.numeroPuertas;
        this.tipoCombustible = coche2.tipoCombustible;
        this.traccion = coche2.traccion;
        this.esTodoTerreno = coche2.esTodoTerreno;
    }

    // ==================== GETTERS Y SETTERS ====================

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public TipoTraccion getTraccion() {
        return traccion;
    }

    public void setTraccion(TipoTraccion traccion) {
        this.traccion = traccion;
    }

    public boolean isEsTodoTerreno() {
        return esTodoTerreno;
    }

    public void setEsTodoTerreno(boolean esTodoTerreno) {
        this.esTodoTerreno = esTodoTerreno;
    }

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena del coche.
     *
     * @return Cadena que representa al coche.
     */
    @Override
    public String toString() {
        return "Coche{" +
                "numeroPuertas=" + numeroPuertas +
                ", tipoCombustible=" + tipoCombustible +
                ", traccion=" + traccion +
                ", esTodoTerreno=" + esTodoTerreno +
                '}';
    }

    /**
     * Compara si dos coches son iguales basándose en todos sus atributos.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // Llama al equals de la clase base (Vehiculo).
        Coche coche = (Coche) o;
        return numeroPuertas == coche.numeroPuertas &&
                esTodoTerreno == coche.esTodoTerreno &&
                tipoCombustible == coche.tipoCombustible &&
                traccion == coche.traccion;
    }

    /**
     * Devuelve el código hash del coche basado en todos sus atributos.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroPuertas, tipoCombustible, traccion, esTodoTerreno);
    }
}