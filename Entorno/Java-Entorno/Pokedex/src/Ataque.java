public class Ataque {
    private String nombre;
    private int daño;

    // Constructor
    public Ataque(String nombre, int daño) {
        this.nombre = nombre;
        this.daño = daño;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    // Método toString para representar el ataque como cadena
    public String toString() {
        return nombre + ", " + daño;
    }
}