package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.*;
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
    private Talla talla;
    private Categoria categoria;
    private Estilo estilo;
    private Condicion condicion;
    private Boolean disponible;

}
