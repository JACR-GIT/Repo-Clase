package Ejercicio_27;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public  static void main(String[] args) {
        List<String> listaNombres = List.of("Juan", "Pedro", "Maria", "Ana", "Luis", "Carlos", "Jose", "Luisa", "Marta", "Lucia");
        String resultado = listaNombres.stream().collect(Collectors.joining(", "));
        System.out.println(resultado);
    }
}
