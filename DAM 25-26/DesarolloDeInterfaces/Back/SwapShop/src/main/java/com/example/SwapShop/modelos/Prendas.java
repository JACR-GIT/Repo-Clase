package com.example.SwapShop.modelos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "prendas")
public class Prendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_dueno", nullable = false)
    private Usuario id_dueno;

    @Column(name = "nombre_prenda", nullable = false, length = 150)
    private String nombrePrenda;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 20)
    private String talla;

    @Column(length = 50)
    private String categoria;

    @Column(length = 50)
    private String condicion;

    @Column(nullable = false)
    private Boolean disponible = true;

    @Column(name = "creado_en", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.sql.Timestamp creadoEn;
}
