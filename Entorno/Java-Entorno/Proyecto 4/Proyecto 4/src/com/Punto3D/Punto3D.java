package com.Punto3D;

public class Punto3D implements Punto3DUI{
    //Variables
    private Double x,y,z;

    //Constructor
    public Punto3D(Double x, Double y, Double z) {
        if (x == null || y==null || z==null) {
           throw new NullPointerException();
        }else{
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    //getters & Setters
    public Double getX() {
        return x;
    }
    public void setX(Double x) {
        if (x!= null) {
            this.x = x;
        }else
            throw new NullPointerException();
    }
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        if (y!= null) {
            this.y = y;
        }else
            throw new NullPointerException();
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double asfasfa) {
        if (asfasfa!= null) {
            this.z = asfasfa;
        }else
            throw new NullPointerException();


    }

    public Double getDistancia(Punto3D p1, Punto3D p2) {
        if (x == null || y==null || z==null) {
            throw new NullPointerException();
        }else{
            x = p1.getX() - p2.getX();
            y = p1.getY() - p2.getY();
            z = p1.getZ() - p2.getZ();
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
        }

    }

    //toString
    public String toString() {
        return "("+getX()+","+getY()+","+getZ()+")";
    }
}