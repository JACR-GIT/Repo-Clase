package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasPrendaDTO {

    private Integer id;
    private String nombre_prenda;
    private String descripcion;
    private String talla;
    private String categoria;
    private String condicion;
    private Boolean disponible;
    private Integer total_intercambios;
}
