package com.proyectojdbc.modelo;

import java.time.LocalDate;

public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private int idCentro;

    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento, int idCentro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idCentro = idCentro;
    }

    public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento, int idCentro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idCentro = idCentro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public int getIdCentro() { return idCentro; }
    public void setIdCentro(int idCentro) { this.idCentro = idCentro; }
}
