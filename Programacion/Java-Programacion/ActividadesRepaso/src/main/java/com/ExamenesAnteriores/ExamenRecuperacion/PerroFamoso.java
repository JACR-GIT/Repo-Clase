package com.ExamenesAnteriores.ExamenRecuperacion;

import com.joey.utils.Perro;
import com.joey.utils.RazaPerro;

import java.time.LocalDate;

public class PerroFamoso extends Perro implements Comparable<PerroFamoso> {
    String lugarOrigen;
    String motivoFama;

    public PerroFamoso(String nombre, RazaPerro raza, LocalDate fechaNacimiento, String lugarOrigen, String motivoFama) {
        super(nombre, raza, fechaNacimiento);
        this.lugarOrigen = lugarOrigen;
        this.motivoFama = motivoFama;
    }

    public PerroFamoso(Perro perro, String lugarOrigen, String motivoFama) {
        super(perro);
        this.lugarOrigen = lugarOrigen;
        this.motivoFama = motivoFama;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getMotivoFama() {
        return motivoFama;
    }

    public void setMotivoFama(String motivoFama) {
        this.motivoFama = motivoFama;
    }

    @Override
    public String toString() {
        return "( " + getNombre() + ", "+ getRaza().getNombreRaza() + ", " + getLugarOrigen() + " )";
    }

    @Override
    public int compareTo(PerroFamoso o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
