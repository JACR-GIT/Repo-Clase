package practicas;

import java.io.Serializable;

/**
 * Clase para enviar respuestas del servidor al cliente en el juego Mastermind
 */
public class RespuestaMastermind implements Serializable {
    private int aciertos;       // Números en posición correcta
    private int coincidencias;  // Números correctos en posición incorrecta
    private int intentosRestantes;
    private boolean juegoTerminado;
    private boolean ganador;
    
    public RespuestaMastermind() {}
    
    public RespuestaMastermind(int aciertos, int coincidencias, int intentosRestantes,
                               boolean juegoTerminado, boolean ganador) {
        this.aciertos = aciertos;
        this.coincidencias = coincidencias;
        this.intentosRestantes = intentosRestantes;
        this.juegoTerminado = juegoTerminado;
        this.ganador = ganador;
    }
    
    public int getAciertos() { return aciertos; }
    public void setAciertos(int aciertos) { this.aciertos = aciertos; }
    
    public int getCoincidencias() { return coincidencias; }
    public void setCoincidencias(int coincidencias) { this.coincidencias = coincidencias; }
    
    public int getIntentosRestantes() { return intentosRestantes; }
    public void setIntentosRestantes(int intentosRestantes) { this.intentosRestantes = intentosRestantes; }
    
    public boolean isJuegoTerminado() { return juegoTerminado; }
    public void setJuegoTerminado(boolean juegoTerminado) { this.juegoTerminado = juegoTerminado; }
    
    public boolean isGanador() { return ganador; }
    public void setGanador(boolean ganador) { this.ganador = ganador; }
}
