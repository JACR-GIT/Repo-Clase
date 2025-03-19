package regex;

import java.util.regex.*;

public class PalabrasEmpiezanMayus {
    public static void main(String[] args) {
        String texto = "Hola Mundo, soy Grok de xAI";
        String regex = "\\b[A-Z][a-z]*\\b"; // Palabras que empiezan con mayúscula
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            System.out.println("Palabra encontrada: " + matcher.group());
        }
    }
}
