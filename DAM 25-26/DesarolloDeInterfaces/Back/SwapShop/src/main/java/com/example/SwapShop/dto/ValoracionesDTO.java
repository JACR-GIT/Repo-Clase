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
    private Integer valorador; // Cambiado a Integer
    private Integer valorado;  // Cambiado a Integer
    private Integer puntuacion;
}
