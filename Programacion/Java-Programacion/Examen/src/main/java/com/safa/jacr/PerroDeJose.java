package com.safa.jacr;

import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;
import com.joey.utils.SoporteJoey;

import java.time.LocalDate;

public class PerroDeJose extends Perro {
    private String paseadoPor;

    public PerroDeJose(String nombre, RazaPerro raza, LocalDate fechaNacimiento, String paseadoPor) {
        super(nombre, raza, fechaNacimiento);
        this.paseadoPor = paseadoPor;
    }

    public String getPaseadoPor() {
        return paseadoPor;
    }

    public void setPaseadoPor(String paseadoPor) {
        this.paseadoPor = paseadoPor;
    }

    public String toString() {
       return super.toString() + " Paseado Por: " + paseadoPor;
    }

}
