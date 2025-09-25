package com.proyectojpa.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ALUMNOS")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDOS", nullable = false)
    private String apellidos;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "ID_CENTRO")
    private Centro centro;

    public Alumno() {}

    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento, Centro centro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.centro = centro;
    }

    public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento, Centro centro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.centro = centro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Centro getCentro() { return centro; }
    public void setCentro(Centro centro) { this.centro = centro; }
}
