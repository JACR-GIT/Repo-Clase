package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrendasDTO {

    private Integer id;
    private UsuarioDTO id_dueno;
    private String nombre_prenda;
    private String descripcion;
    private String talla;
    private String categoria;
    private String condicion;
    private Boolean disponible;

}
