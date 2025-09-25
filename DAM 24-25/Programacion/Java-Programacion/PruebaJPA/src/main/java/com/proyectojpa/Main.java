package com.proyectojpa;

import com.proyectojpa.controladores.AlumnoController;
import com.proyectojpa.controladores.CentroController;
import com.proyectojpa.modelos.Alumno;
import com.proyectojpa.modelos.Centro;
import com.proyectojpa.repositorios.CentroRepository;
import com.proyectojpa.servicios.AlumnoService;
import com.proyectojpa.repositorios.AlumnoRepository;
import com.proyectojpa.config.HibernateConfig;

import com.proyectojpa.servicios.CentroService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AlumnoController alumnoController = new AlumnoController();
        CentroController centroController = new CentroController();

        //Ejemplo 1: insertamos un alumno en el centro con id = 3

        Centro centro1 = centroController.getCentroById(3L);

        if(centro1!=null){
            Alumno alumno = new Alumno("Margarita","López Granados", LocalDate.of(2002,3,12),centro1);
            alumnoController.addAlumno(alumno);

            System.out.println("Nuevo alumno creado: "+alumno.getNombre()+", con Id: "+alumno.getId());
        }else{
            System.out.println("Centro no encontrado");
        }


        //Ejemplo 2: insertamos un alumno en el centro con nombre = IES Isaac Newton

        Centro centro2 = centroController.getCentroByName("IES Isaac Newton");

        if(centro1!=null){
            Alumno alumno2 = new Alumno("Pedro","Sánchez Rodríguez", LocalDate.of(2001,10,7),centro2);
            alumnoController.addAlumno(alumno2);

            System.out.println("Nuevo alumno creado: "+alumno2.getNombre()+", con Id: "+alumno2.getId());
        }else{
            System.out.println("Centro no encontrado");
        }


        // Mostrar todos los alumnos
        alumnoController.getAllAlumnos().forEach(a -> System.out.println(a.getNombre() +" ("+ a.getCentro().getNombre()+")"));

        HibernateConfig.shutdown();
    }
}
