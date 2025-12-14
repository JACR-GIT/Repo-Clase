package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.modelos.TipoIntercambio;
import com.example.SwapShop.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class IntercambiosPrestamosDTO {

    private Integer id;
    private Integer id_prenda;
    private Integer id_prenda2;
    private Integer id_solicitante;
    private Integer id_dueno;

    private TipoIntercambio tipo;
    private EstadoIntercambio estado;

    private Date fecha_inicio;
    private Date fecha_fin;
}
