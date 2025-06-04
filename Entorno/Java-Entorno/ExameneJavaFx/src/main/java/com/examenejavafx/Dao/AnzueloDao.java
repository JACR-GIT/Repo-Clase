package com.examenejavafx.Dao;

import com.examenejavafx.Modelo.Anzuelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnzueloDao {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "C##ANZUELOEXAMEN";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    public void insertarAnzuelo(Anzuelo anzuelo) {
        String sql = "INSERT INTO ANZUELOS (modelo, ojos, color, peso, tamaño, navegabilidad, referencia, disponibilidad, fecha_recepcion, pvp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, anzuelo.getModelo());
            stmt.setString(2, anzuelo.getOjos());
            stmt.setString(3, anzuelo.getColor());
            stmt.setInt(4, anzuelo.getPeso());
            stmt.setInt(5, anzuelo.getTamaño());
            stmt.setString(6, anzuelo.getNavegabilidad());
            stmt.setString(7, anzuelo.getReferencia());
            stmt.setString(8, anzuelo.getDisponibilidad());
            stmt.setDate(9, new java.sql.Date(anzuelo.getFechaRecepcion().getTime()));
            stmt.setInt(10, anzuelo.getPVP());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Anzuelo> obtenerTodosAnzuelos() {
        List<Anzuelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM ANZUELOS";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Anzuelo anzuelo = new Anzuelo(
                        rs.getString("modelo"),
                        rs.getString("ojos"),
                        rs.getString("color"),
                        rs.getInt("peso"),
                        rs.getInt("tamaño"),
                        rs.getString("navegabilidad"),
                        rs.getString("referencia"),
                        rs.getString("disponibilidad"),
                        rs.getDate("fecha_recepcion"),
                        rs.getInt("pvp")
                );
                lista.add(anzuelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

