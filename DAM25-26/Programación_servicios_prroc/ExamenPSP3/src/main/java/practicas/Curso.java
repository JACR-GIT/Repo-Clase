package practicas;

import java.io.Serializable;

/**
 * Clase Curso - Debe implementar Serializable para poder enviarse por red
 */
public class Curso implements Serializable {
    private int idCurso;
    private String descripcion;
    
    // Constructor vacío
    public Curso() {}
    
    // Constructor con parámetros
    public Curso(int idCurso, String descripcion) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    public int getIdCurso() {
        return idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
