package com.example.SwapShop.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "intercambios")
public class IntercambiosPrestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ---- RELACIONES ----

    @ManyToOne
    @JoinColumn(name = "id_prenda", nullable = false)
    private Prendas prenda;

    @ManyToOne
    @JoinColumn(name = "id_prenda2", nullable = false)
    private Prendas prenda2;

    @ManyToOne
    @JoinColumn(name = "id_solicitante", nullable = false)
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(name = "id_dueno", nullable = false)
    private Usuario dueno;

    // ---- ENUMS ----

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoIntercambio tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoIntercambio estado = EstadoIntercambio.pendiente;

    // ---- FECHAS ----

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;
}
