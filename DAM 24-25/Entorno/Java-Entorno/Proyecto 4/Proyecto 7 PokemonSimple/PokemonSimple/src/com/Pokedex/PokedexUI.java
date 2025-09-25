package com.Pokedex;

import com.Pokedex.Pokemon.Ataque;
import com.Pokedex.Pokemon.Pokemon;

import java.util.HashMap;

public interface PokedexUI {
    Pokemon getPokemon();
    HashMap<String, String> getDebilidad();
    Ataque getAtaque();
    Pokemon comparadorPokemon(Pokemon pokemon1, Pokemon pokemon2);

}
