package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionesDTO {

    private Integer id;
    private UsuarioDTO valorador;
    private UsuarioDTO valorado;
    private Integer puntuacion;
}
