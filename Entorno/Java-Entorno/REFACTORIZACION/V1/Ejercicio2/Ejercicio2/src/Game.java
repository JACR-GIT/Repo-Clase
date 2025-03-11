public class Game {
    //Encapsular atributo con private y agregar getter y setter además de hacer un rename para que sea mas descriptivo.
    //Se ha extraido la lógica de movimiento de Game a Player
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void movement (String m){
        if (m.equalsIgnoreCase("Derecha")){
           player.mueveDerecha();
        }
        if (m.equalsIgnoreCase("Izquierda")){
            player.mueveIzquierda();
        }
        if (m.equalsIgnoreCase("Arriba")){
            player.mueveArriba();
        }
        if (m.equalsIgnoreCase("Abajo")){
           player.mueveAbajo();
        }

    }
}

