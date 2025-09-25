package regex;

import java.util.regex.*;

public class ValidarFecha {
    public static void main(String[] args) {
        String fecha = "18/03/2025";
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);
        System.out.println("¿Es una fecha válida? " + matcher.matches());
    }
}
