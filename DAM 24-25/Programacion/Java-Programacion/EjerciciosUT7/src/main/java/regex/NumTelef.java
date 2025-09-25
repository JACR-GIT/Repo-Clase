package regex;

import java.util.regex.*;

public class NumTelef {
    public static void main(String[] args) {
        String telefono = "123-456-7890";
        String regex = "^\\d{3}-\\d{3}-\\d{4}$"; // 3 dígitos - 3 dígitos - 4 dígitos
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        System.out.println("¿Es un teléfono válido? " + matcher.matches());
    }
}
