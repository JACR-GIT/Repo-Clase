package Julian_30.Ejer_5;

public abstract class Producto {
    final int id;
    public Producto(int id) {
        this.id = id;
    }
    public abstract double calcularPrecio();
}
