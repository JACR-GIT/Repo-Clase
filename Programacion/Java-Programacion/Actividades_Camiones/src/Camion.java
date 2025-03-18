import java.time.LocalDate;
import java.util.Objects;

public class Camion {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private Conductor conductorAsignado;

    public Camion(int id, String marca, String modelo, String matricula, Conductor conductorAsignado) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.conductorAsignado = conductorAsignado;
    }

    public Camion() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Camion camion = (Camion) o;
        return id == camion.id && Objects.equals(marca, camion.marca) && Objects.equals(modelo, camion.modelo) && Objects.equals(matricula, camion.matricula) && Objects.equals(conductorAsignado, camion.conductorAsignado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, matricula, conductorAsignado);
    }

    @Override
    public String toString() {
        return "Camion: " +
                "(" + getMarca()+ ")" +
                " - " + getMatricula() + '\n' +
                "\t, modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", conductorAsignado=" + conductorAsignado +
                '}';
    }
}
