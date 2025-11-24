package com.swapshop.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "conversaciones")
public class Conversaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Usuario que inicia o participa (1)
    @ManyToOne
    @JoinColumn(name = "id_usuario1", nullable = false)
    private Usuario usuario1;

    // Usuario que inicia o participa (2)
    @ManyToOne
    @JoinColumn(name = "id_usuario2", nullable = false)
    private Usuario usuario2;

    // Intercambio asociado
    @ManyToOne
    @JoinColumn(name = "id_intercambio", nullable = false)
    private IntercambiosPrestamos intercambio;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creadoEn;

    // Relación bidireccional (opcional)
    @OneToMany(mappedBy = "conversacion", cascade = CascadeType.ALL)
    private List<Mensajes> mensajes;
}

