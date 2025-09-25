package regex;

import java.util.regex.*;

public class EncontrarNum {
    public static void main(String[] args) {
        String texto = "Tengo 25 años y vivo en el 3er piso";
        String regex = "\\d+"; // Coincide con uno o más dígitos
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            System.out.println("Número encontrado: " + matcher.group());
        }
    }
}
