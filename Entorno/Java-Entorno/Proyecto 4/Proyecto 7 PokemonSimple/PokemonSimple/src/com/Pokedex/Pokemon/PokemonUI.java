package com.Pokedex.Pokemon;

public interface PokemonUI {
    Integer getNumeroPokemon();
    String getNombrePokemon();
    String getDescripcionPokemon();
    void setDescripcionPokemon(String descripcionPokemon);
    Double getAlturaPokemon();
    void setAlturaPokemon(Double alturaPokemon);
    Double getPesoPokemon();
    void setPesoPokemon(Double pesoPokemon);
    GeneroPokemon getGeneroPokemon();
    void setGeneroPokemon(GeneroPokemon generoPokemon);
    String getTipoPokemon();
    void setTipoPokemon(String tipoPokemon);

}
