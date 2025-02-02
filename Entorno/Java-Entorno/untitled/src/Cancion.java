public class Cancion {
    private String nombre;
    private String interprete;
    private int duracion; // en segundos
    private Fecha fechaLanzamiento;
    private String genero;
    private int numeroDeReproducciones;
    private double calificacion; // entre 0 y 10
    private boolean reproduciendo;

    // Constructor
    public Cancion(String nombre, String interprete, int duracion, Fecha fechaLanzamiento, String genero) {
        this.nombre = nombre;
        this.interprete = interprete;
        this.duracion = duracion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.numeroDeReproducciones = 0;
        this.calificacion = 0.0;
        this.reproduciendo = false;
    }

    // Getters (consultables)
    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public int getDuracion() {
        return duracion;
    }

    public Fecha getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumeroDeReproducciones() {
        return numeroDeReproducciones;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean isReproduciendo() {
        return reproduciendo;
    }

    // Setters (modificables)
    public void setNumeroDeReproducciones(int numeroDeReproducciones) {
        this.numeroDeReproducciones = numeroDeReproducciones;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 10.");
        }
    }

    public void setReproduciendo(boolean reproduciendo) {
        this.reproduciendo = reproduciendo;
    }

    // Representación como cadena
    @Override
    public String toString() {
        return "[" + nombre + ", " + interprete + "]";
    }
}