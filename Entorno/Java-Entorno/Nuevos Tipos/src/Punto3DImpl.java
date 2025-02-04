public class Punto3DImpl {
    //Variables
    private double x;
    private double y;
    private double z;

    //Constructores

    public Punto3DImpl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Getters y Setters

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    //Metodos

    public double distance(Punto3DImpl otropunto) {
        double dx = x - otropunto.getX();
        double dy = y - otropunto.getY();
        double dz = z - otropunto.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    private void validarCoordenadas(Double x, Double y, Double z) {
        if (x == null || y == null || z == null) {
            throw new IllegalArgumentException("Las coordenadas no pueden ser null");
        }
    }

    //ToString

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
