package com.proyectojdbc.dao;
import com.proyectojdbc.modelo.Alumno;

import java.util.List;

public interface AlumnoDAO {
    Alumno obtenerPorId(int id);
    List<Alumno> obtenerTodos();
    void insertar(Alumno alumno);
    void actualizar(Alumno alumno);
    void eliminar(int id);
}

