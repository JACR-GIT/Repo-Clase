package Julian_30.Ejer_25;

public abstract class Herramienta {
    public static Herramienta crearHerramienta(String tipo) {
        if ("martillo".equals(tipo)) return new Martillo();
        return null;
    }

    public abstract void usar();
}