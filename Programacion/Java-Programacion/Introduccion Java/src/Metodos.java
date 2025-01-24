public class Metodos {
    public static void main(String[] args) {
        int resultado = sumar(1289293,30021);
        System.out.println("Resultado: " + resultado);
        if (esPar(resultado) == true)
            System.out.println("Es par");
        else
            System.out.println("Es impar");
    }
    public static int sumar(int a, int b) {
        return a + b;
    }
    public static boolean esPar(int resultado) {
        if (resultado % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
