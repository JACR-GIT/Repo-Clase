import java.io.Serializable;

public class Producto implements Serializable {
    int idProducto; // Código de barras o SKU.
    String nombre;
    Categoria cat;
    Proveedor prov;

    public Producto(int idProducto, String nombre, Categoria cat, Proveedor prov) {
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cat = cat;
        this.prov = prov;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto + ", Nombre: " + nombre + '\n'+
                "Categoria: " + getCat().getNombreCategoria() + ", Condiciones Almacenaje: " + getCat().getCondicionesAlmacenaje() + '\n'+
                "Proveedor: " + getProv().getNombreEmpresa() + ", Dias de Entrga: " + getProv().getDiasEntrega() + " dias";
    }
}
