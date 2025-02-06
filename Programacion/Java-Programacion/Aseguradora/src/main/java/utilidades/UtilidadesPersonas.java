package utilidades;

import modelos.Persona;

import java.time.LocalDate;
//Partiendo de la versión V1 del proyecto:
//En la clase UtilidadesPersonas se crearán los métodos:
//public static boolean esNIFValido(String nif)
//y public static boolean esNIFValido(Persona p)
//Ambos comprobarán si el NIF pasado por entrada (o el NIF de la persona pasada porentrada) es válido

public class UtilidadesPersonas {

    //Metodos
    public static boolean esNIFValido(String nif) {
        String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (nif == null || nif.length() != 9) return false;

        String numeros;
        char letra = nif.charAt(8);

        // Si es un NIE (empieza con X, Y o Z), convertimos la letra inicial en un número
        if (nif.charAt(0) == 'X' || nif.charAt(0) == 'Y' || nif.charAt(0) == 'Z') {
            char primeraLetra = nif.charAt(0);
            switch (primeraLetra) {
                case 'X': numeros = "0" + nif.substring(1, 8); break;
                case 'Y': numeros = "1" + nif.substring(1, 8); break;
                case 'Z': numeros = "2" + nif.substring(1, 8); break;
                default: return false;
            }
        } else {
            // Si es un DNI, simplemente tomamos los 8 primeros caracteres como números
            numeros = nif.substring(0, 8);
        }

        try {
            int num = Integer.parseInt(numeros);  // Convertimos a número
            char letraCalculada = LETRAS_NIF.charAt(num % 23); // Calculamos la letra
            return letraCalculada == letra;  // Comparamos la letra
        } catch (NumberFormatException e) {
            return false;  // Si la conversión falla, no es un número válido
        }
    }

    public static boolean esNIFValido(Persona p){
        return p != null && esNIFValido(p.getNif());
    }

    public static int getEdad(Persona p){
        return p.getFechaNacimiento().until(LocalDate.now()).getYears();
    }

    public static boolean esMayorDeEdad(Persona p){
        return getEdad(p) >= 18;
    }

    public static boolean esMenor25(Persona p){
        return esMayorDeEdad(p) && getEdad(p) <= 24;
    }
}
