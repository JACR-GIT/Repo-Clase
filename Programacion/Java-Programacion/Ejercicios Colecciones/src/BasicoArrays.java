public class BasicoArrays {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                System.out.println(numero);
            }
        }
    }
}
