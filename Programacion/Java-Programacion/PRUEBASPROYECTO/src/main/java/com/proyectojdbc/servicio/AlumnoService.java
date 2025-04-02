package com.proyectojdbc.servicio;

import com.proyectojdbc.dao.AlumnoDAO;
import com.proyectojdbc.modelo.Alumno;

import java.util.List;

public class AlumnoService {
    private AlumnoDAO alumnoDAO;

    public AlumnoService(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public Alumno obtenerAlumno(int id) {
        return alumnoDAO.obtenerPorId(id);
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoDAO.obtenerTodos();
    }

    public void registrarAlumno(Alumno alumno) {
        alumnoDAO.insertar(alumno);
    }
}

