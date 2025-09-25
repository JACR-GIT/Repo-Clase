package Julian_30.Ejer_5;

public class Main {
    public static void main(String[] args) {
        Producto[] productos = new Producto[2];
        productos[0] = new Libro(1);
        productos[1] = new Electronico(2);
        for (Producto producto : productos) {
            System.out.println(producto.calcularPrecio());
        }
    }
}
