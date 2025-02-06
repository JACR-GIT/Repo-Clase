package com.Punto3D;


public class Main {
    public static void main(String[] args) {
        Punto3D p1 = new Punto3D(1.0,2.0,3.0);
        Punto3D p2 = new Punto3D(4.0,5.0,6.0);
        System.out.println(p1);
        System.out.println(p2);
        Double distancia = p2.getDistancia(p2,p1);
        System.out.println(distancia);

        }
    }
