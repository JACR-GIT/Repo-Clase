package modelos;

import utilidades.UtilidadesPersonas;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    // Variables
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    private Sexo sexo;
    private String paisOrigen;
    private String email;
    private String telefono;

    // Constructor completo (V2)
    public Persona(int id, String nombre, String apellido1, String apellido2, String nif,
                   LocalDate fechaNacimiento, Direccion direccion, Sexo sexo, String paisOrigen,
                   String email, String telefono) {

        if (!UtilidadesPersonas.esNIFValido(nif)) {
            throw new IllegalArgumentException("El NIF no es válido");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.sexo = sexo;
        this.paisOrigen = paisOrigen;
        this.email = email;
        this.telefono = telefono;
    }

    // Constructor V1 (sin sexo, paisOrigen, email y telefono)
    public Persona(int id, String nombre, String apellido1, String apellido2, String nif,
                   LocalDate fechaNacimiento, Direccion direccion) {
        this(id, nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, null, null, null, null);
    }

    // Constructor vacío
    public Persona() {
        this(0, "ninguno", "ninguno", "ninguno", "ninguno", LocalDate.now(), null, null, null, null, null);
    }

    // Constructor de copia
    public Persona(Persona otraPersona) {
        this(otraPersona.id, otraPersona.nombre, otraPersona.apellido1, otraPersona.apellido2, otraPersona.nif,
                otraPersona.fechaNacimiento, otraPersona.direccion, otraPersona.sexo, otraPersona.paisOrigen,
                otraPersona.email, otraPersona.telefono);
    }

    // Getters y Setters
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
        if (!UtilidadesPersonas.esNIFValido(nif)) {
            throw new IllegalArgumentException("El NIF no es válido");
        }
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // toString
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", nif='" + nif + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion=" + direccion +
                ", sexo=" + sexo +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id &&
                Objects.equals(nif, persona.nif) &&
                Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, nif, fechaNacimiento);
    }
}