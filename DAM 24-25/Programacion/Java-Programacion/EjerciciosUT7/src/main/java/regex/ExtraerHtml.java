package regex;

import java.util.regex.*;

public class ExtraerHtml {
    public static void main(String[] args) {
        String html = "<p>Texto</p><div>Contenido</div>";
        String regex = "<[^>]+>"; // Coincide con etiquetas HTML
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            System.out.println("Etiqueta encontrada: " + matcher.group());
        }
    }
}
