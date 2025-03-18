import java.time.LocalDate;
import java.util.Objects;

public class Conductor {
    private int id;
    private String nombre;
    private String apellido;
    private String licencia;
    private LocalDate fechaContratacion;

    public Conductor(int id, String nombre, String apellido, String licencia, LocalDate fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.fechaContratacion = fechaContratacion;
    }

    public Conductor() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conductor conductor = (Conductor) o;
        return id == conductor.id && Objects.equals(nombre, conductor.nombre) && Objects.equals(apellido, conductor.apellido) && Objects.equals(licencia, conductor.licencia) && Objects.equals(fechaContratacion, conductor.fechaContratacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, licencia, fechaContratacion);
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", licencia='" + licencia + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                '}';
    }
}
