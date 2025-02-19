package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Coche extends Vehiculo{

    public enum TipoCombusible{
        GASOLINA, DIESEL, ELECTRICO, HIBRIDO
    }
    public enum TipoTraccion {
        DELANTERA, TRASERA, INTEGRAL
    }

    private int numeroPuertas;
    private TipoCombusible tipoCombusible;
    private TipoTraccion traccion;
    private boolean esTodoTerreno;

    public Coche(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int numeroPuertas, TipoCombusible tipoCombusible, TipoTraccion traccion, boolean esTodoTerreno) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombusible = tipoCombusible;
        this.traccion = traccion;
        this.esTodoTerreno = esTodoTerreno;
    }
    public Coche() {
        this.numeroPuertas = 0;
        this.tipoCombusible = null;
        this.traccion = null;
        this.esTodoTerreno = false;
    }
    public Coche(Coche coche2) {
        this.numeroPuertas = coche2.numeroPuertas;
        this.tipoCombusible = coche2.tipoCombusible;
        this.traccion = coche2.traccion;
        this.esTodoTerreno = coche2.esTodoTerreno;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public TipoCombusible getTipoCombusible() {
        return tipoCombusible;
    }

    public void setTipoCombusible(TipoCombusible tipoCombusible) {
        this.tipoCombusible = tipoCombusible;
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

    public String toString() {
        return "Coche{" +
                "numeroPuertas=" + numeroPuertas +
                ", tipoCombusible=" + tipoCombusible +
                ", traccion=" + traccion +
                ", esTodoTerreno=" + esTodoTerreno +
                '}';
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coche coche = (Coche) o;
        return numeroPuertas == coche.numeroPuertas && esTodoTerreno == coche.esTodoTerreno && tipoCombusible == coche.tipoCombusible && traccion == coche.traccion;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroPuertas, tipoCombusible, traccion, esTodoTerreno);
    }
}
