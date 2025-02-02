public class PersonaImpl implements Persona{
    private String nombre;
    private String apellidos;
    private String dni;
    private Integer edad;

    public PersonaImpl(String n, String a, String d, Integer e){
        nombre=n;
        apellidos=a;
        dni=d;
        edad=e;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String n) {
        nombre=n;
    }
    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return dni;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer e) {
        edad=e;
    }

    public String toString(){
        return getNombre()+" "+getApellidos()+", "+getDNI()+", "+getEdad()+" años.";
    }
}
