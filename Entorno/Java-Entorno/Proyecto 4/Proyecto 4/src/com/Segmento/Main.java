package com.Segmento;

import com.Punto3D.Punto3D;

public class Main {
    public static void main(String[] args) {
        Punto3D punto1 = new Punto3D(1.0,2.0,3.0);
        Punto3D punto2 = new Punto3D(4.0,5.0,6.0);
        Segmento segmento = new Segmento(punto1,punto2);
        Double longitud = segmento.getLongitudSegmento(punto1,punto2);
        System.out.println(segmento);
        System.out.println(longitud);
    }

}
