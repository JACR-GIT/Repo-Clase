package regex;

import java.util.regex.*;

public class ValidarUrl {
    public static void main(String[] args) {
        String url = "https://www.ejemplo.com";
        String regex = "^(https?://)(www\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        System.out.println("¿Es una URL válida? " + matcher.matches());
    }
}
