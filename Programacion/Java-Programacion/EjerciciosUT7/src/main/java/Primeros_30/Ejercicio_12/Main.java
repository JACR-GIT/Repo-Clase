package Ejercicio_12;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5,6,7,8,9,10);
        Function<Integer,String> convertirNumero = numero -> {
            switch (numero) {
                case 1:
                    return "uno";
                case 2:
                    return "dos";
                case 3:
                    return "tres";
                case 4:
                    return "cuatro";
                case 5:
                    return "cinco";
                case 6:
                    return "seis";
                case 7:
                    return "siete";
                case 8:
                    return "ocho";
                case 9:
                    return "nueve";
                case 10:
                    return "diez";
                default:
                    return "Número no soportado";
            }
        };
        for (Integer numero : numeros) {
            System.out.println(convertirNumero.apply(numero));
        }
    }
}
