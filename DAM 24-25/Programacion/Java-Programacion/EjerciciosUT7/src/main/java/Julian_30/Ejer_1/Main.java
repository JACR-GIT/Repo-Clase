package Julian_30.Ejer_1;

public class Main {
    public static void main(String[] args) {
        NumeroUtil util = new NumeroUtil();
        System.out.println("¿Es par 4? " + Utilidades.esPar(4)); // true
        System.out.println("Suma de pares hasta 6: " + util.sumarPares(6)); // 0+2+4+6 = 12
    }
}