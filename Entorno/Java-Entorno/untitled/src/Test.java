public class Test {
    public static void main(String[] args) {
        // Crear una fecha de lanzamiento
        Fecha fechaLanzamiento = new Fecha(1, 1, 2019);

        // Crear una canción
        Cancion cancion = new Cancion("Buenos Tiempos", "Dillom", 354, fechaLanzamiento, "Rock");

        // Mostrar información de la canción
        System.out.println("Canción: " + cancion);
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");
        System.out.println("Fecha de lanzamiento: " + cancion.getFechaLanzamiento());
        System.out.println("Género: " + cancion.getGenero());
        System.out.println("Número de reproducciones: " + cancion.getNumeroDeReproducciones());
        System.out.println("Calificación: " + cancion.getCalificacion());
        System.out.println("Reproduciendo: " + cancion.isReproduciendo());

        // Modificar propiedades
        cancion.setNumeroDeReproducciones(1000);
        cancion.setCalificacion(9.5);
        cancion.setReproduciendo(true);

        // Mostrar información actualizada
        System.out.println("\nDespués de modificar:");
        System.out.println("Número de reproducciones: " + cancion.getNumeroDeReproducciones());
        System.out.println("Calificación: " + cancion.getCalificacion());
        System.out.println("Reproduciendo: " + cancion.isReproduciendo());
    }
}