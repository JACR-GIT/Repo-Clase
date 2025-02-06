package com.Pokedex;

import com.Pokedex.Pokemon.Ataque;
import com.Pokedex.Pokemon.Pokemon;

import java.util.HashMap;

public class Pokedex implements PokedexUI {
    private Pokemon pokemon;
    private HashMap<String, String> debilidad;
    private Ataque ataque;


    public Pokedex(Pokemon pokemon, Ataque ataque) {
        this.pokemon = pokemon;
        this.debilidad = new HashMap<>();
        this.debilidad.put("fuego", "agua");
        this.debilidad.put("agua", "electrico");
        this.debilidad.put("roca", "agua");
        this.debilidad.put("planta", "fuego");
        this.ataque = ataque;

    }

    public Pokemon getPokemon() {
        return pokemon;
    }
    public HashMap<String, String> getDebilidad() {
        return debilidad;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Pokemon comparadorPokemon(Pokemon pokemon1, Pokemon pokemon2) {
        Pokemon pokeDebil= null;
        for (String tipo : this.debilidad.keySet()) {
            if (pokemon1.getTipoPokemon().equalsIgnoreCase(tipo) && pokemon2.getTipoPokemon().equalsIgnoreCase(this.debilidad.get(tipo)))  {
                pokeDebil = pokemon1;
            } else if (pokemon2.getTipoPokemon().equalsIgnoreCase(tipo) && pokemon1.getTipoPokemon().equalsIgnoreCase(this.debilidad.get(tipo)))  {
                pokeDebil = pokemon2;
            }
        }
        return pokeDebil;
    }


    @Override
    public String toString() {
        return pokemon.toString() + "\n" + ataque.toString();
    }
}
