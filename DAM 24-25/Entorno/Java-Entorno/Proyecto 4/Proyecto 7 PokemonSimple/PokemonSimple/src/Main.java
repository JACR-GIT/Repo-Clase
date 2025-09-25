import com.Pokedex.Pokedex;
import com.Pokedex.Pokemon.Ataque;
import com.Pokedex.Pokemon.GeneroPokemon;
import com.Pokedex.Pokemon.Pokemon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Pokemon pokemon = new Pokemon(1,"Bulbasur", "pokemon planta veneno de color verde",0.7,2.5, GeneroPokemon.FEMININO,"planta");
    Pokemon pokemon2 = new Pokemon(1,"Charizard", "pokemon fuego de color rojo",3.1,22.4, GeneroPokemon.MASCULINO,"fuego");
    Ataque ataque = new Ataque("ascuas", 30);
    Ataque ataque2 = new Ataque("latigo cepa", 10);
    Pokedex pokedex = new Pokedex(pokemon,ataque2);
    Pokedex pokedex2 = new Pokedex(pokemon2,ataque);
    System.out.println(pokedex.comparadorPokemon(pokemon2,pokemon));
    System.out.println(pokedex2);

        }

}