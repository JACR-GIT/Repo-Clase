public interface Punto3D {
    public double getX();
    public void setX(double x);
    public double getY();
    public void setY(double y);
    public double getZ();
    public void setZ(double z);

    double distance(Punto3D punto);

    String toString();
}
