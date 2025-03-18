package Primeros_30.Ejercicio_2;

import Ejercicio_1.Reproducible;

import static Primeros_30.Ejercicio_2.OperacionesMatematicas.Numero_Pi_Intefaz;

public class Calculadora implements Primeros_30.Ejercicio_2.OperacionesMatematicas {

    final static double Numero_Pi = Numero_Pi_Intefaz;

    public void suma(int a, int b) {
        double suma = a + b;
    }
    public void resta(int a, int b) {
        double resta = a - b;
    }
}
