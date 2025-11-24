package com.swapshop.modelos;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "valoraciones")
public class Valoraciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_valorador", nullable = false)
    private Usuario valorador;

    @ManyToOne
    @JoinColumn(name = "id_valorado", nullable = false)
    private Usuario valorado;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp creadoEn;
}

