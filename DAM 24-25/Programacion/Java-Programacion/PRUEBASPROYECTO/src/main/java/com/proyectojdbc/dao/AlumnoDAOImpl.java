package com.proyectojdbc.dao;

import com.proyectojdbc.modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {
    private Connection conn;

    public AlumnoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Alumno obtenerPorId(int id) {
        String sql = "SELECT id, nombre, apellidos, fecha_nacimiento, id_centro FROM alumnos WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("id_centro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Alumno> obtenerTodos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidos, fecha_nacimiento, id_centro  FROM alumnos";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("id_centro")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void insertar(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombre, apellidos, fecha_nacimiento, id_centro) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidos());
            stmt.setDate(3, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            stmt.setInt(4, alumno.getIdCentro());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    String rowId = generatedKeys.getString(1);
                    String sqlAux = "SELECT ID FROM alumnos WHERE ROWID = ?";
                    PreparedStatement stmtAux = conn.prepareStatement(sqlAux);
                    stmtAux.setString(1, rowId);
                    ResultSet rs2 = stmtAux.executeQuery();
                    if (rs2.next()) {
                        alumno.setId(rs2.getInt("ID"));
                    }

                    System.out.println("Alumno insertado con ID: " + alumno.getId());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Alumno alumno) {

    }

    @Override
    public void eliminar(int id) {

    }
}

