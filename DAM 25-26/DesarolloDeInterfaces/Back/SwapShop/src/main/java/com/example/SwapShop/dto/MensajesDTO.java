package com.example.SwapShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajesDTO {

    private Integer id;

    @NotNull(message = "El ID de la conversación no puede ser nulo")
    private Integer id_conversacion;

    @NotNull(message = "El ID del remitente no puede ser nulo")
    private Integer id_remitente;

    @NotBlank(message = "El contenido del mensaje no puede estar vacío")
    @Size(min = 1, max = 1000, message = "El contenido del mensaje debe tener entre 1 y 1000 caracteres")
    private String contenido;
}
