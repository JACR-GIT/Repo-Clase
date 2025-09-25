package regex;

public class ReemplazarVocales {
    public static void main(String[] args) {
        String texto = "Hola mundo";
        String regex = "[aeiouAEIOU]"; // Coincide con cualquier vocal
        String resultado = texto.replaceAll(regex, "*");
        System.out.println("Texto modificado: " + resultado);
    }
}
