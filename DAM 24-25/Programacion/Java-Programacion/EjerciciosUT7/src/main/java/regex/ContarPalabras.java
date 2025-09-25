package regex;

import java.util.regex.*;

public class ContarPalabras {
    public static void main(String[] args) {
        String texto = "Hola, ¿cómo estás hoy?";
        String regex = "\\b\\w+\\b"; // Coincide con palabras (letras, números, guiones bajos)
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        int contador = 0;
        while (matcher.find()) {
            contador++;
        }
        System.out.println("Número de palabras: " + contador);
    }
}
