package com.swapshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajesDTO {

    private Integer id;
    private Integer id_conversacion;
    private Integer id_remitente;
    private String contenido;
    private Timestamp creado_en;
}
