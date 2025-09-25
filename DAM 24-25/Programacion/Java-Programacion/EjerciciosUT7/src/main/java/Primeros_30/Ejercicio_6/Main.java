package Ejercicio_6;

public class Main {

    public static void main(String[] args) {
        Cocinero cocinero = new CocineroItaliano();
        cocinero.cocinar();
        Cocinero cocinero2 = new CocineroJapones();
        cocinero2.cocinar();
    }
}
