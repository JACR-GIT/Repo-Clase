public class Profesor extends Persona {
    //Encapsular los atributos usando private en la clase ,
    //Eliminar atributo repetido en la clase Profesor numerodeTelefono
   // Refactorizar los metodos printInformacionPersonal y printTodaLaInformacion, reduciendo el primero y eliminando
    //la parte de la impresion del segundo, reutilizando el primero.
    //Crear getters & setters para los atributos de la clase Profesor
    private String nombre; //Rename variable str a nombre y sus usos
    private int edad;
    private List<Prestamo> prestamos;

    public Profesor(String numeroDeTelefono) {
        super(numeroDeTelefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void printInformacionPersonal() {
        System.out.printf("Nombre: %s\nEdad: %d\nTelefono: %s\n", getNombre(), getEdad(), getNumeroDeTelefono());
    }

    public void printTodaLaInformacion() {
        printInformacionPersonal();
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }


}
