package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.*;
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
public class PrendasDTO {

    private Integer id;

    @NotNull(message = "El ID del dueño no puede ser nulo")
    private Integer id_dueno;

    @NotBlank(message = "El nombre de la prenda no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre de la prenda debe tener entre 2 y 100 caracteres")
    private String nombrePrenda;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String descripcion;

    @NotNull(message = "La talla no puede ser nula")
    private Talla talla;

    @NotNull(message = "La categoría no puede ser nula")
    private Categoria categoria;

    @NotNull(message = "El estilo no puede ser nulo")
    private Estilo estilo;

    @NotNull(message = "La condición no puede ser nula")
    private Condicion condicion;

    @NotNull(message = "El estado de disponibilidad no puede ser nulo")
    private Boolean disponible;

    @NotNull(message = "La foto no puede ser nula")
    private String foto;

}
