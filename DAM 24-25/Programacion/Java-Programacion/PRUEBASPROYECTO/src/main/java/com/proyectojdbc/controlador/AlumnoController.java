package com.proyectojdbc.controlador;

import java.util.List;

import com.proyectojdbc.modelo.Alumno;
import com.proyectojdbc.servicio.AlumnoService;

public class AlumnoController {
    private AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    public Alumno mostrarAlumno(int id) {
        return alumnoService.obtenerAlumno(id);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoService.obtenerTodosLosAlumnos();
    }

    public void agregarAlumno(Alumno alumno) {
        alumnoService.registrarAlumno(alumno);
    }
}

