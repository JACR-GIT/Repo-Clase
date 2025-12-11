package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasUsuarioDTO {

    private Integer id;
    private UsuarioDTO nombre_usuario;
    private UsuarioDTO nombre;
    private UsuarioDTO apellido1;
    private UsuarioDTO apellido2;
    private Long total_intercambios_aceptados;

}
