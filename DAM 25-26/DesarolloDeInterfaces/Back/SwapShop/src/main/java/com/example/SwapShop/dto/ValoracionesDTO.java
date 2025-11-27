package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionesDTO {

    private Integer id;
    private Integer id_valorador;
    private Integer id_valorado;
    private Integer puntuacion;
    private Timestamp creado_en;
}
