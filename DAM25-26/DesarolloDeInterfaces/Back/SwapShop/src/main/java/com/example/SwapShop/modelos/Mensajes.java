package com.example.SwapShop.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "mensajes", schema = "swapshop")
public class Mensajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Conversación a la que pertenece el mensaje
    @ManyToOne
    @JoinColumn(name = "id_conversacion", nullable = false)
    private Conversaciones conversacion;

    // Usuario que envía el mensaje
    @ManyToOne
    @JoinColumn(name = "id_remitente", nullable = false)
    private Usuario remitente;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

}

