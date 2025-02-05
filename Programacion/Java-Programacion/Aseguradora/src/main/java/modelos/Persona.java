package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    //Variables

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    //Constructor

    public Persona(int id, String nombre, String apellido1, String apellido2, String nif, LocalDate fechaNacimiento, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Persona(){
        this.id = 0;
        this.nombre = "ninguno";
        this.apellido1 = "ninguno";
        this.apellido2 = "ninguno";
        this.nif = "ninguno";
        this.fechaNacimiento = LocalDate.now();
        this.direccion = null;
    }

    public Persona(Persona persona2){
        this.id = persona2.id;
        this.nombre = persona2.nombre;
        this.apellido1 = persona2.apellido1;
        this.apellido2 = persona2.apellido2;
        this.nif = persona2.nif;
        this.fechaNacimiento = persona2.fechaNacimiento;
        this.direccion = persona2.direccion;
    }

    //Getter y Setters


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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    //toString

    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", nif='" + nif + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion=" + direccion +
                '}';
    }

    //equals

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido1, persona.apellido1) && Objects.equals(apellido2, persona.apellido2) && Objects.equals(nif, persona.nif) && Objects.equals(fechaNacimiento, persona.fechaNacimiento) && Objects.equals(direccion, persona.direccion);
    }

    //hashCode
    public int hashCode() {
        return Objects.hash(id, nombre, apellido1, apellido2, nif, fechaNacimiento, direccion);
    }
}
