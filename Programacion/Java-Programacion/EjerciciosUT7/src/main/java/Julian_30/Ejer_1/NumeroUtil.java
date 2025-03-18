package Julian_30.Ejer_1;

public class NumeroUtil implements Utilidades {
    public int sumarPares(int limite) {
        int suma = 0;
        for (int i = 0; i <= limite; i++) {
            if (Utilidades.esPar(i)) {
                suma += i;
            }
        }
        return suma;
    }
}
