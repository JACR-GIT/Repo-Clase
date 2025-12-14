package com.example.SwapShop.dto;

import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.modelos.TipoIntercambio;
import com.example.SwapShop.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntercambiosPrestamosDTO {

    private Integer id;

    @NotNull(message = "El ID de la prenda no puede ser nulo")
    private Integer id_prenda;

    // id_prenda2 puede ser nulo si es un préstamo, pero si es intercambio, debería ser NotNull
    // Por ahora lo dejaremos sin NotNull, pero se podría añadir lógica condicional si fuera necesario
    private Integer id_prenda2;

    @NotNull(message = "El ID del solicitante no puede ser nulo")
    private Integer id_solicitante;

    @NotNull(message = "El ID del dueño no puede ser nulo")
    private Integer id_dueno;

    @NotNull(message = "El tipo de intercambio no puede ser nulo")
    private TipoIntercambio tipo;

    // El estado inicial puede ser nulo o tener un valor por defecto, dependiendo de la lógica de negocio
    private EstadoIntercambio estado;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    @FutureOrPresent(message = "La fecha de inicio debe ser en el presente o futuro")
    private Date fecha_inicio;

    @FutureOrPresent(message = "La fecha de fin debe ser en el presente o futuro")
    private Date fecha_fin;
}
