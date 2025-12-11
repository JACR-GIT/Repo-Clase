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

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "talla", length = 20)
    private Talla talla;

    @Column(name = "estilo", length = 30)
    private Estilo estilo;

    @Column(name = "categoria", length = 50)
    private Categoria categoria;

    @Column(name = "condicion", length = 50)
    private Condicion condicion;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;
}
