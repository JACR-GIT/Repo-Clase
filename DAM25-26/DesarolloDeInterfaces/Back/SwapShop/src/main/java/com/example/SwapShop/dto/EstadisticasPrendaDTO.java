package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.Categoria;
import com.example.SwapShop.modelos.Condicion;
import com.example.SwapShop.modelos.Estilo;
import com.example.SwapShop.modelos.Talla;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasPrendaDTO {

    private Integer id;
    private String nombrePrenda;
    private String descripcion;
    private Talla talla;
    private Categoria categoria;
    private Condicion condicion;
    private Boolean disponible;
    private Long totalIntercambios;
}
