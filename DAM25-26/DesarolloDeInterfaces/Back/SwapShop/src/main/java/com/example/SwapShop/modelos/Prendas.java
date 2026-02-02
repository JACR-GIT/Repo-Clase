package com.example.SwapShop.modelos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "prendas", schema = "swapshop")
public class Prendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_dueno", nullable = false)
    private Usuario dueno;

    @Column(name = "nombre_prenda", nullable = false, length = 150)
    private String nombrePrenda;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "talla", length = 20)
    private Talla talla;

    @Enumerated(EnumType.STRING)
    @Column(name = "estilo", length = 30)
    private Estilo estilo;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", length = 50)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "condicion", length = 50)
    private Condicion condicion;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;

    @Column(name = "foto")
    private String foto;
}
