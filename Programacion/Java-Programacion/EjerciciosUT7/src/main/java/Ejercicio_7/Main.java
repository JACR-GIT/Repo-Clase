package Ejercicio_7;

public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[2];
        figuras[0] = new Circulo(10);
        figuras[1] = new Triangulo(20, 30);

        for (Figura figura : figuras) {
            System.out.println(figura.mostrarInfo());
            System.out.println("Area: " + figura.calcularArea());
        }
    }
}
