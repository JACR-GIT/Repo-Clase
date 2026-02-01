package com.example.SwapShop.repositorios;

import com.example.SwapShop.dto.EstadisticasPrendaDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IIntercambiosPrestamosRepository extends JpaRepository<IntercambiosPrestamos, Integer> {

    @Query("""
        SELECT new com.example.SwapShop.dto.EstadisticasPrendaDTO(
            p.id,
            p.nombrePrenda,
            p.descripcion,
            p.talla,
            p.categoria,
            p.condicion,
            p.disponible,
            COUNT(i.id)
        )
        FROM Prendas p
        LEFT JOIN IntercambiosPrestamos i
            ON i.prenda.id = p.id AND i.estado = 'aceptado'
        GROUP BY
            p.id, p.nombrePrenda, p.descripcion, p.talla,
            p.categoria, p.condicion, p.disponible
        ORDER BY COUNT(i.id) DESC
        """)
    List<EstadisticasPrendaDTO> buscarTop5Intercambio(Pageable pageable);
}
