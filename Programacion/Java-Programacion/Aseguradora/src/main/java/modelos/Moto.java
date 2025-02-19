package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Moto extends Vehiculo{

    private int cilindradaCC;
    private boolean tieneSidecar;

    public Moto(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int cilindradaCC, boolean tieneSidecar) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.cilindradaCC = cilindradaCC;
        this.tieneSidecar = tieneSidecar;
    }
    public Moto() {
        this.cilindradaCC = 0;
        this.tieneSidecar = false;
    }
    public Moto(Moto moto2) {
        this.cilindradaCC = moto2.cilindradaCC;
        this.tieneSidecar = moto2.tieneSidecar;
    }

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

    public String toString() {
        return "Moto{" +
                "cilindradaCC=" + cilindradaCC +
                ", tieneSidecar=" + tieneSidecar +
                '}';
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Moto moto = (Moto) o;
        return cilindradaCC == moto.cilindradaCC && tieneSidecar == moto.tieneSidecar;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), cilindradaCC, tieneSidecar);
    }
}
