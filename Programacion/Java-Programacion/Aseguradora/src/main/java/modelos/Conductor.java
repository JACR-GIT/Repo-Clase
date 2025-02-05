package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Conductor extends Persona {
    private LocalDate fechaCarnet;
    private int puntosCarnet;
    private int anyosAsegurado;

    public Conductor(int id, String nombre, String apellido1, String apellido2, String nif, LocalDate fechaNacimiento, Direccion direccion,
                     LocalDate fechaCarnet, int puntosCarnet, int anyosAsegurado) {
        super(id, nombre, apellido1, apellido2, nif, fechaNacimiento, direccion);
        this.fechaCarnet = fechaCarnet;
        this.puntosCarnet = puntosCarnet;
        this.anyosAsegurado = anyosAsegurado;
    }
    public Conductor() {

        this.fechaCarnet = LocalDate.now();
        this.puntosCarnet = 0;
        this.anyosAsegurado = 0;
    }

    public Conductor(Conductor conductor2) {

        this.fechaCarnet = fechaCarnet;
        this.puntosCarnet = puntosCarnet;
        this.anyosAsegurado = anyosAsegurado;
    }

    public String toString() {
        return "Conductor{" +
                super.toString() +
                ", fechaCarnet=" + fechaCarnet +
                ", puntosCarnet=" + puntosCarnet +
                ", anyosAsegurado=" + anyosAsegurado +
                '}';
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Conductor conductor = (Conductor) obj;
        return puntosCarnet == conductor.puntosCarnet &&
                anyosAsegurado == conductor.anyosAsegurado &&
                Objects.equals(fechaCarnet, conductor.fechaCarnet);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaCarnet, puntosCarnet, anyosAsegurado);
    }
}
