import java.io.Serializable;

public class Categoria implements Serializable {
    String nombreCategoria; // e.g., Electrónica, Perecederos, Textil.
    String condicionesAlmacenaje; // e.g., "Mantener en seco", "Refrigerar < 5°C".

    public Categoria(String nombreCategoria, String condicionesAlmacenaje) {
        super();
        this.nombreCategoria = nombreCategoria;
        this.condicionesAlmacenaje = condicionesAlmacenaje;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getCondicionesAlmacenaje() {
        return condicionesAlmacenaje;
    }

    public void setCondicionesAlmacenaje(String condicionesAlmacenaje) {
        this.condicionesAlmacenaje = condicionesAlmacenaje;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombreCategoria='" + nombreCategoria + '\'' +
                ", condicionesAlmacenaje='" + condicionesAlmacenaje + '\'' +
                '}';
    }
}
