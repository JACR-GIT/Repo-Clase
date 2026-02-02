package practicas;

import java.io.Serializable;

/**
 * Clase Alumno - Debe implementar Serializable para poder enviarse por red
 */
public class Alumno implements Serializable {
    private int idAlumno;
    private String nombre;
    private Curso curso;
    
    // Constructor vacío
    public Alumno() {}
    
    // Constructor con parámetros
    public Alumno(int idAlumno, String nombre, Curso curso) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.curso = curso;
    }
    
    // Getters y Setters
    public int getIdAlumno() {
        return idAlumno;
    }
    
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
