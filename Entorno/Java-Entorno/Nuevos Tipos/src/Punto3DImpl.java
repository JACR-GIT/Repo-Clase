package geometria;

public class Punto3DImpl implements Punto3D {
    private double x;
    private double y;
    private double z;

    // Constructor
    public Punto3DImpl(double x, double y, double z) {
        if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)) {
            throw new IllegalArgumentException("Las coordenadas no pueden ser null.");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Implementación de los métodos de la interfaz Punto3D
    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        if (Double.isNaN(x)) {
            throw new IllegalArgumentException("La coordenada x no puede ser null.");
        }
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        if (Double.isNaN(y)) {
            throw new IllegalArgumentException("La coordenada y no puede ser null.");
        }
        this.y = y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setZ(double z) {
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("La coordenada z no puede ser null.");
        }
        this.z = z;
    }

    @Override
    public double distanciaA(Punto3D otro) {
        if (otro == null) {
            throw new IllegalArgumentException("El punto no puede ser null.");
        }
        return Math.sqrt(Math.pow(this.x - otro.getX(), 2) + Math.pow(this.y - otro.getY(), 2) + Math.pow(this.z - otro.getZ(), 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}