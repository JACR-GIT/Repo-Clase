package Ejercicio_7;

public class Triangulo extends Figura{
    private int base;
    private int altura;

    public Triangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return (base * altura) / 2;
    }

    public String mostrarInfo(){
        return "Soy un triangulo";
    }

}
