package com.safa;

public class Categoria {

    String nombreCategoria;
    String condicionesAlmacenaje;

    public Categoria(String nombreCategoria, String condicionesAlmacenaje) {
        this.nombreCategoria = nombreCategoria;
        this.condicionesAlmacenaje = condicionesAlmacenaje;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getCondicionesAlmacenaje() {
        return condicionesAlmacenaje;
    }

    public void setCondicionesAlmacenaje(String condicionesAlmacenaje) {
        this.condicionesAlmacenaje = condicionesAlmacenaje;
    }
}
