package com.proyectojpa.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CENTROS")
public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NOMBRE", nullable=false)
    private String nombre;

    @Column(name="LOCALIDAD", nullable=false)
    private String localidad;

    @Column(name="TFNO_CONTACTO")
    private String telefono;

    @OneToMany(mappedBy = "centro")
    private List<Alumno> alumnos;

    public Centro() {}

    public Centro(String nombre, String localidad, String telefono) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public Centro(int id, String nombre, String localidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
