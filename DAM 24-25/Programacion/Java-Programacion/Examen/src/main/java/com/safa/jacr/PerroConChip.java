package com.safa.jacr;

import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;

import java.time.LocalDate;
import java.util.Objects;

public class PerroConChip extends Perro implements Comparable<PerroConChip> {
    String idChip;
    boolean vacunado;

    public PerroConChip(String nombre, RazaPerro raza, LocalDate fechaNacimiento, String idChip, boolean vacunado) {
        super(nombre, raza, fechaNacimiento);
        this.idChip = idChip;
        this.vacunado = vacunado;
    }

    public PerroConChip(Perro perro, String idChip, boolean vacunado) {
        super(perro);
        this.idChip = idChip;
        this.vacunado = vacunado;
    }

    public String getIdChip() {
        return idChip;
    }

    public void setIdChip(String idChip) {
        this.idChip = idChip;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + getRaza().getNombreRaza() + "( "
                + getIdChip() + " ).";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerroConChip that = (PerroConChip) o;
        return Objects.equals(idChip, that.idChip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idChip);
    }

    @Override
    public int compareTo(PerroConChip o) {
        return this.getIdChip().compareTo(o.getIdChip());
    }
}
