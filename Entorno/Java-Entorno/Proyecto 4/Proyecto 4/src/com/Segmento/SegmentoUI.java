package com.Segmento;

import com.Punto3D.Punto3D;

public interface SegmentoUI {

    public Punto3D getExtremoA();
    public void setExtremoA(Punto3D extremoA);
    public Punto3D getExtremoB();
    public void setExtremoB(Punto3D extremoB);
    public Double getLongitudSegmento(Punto3D extremoA, Punto3D extremoB);

}
