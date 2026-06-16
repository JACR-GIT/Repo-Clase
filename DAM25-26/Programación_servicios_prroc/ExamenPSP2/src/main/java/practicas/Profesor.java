package practicas;

import java.io.Serializable;

/**
 * Clase Profesor - Un profesor puede impartir hasta 3 asignaturas
 */
public class Profesor implements Serializable {
    private int idProfesor;
    private String nombre;
    private Especialidad especialidad;
    private Asignatura[] asignaturas; // Array de 3 asignaturas
    
    public Profesor() {
        asignaturas = new Asignatura[3];
    }
    
    public Profesor(int idProfesor, String nombre, Especialidad especialidad) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.asignaturas = new Asignatura[3];
    }
    
    public int getIdProfesor() {
        return idProfesor;
    }
    
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }
    
    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }
}
