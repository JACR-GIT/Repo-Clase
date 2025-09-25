package utilidades;

import modelos.Persona;

import java.time.LocalDate;

public class UtilidadesPersonas {

    //Metodos
    public static boolean esNIFValido(String nif) {
        String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (nif == null || nif.length() != 9) return false;

        String numeros;
        char letra = nif.charAt(8);

        if (nif.charAt(0) == 'X' || nif.charAt(0) == 'Y' || nif.charAt(0) == 'Z') {
            char primeraLetra = nif.charAt(0);
            switch (primeraLetra) {
                case 'X': numeros = "0" + nif.substring(1, 8); break;
                case 'Y': numeros = "1" + nif.substring(1, 8); break;
                case 'Z': numeros = "2" + nif.substring(1, 8); break;
                default: return false;
            }
        } else {
            numeros = nif.substring(0, 8);
        }

        try {
            int num = Integer.parseInt(numeros);
            char letraCalculada = LETRAS_NIF.charAt(num % 23);
            return letraCalculada == letra;
        } catch (NumberFormatException e) {
            return false;
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
