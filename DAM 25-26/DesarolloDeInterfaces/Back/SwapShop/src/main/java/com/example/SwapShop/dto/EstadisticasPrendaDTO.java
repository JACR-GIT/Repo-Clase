package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasPrendaDTO {

    private Integer id;
    private String nombrePrenda;
    private String descripcion;
    private String talla;
    private String categoria;
    private String condicion;
    private Boolean disponible;
    private Long totalIntercambios;
}