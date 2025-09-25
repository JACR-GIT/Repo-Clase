package com.EstructurasEIteradores.Actividad3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainActividad3 {
    public static void main(String[] args) {
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Sofia", "644567890");
        telefonos.put("Luis", "611234567");
        telefonos.put("Pedro", "633456789");
        telefonos.put("Marta", "622345678");
        telefonos.put("Ana", "600123456");

        Map<String, String> telefonosOrdenados = new TreeMap<>(telefonos); //TreeMap los ordena alfabeticamente

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un nombre: ");
        String nombreBuscado = scanner.nextLine();

        if (telefonos.containsKey(nombreBuscado)) {
            System.out.println("El teléfono de " + nombreBuscado + " es: " + telefonos.get(nombreBuscado));
        }else{
            System.out.println("El contacto no existe: " + nombreBuscado);
        }

        System.out.print(telefonosOrdenados);
    }
}
