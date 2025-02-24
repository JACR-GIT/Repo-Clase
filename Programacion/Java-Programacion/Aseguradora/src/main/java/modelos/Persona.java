package modelos;

import utilidades.UtilidadesPersonas;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    // ==================== PROPIEDADES O VARIABLES ====================

    private int id; // Identificador único de la persona.
    private String nombre; // Nombre de la persona.
    private String apellido1; // Primer apellido de la persona.
    private String apellido2; // Segundo apellido de la persona.
    private String nif; // NIF (Número de Identificación Fiscal) de la persona.
    private LocalDate fechaNacimiento; // Fecha de nacimiento de la persona.
    private Direccion direccion; // Dirección de la persona.
    private Sexo sexo; // Sexo de la persona (MASCULINO, FEMENINO, NO_ESPECIFICADO).
    private String paisOrigen; // País de origen de la persona.
    private String email; // Correo electrónico de la persona.
    private String telefono; // Número de teléfono de la persona.

    // ==================== CONSTRUCTORES ====================

    /**
     * Constructor completo (V2).
     * Crea una persona con todos los atributos.
     *
     * @param id              Identificador único de la persona.
     * @param nombre          Nombre de la persona.
     * @param apellido1       Primer apellido de la persona.
     * @param apellido2       Segundo apellido de la persona.
     * @param nif             NIF de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param direccion       Dirección de la persona.
     * @param sexo            Sexo de la persona.
     * @param paisOrigen      País de origen de la persona.
     * @param email           Correo electrónico de la persona.
     * @param telefono        Número de teléfono de la persona.
     * @throws IllegalArgumentException Si el NIF no es válido.
     */
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

    /**
     * Constructor de la V1 (sin sexo, paisOrigen, email y telefono).
     * Crea una persona con los atributos básicos.
     *
     * @param id              Identificador único de la persona.
     * @param nombre          Nombre de la persona.
     * @param apellido1       Primer apellido de la persona.
     * @param apellido2       Segundo apellido de la persona.
     * @param nif             NIF de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param direccion       Dirección de la persona.
     */
    public Persona(int id, String nombre, String apellido1, String apellido2, String nif,
                   LocalDate fechaNacimiento, Direccion direccion) {
        this(id, nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, null, null, null, null);
    }

    /**
     * Constructor vacío.
     * Inicializa todos los atributos con valores por defecto.
     */
    public Persona() {
        this(0, "ninguno", "ninguno", "ninguno", "ninguno", LocalDate.now(), null, null, null, null, null);
    }

    /**
     * Constructor de copia.
     * Crea una nueva persona a partir de otra existente.
     *
     * @param persona2 Persona de la cual se copiarán los atributos.
     */
    public Persona(Persona persona2) {
        this(persona2.id, persona2.nombre, persona2.apellido1, persona2.apellido2, persona2.nif,
                persona2.fechaNacimiento, persona2.direccion, persona2.sexo, persona2.paisOrigen,
                persona2.email, persona2.telefono);
    }

    // ==================== GETTERS Y SETTERS ====================

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

    // ==================== MÉTODOS ====================

    /**
     * Devuelve una representación en cadena de la persona.
     *
     * @return Cadena que representa a la persona.
     */
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

    /**
     * Compara si dos personas son iguales basándose en su id, nif y fecha de nacimiento.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id &&
                Objects.equals(nif, persona.nif) &&
                Objects.equals(fechaNacimiento, persona.fechaNacimiento);
    }

    /**
     * Devuelve el código hash de la persona basado en su id, nif y fecha de nacimiento.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nif, fechaNacimiento);
    }
}