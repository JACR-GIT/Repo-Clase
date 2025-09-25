package com.ActividadesExtras;

import java.util.List;

public class Producto {
    String id;
    String nombre;
    String categoria;
    List<String> tags;
    Double precio;

    public Producto(String id, String nombre, String categoria, List<String> tags, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tags = tags;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
