package com.Pokedex.Pokemon;

public class Pokemon implements PokemonUI{
    private Integer numeroPokemon;
    private String nombrePokemon;
    private String descripcionPokemon;
    private Double alturaPokemon;
    private Double pesoPokemon;
    private GeneroPokemon generoPokemon;
    private String tipoPokemon;



    public Pokemon(){

    }

    public Pokemon(Integer numeroPokemon, String nombrePokemon, String descripcionPokemon, Double alturaPokemon, Double pesoPokemon, GeneroPokemon generoPokemon, String tipoPokemon) {

        this.numeroPokemon = numeroPokemon;
        this.nombrePokemon = nombrePokemon;
        this.descripcionPokemon = descripcionPokemon;
        this.alturaPokemon = alturaPokemon;
        this.pesoPokemon = pesoPokemon;
        this.generoPokemon = generoPokemon;
        this.tipoPokemon = tipoPokemon;

    }
    public Integer getNumeroPokemon() {
        return numeroPokemon;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }
    public String getDescripcionPokemon() {
        return descripcionPokemon;
    }

    public void setDescripcionPokemon(String descripcionPokemon) {
        this.descripcionPokemon = descripcionPokemon;
    }

    public Double getAlturaPokemon() {
        return alturaPokemon;
    }

    public void setAlturaPokemon(Double alturaPokemon) {
        this.alturaPokemon = alturaPokemon;
    }

    public Double getPesoPokemon() {
        return pesoPokemon;
    }

    public void setPesoPokemon(Double pesoPokemon) {
        this.pesoPokemon = pesoPokemon;
    }

    public GeneroPokemon getGeneroPokemon() {
        return generoPokemon;
    }
    public void setGeneroPokemon(GeneroPokemon generoPokemon) {
        this.generoPokemon = generoPokemon;
    }
    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(String tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    @Override
    public String toString() {
        return "000"+getNumeroPokemon() + " - " + getNombrePokemon() + " - " + getDescripcionPokemon() + ".\n" +
               "Altura: " + getAlturaPokemon()+"m\n" + "Peso: " + getPesoPokemon() + " kg\n" + "Sexo: " + getGeneroPokemon() + "\n"
                + "Tipo: " + getTipoPokemon();
    }
}
