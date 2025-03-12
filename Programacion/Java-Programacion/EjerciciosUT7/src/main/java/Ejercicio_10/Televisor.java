package Ejercicio_10;

public class Televisor extends Electrodomestico{

    public Televisor(String marca, double consumo){
        super(marca, consumo);
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + marca + " Consumo: " + consumo);
    }
}
