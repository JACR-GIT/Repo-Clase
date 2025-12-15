package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversacionDTO {

    private Integer id;

    @NotNull(message = "El ID del usuario 1 no puede ser nulo")
    private Integer id_usuario1;

    @NotNull(message = "El ID del usuario 2 no puede ser nulo")
    private Integer id_usuario2;

    @NotNull(message = "El ID del intercambio no puede ser nulo")
    private Integer id_intercambio;

    private List<Integer> id_mensajes;
}
