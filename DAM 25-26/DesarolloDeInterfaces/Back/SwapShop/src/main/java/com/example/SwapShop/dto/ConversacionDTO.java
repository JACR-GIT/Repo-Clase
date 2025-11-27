package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversacionDTO {

    private Integer id;
    private Integer id_usuario1;
    private Integer id_usuario2;
    private Integer id_intercambio;
    private Timestamp creado_en;
    private List<Integer> id_mensajes; // ids de los mensajes en la conversación
}
