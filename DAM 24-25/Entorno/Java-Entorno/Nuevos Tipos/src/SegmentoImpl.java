import Punto3DImpl.Punto3DImpl;

public class SegmentoImpl {
    private Punto3D extremo1;
    private Punto3D extremo2;

    public SegmentoImpl(Punto3D extremo1, Punto3D extremo2) {
        if (extremo1 == null || extremo2 == null) {
            throw new IllegalArgumentException("Los extremos no pueden ser null.");
        }
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;
    }
    public Punto3D getExtremo1() {
        return extremo1;
    }
    public void setExtremo1(Punto3D extremo1) {
        if (extremo1 == null) {
            throw new IllegalArgumentException("El extremo no puede ser null.");
        }
        this.extremo1 = extremo1;
    }
    public Punto3D getExtremo2() {
        return extremo2;
    }
    public void setExtremo2(Punto3D extremo2) {
        if (extremo2 == null) {
            throw new IllegalArgumentException("El extremo no puede ser null.");
        }
        this.extremo2 = extremo2;
    }

    public double getLongitud() {
        return Math.sqrt(
                Math.pow(extremo2.getX() - extremo1.getX(), 2) +
                        Math.pow(extremo2.getY() - extremo1.getY(), 2) +
                        Math.pow(extremo2.getZ() - extremo1.getZ(), 2)
        );
    }

    //ToString
    public String toString() {
        return "[" + extremo1 + ", " + extremo2 + "]";
    }
}
