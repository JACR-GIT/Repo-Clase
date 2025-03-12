package Ejercicio_7;

public class Circulo extends Figura{

    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public String mostrarInfo(){
        return "Soy un circulo";
    }

}
