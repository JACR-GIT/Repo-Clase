package com.swapshop.dto;

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
    private Integer id_solicitante;
    private Integer id_dueno;

    private String tipo;    // TipoIntercambio as String
    private String estado;  // EstadoIntercambio as String

    private Date fecha_inicio;
    private Date fecha_fin;
    private Timestamp creado_en;

}
