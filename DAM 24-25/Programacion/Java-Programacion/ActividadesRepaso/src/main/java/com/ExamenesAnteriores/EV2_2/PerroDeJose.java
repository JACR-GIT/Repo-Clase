package com.ExamenesAnteriores.EV2_2;

import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;

import java.time.LocalDate;
import java.time.Period;

public class PerroDeJose extends Perro {
    private String paseadoPor;

    public PerroDeJose(String nombre, RazaPerro raza, LocalDate fechaNacimiento, String paseadoPor) {
        super(nombre, raza, fechaNacimiento);
        this.paseadoPor = paseadoPor;
    }

    public PerroDeJose(Perro perro, String paseadoPor) {
        super(perro);
        this.paseadoPor = paseadoPor;
    }

    public String getPaseadoPor() {
        return paseadoPor;
    }

    public void setPaseadoPor(String paseadoPor) {
        this.paseadoPor = paseadoPor;
    }

    @Override
    public String toString() {
        return super.toString() + ">> Paseado por: " + paseadoPor +"\n";
    }
}