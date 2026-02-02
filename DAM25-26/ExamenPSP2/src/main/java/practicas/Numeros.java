package practicas;

public class Numeros {
    private int numero;
    private long cubo;
    private long cuadrado;

    public Numeros(int numero, long cubo, long cuadrado) {
        this.numero = numero;
        this.cubo = cubo;
        this.cuadrado = cuadrado;
    }

    public Numeros() {
        this.numero = 0;
        this.cuadrado = 0L;
        this.cubo = 0L;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCubo() {
        return cubo;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    @Override
    public String toString() {
        return "Numeros{" +
                "numero=" + numero +
                ", cubo=" + cubo +
                ", cuadrado=" + cuadrado +
                '}';
    }
}
