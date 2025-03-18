package Primeros_30.Ejercicio_14;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> saludoAleatorio = () -> {
            int numeroAleatorio = (int) (Math.random() * 3);
            switch (numeroAleatorio) {
                case 0:
                    return "Hola";
                case 1:
                    return "Bienvenido";
                case 2:
                    return "Saludos";
                default:
                    return "Saludo no soportado";
            }
        };
        System.out.println(saludoAleatorio.get());

        Supplier<Double> generarAleatorio = () -> Math.random();
        System.out.println(generarAleatorio.get());
    }
}
