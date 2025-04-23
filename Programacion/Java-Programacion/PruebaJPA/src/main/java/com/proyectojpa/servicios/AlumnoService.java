package com.proyectojpa.servicios;

import com.proyectojpa.modelos.Alumno;
import com.proyectojpa.repositorios.AlumnoRepository;
import jakarta.transaction.Transactional;
import java.util.List;

public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService() {
        this.alumnoRepository = new AlumnoRepository();
    }

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Transactional
    public void addAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.getAll();
    }
}
