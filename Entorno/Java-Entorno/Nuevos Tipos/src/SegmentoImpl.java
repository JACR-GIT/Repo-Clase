package geometria;

public class SegmentoImpl implements Segmento {
    private Punto3D extremo1;
    private Punto3D extremo2;

    // Constructor
    public SegmentoImpl(Punto3D extremo1, Punto3D extremo2) {
        if (extremo1 == null || extremo2 == null) {
            throw new IllegalArgumentException("Los extremos no pueden ser null.");
        }
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;
    }

    // Implementación de los métodos de la interfaz Segmento
    @Override
    public Punto3D getExtremo1() {
        return extremo1;
    }

    @Override
    public void setExtremo1(Punto3D extremo1) {
        if (extremo1 == null) {
            throw new IllegalArgumentException("El extremo1 no puede ser null.");
        }
        this.extremo1 = extremo1;
    }

    @Override
    public Punto3D getExtremo2() {
        return extremo2;
    }

    @Override
    public void setExtremo2(Punto3D extremo2) {
        if (extremo2 == null) {
            throw new IllegalArgumentException("El extremo2 no puede ser null.");
        }
        this.extremo2 = extremo2;
    }

    @Override
    public double longitud() {
        return extremo1.distanciaA(extremo2);
    }

    @Override
    public String toString() {
        return "[" + extremo1 + ", " + extremo2 + "]";
    }
}