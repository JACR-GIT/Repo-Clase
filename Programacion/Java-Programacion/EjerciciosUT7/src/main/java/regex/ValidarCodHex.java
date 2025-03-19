package regex;

import java.util.regex.*;

public class ValidarCodHex {
    public static void main(String[] args) {
        String hex = "#FF5733";
        String regex = "^#[0-9A-Fa-f]{6}$"; // # seguido de 6 caracteres hexadecimales
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(hex);
        System.out.println("¿Es un código hexadecimal válido? " + matcher.matches());
    }
}
