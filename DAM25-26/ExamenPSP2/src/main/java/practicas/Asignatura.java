package practicas;

import java.io.Serializable;

/**
 * Clase Asignatura
 */
public class Asignatura implements Serializable {
    private int idAsignatura;
    private String nombre;
    
    public Asignatura() {}
    
    public Asignatura(int idAsignatura, String nombre) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
    }
    
    public int getIdAsignatura() {
        return idAsignatura;
    }
    
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
