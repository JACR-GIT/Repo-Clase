package Ejercicio_9;

public class Main {
    public static void main(String[] args) {
        InstrumentoMusical[] instrumentos = new InstrumentoMusical[2];
        instrumentos[0] = new Guitarra();
        instrumentos[1] = new Piano();

        // Recorrer el array y tocar cada instrumento
        for (InstrumentoMusical instrumento : instrumentos) {
            instrumento.tocar();
            System.out.println();
        }
    }
}
