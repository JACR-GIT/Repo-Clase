package com.proyectojpa.controladores;

import com.proyectojpa.modelos.Alumno;
import com.proyectojpa.servicios.AlumnoService;
import java.util.List;

public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController() {
        this.alumnoService = new AlumnoService();
    }

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    public void addAlumno(Alumno alumno) {
        alumnoService.addAlumno(alumno);
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }
}

