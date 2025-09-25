package Actividad1Refac;

import java.util.List;

public class Profesor extends Persona {
    String nombre;
    int edad;
    List<Prestamo> prestamos;

    public Profesor (String numeroDeTelefono) {
        super (numeroDeTelefono) ;
    }

    public void printInfornacionPersonal() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Telefono: " + numeroDeTelefono);
    }

    public void printTodaLaInformacion() {
        this.printInfornacionPersonal();
        for (Prestamo p: prestamos){
            System.out.println(p);
        }
    }
}