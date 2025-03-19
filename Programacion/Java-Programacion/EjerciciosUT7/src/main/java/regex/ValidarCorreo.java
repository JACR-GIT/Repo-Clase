package regex;

import java.util.regex.*;

public class ValidarCorreo {
    public static void main(String[] args) {
        String email = "usuario@dominio.com";
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Letras, números, algunos caracteres especiales, @ y dominio
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        System.out.println("¿Es un email válido? " + matcher.matches());
    }
}
