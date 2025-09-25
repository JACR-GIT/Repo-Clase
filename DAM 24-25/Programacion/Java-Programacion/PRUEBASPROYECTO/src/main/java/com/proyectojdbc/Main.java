package com.proyectojdbc;

import com.proyectojdbc.controlador.AlumnoController;
import com.proyectojdbc.dao.AlumnoDAOImpl;
import com.proyectojdbc.modelo.Alumno;
import com.proyectojdbc.servicio.AlumnoService;
import com.proyectojdbc.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionManager.getInstance().getConnection();

            AlumnoDAOImpl alumnoDAO = new AlumnoDAOImpl(conn);
            AlumnoService alumnoService = new AlumnoService(alumnoDAO);
            AlumnoController alumnoController = new AlumnoController(alumnoService);

            Alumno nuevoAlumno = new Alumno("Juan", "Pérez Galindo", LocalDate.of(2003,10,6), 3);
            alumnoController.agregarAlumno(nuevoAlumno);

            alumnoController.listarAlumnos().forEach(a ->
                    System.out.println(a.getNombre() + " " + a.getApellidos())
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}