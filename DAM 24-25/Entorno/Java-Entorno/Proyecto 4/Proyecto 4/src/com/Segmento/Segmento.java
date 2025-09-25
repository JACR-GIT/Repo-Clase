package com.Segmento;

import com.Punto3D.Punto3D;

public class Segmento implements SegmentoUI {

    //Variables
    private Punto3D extremoA;
    private Punto3D extremoB;

    //Constructor
    public Segmento(Punto3D extremoA, Punto3D extremoB) {

        if (extremoA == null || extremoB == null) {
            throw new NullPointerException("Los extrmos no pueden tomar valores nulo");
        }else {
            this.extremoA = extremoA;
            this.extremoB = extremoB;
        }
    }

    //Getters & Setters
    public Punto3D getExtremoA() {
        return extremoA;
    }
    public void setExtremoA(Punto3D extremoA) {
        if (extremoA == null) {
            throw new NullPointerException("No pueden tomar valores nulos");
        }else{
            this.extremoA = extremoA;
        }
    }
    public Punto3D getExtremoB() {
        return extremoB;
    }
    public void setExtremoB(Punto3D extremoB) {
        if (extremoB == null) {
            throw new NullPointerException("No pueden tomar valores nulos");
        }else{
            this.extremoB = extremoB;
        }

    }

    public Double getLongitudSegmento(Punto3D extremoA, Punto3D extremoB) {
        if (extremoA == null || extremoB==null) {
            throw new NullPointerException();
        }else{
            return Math.sqrt(
                    Math.pow((extremoA.getX()-extremoB.getX()),2)+
                    Math.pow((extremoA.getY()-extremoB.getY()),2)+
                    Math.pow((extremoA.getZ()-extremoB.getZ()),2)
            );

        }
    }

    public String toString() {

        return "["+getExtremoA()+", "+getExtremoB()+"]";
    }
}
