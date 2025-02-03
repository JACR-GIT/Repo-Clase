package geometria;

public interface Punto3D {
    double getX();
    void setX(double x);
    double getY();
    void setY(double y);
    double getZ();
    void setZ(double z);
    double distanciaA(Punto3D otro);
    String toString();
}