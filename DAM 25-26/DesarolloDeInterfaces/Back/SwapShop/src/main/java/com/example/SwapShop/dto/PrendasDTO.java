package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrendasDTO {

    private Integer id;
    private Integer id_dueno;
    private String nombre_prenda;
    private String descripcion;
    private String talla;
    private String categoria;
    private String condicion;
    private Boolean disponible;
    private Timestamp creado_en;

}
