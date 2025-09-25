package Ejercicio_10;

public abstract class Electrodomestico {
    protected String marca;
    protected double consumo;

    public Electrodomestico(String marca, double consumo){
        this.marca = marca;
        this.consumo = consumo;
    }
}
