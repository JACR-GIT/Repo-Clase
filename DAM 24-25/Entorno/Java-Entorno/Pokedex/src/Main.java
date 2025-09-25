import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.", 0.7, 6.9, Genero.MASCULINO, "Planta/Veneno", new Ataque("Latigo cepa", 10));
        Pokemon charmander = new Pokemon(4, "Charmander", "Prefiere los lugares calientes. Cuando llueve, se dice que el vapor sale de la punta de su cola.", 0.6, 8.5, Genero.MASCULINO, "Fuego", new Ataque("Lanzallamas", 15));
        Pokemon squirtle = new Pokemon(7, "Squirtle", "Tras nacer, su espalda se hincha y endurece como una concha. Echa potente espuma por la boca.", 0.5, 9.0, Genero.MASCULINO, "Agua", new Ataque("Pistola agua", 12));
        Pokemon pikachu = new Pokemon(25, "Pikachu", "Cuanto más potente es la energía eléctrica que genera, más suaves y elásticas se vuelven sus mejillas.", 0.4, 6.0, Genero.MASCULINO, "Eléctrico", new Ataque("Impactrueno", 14));
        Pokemon jigglypuff = new Pokemon(39, "Jigglypuff", "Cuando sus enormes ojos parpadean, canta una canción misteriosamente relajante.", 0.5, 5.5, Genero.MASCULINO, "Normal/Hada", new Ataque("Canto", 5));

        // Mostrar información de los Pokémon
        System.out.println(bulbasaur);
        System.out.println(charmander);
        System.out.println(squirtle);
        System.out.println(pikachu);
        System.out.println(jigglypuff);
    }
}