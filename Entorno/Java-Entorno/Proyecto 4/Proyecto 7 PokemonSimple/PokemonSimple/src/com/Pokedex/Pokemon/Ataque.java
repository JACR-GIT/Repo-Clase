package com.Pokedex.Pokemon;

public class Ataque implements AtaqueUI{
    private String nombreAtaque;
    private Integer danyoAtaque;


    public Ataque(String nombreAtaque, Integer danyoAtaque){
        this.nombreAtaque = nombreAtaque;
        this.danyoAtaque = danyoAtaque;
    }

    public String getNombreAtaque() {
        return nombreAtaque;
    }
    public void setNombreAtaque(String nombreAtaque) {
        this.nombreAtaque = nombreAtaque;
    }
    public Integer getDanyoAtaque() {
        return danyoAtaque;
    }
    public void setDanyoAtaque(Integer danyoAtaque) {
        this.danyoAtaque = danyoAtaque;
    }

    public String toString() {
        return "Ataque: " + getNombreAtaque() + ", " + getDanyoAtaque();
    }
}
