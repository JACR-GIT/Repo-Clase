import java.io.Serializable;

public class Proveedor implements Serializable {
    String nombreEmpresa;
    int diasEntrega; // Plazo de reposición.

    public Proveedor(String nombreEmpresa, int diasEntrega) {
        super();
        this.nombreEmpresa = nombreEmpresa;
        this.diasEntrega = diasEntrega;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombreEmpresa='" + nombreEmpresa + '\'' +
                ", diasEntrega=" + diasEntrega +
                '}';
    }
}
