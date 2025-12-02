package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasUsuarioDTO {

    private Integer id;
    private String nombre_usuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer total_intercambios_aceptados;
}
