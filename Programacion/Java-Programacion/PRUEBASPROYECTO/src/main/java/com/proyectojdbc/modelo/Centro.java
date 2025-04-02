package com.proyectojdbc.modelo;

public class Centro {
    private int id;
    private String nombre;
    private String localidad;
    private String telefono;

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
}
