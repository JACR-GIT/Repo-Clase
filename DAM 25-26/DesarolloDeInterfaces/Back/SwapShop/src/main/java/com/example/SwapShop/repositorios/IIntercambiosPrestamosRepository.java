package com.example.SwapShop.repositorios;

import com.example.SwapShop.dto.EstadisticasPrendaDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import com.example.SwapShop.modelos.Prendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IIntercambiosPrestamosRepository extends JpaRepository<IntercambiosPrestamos, Integer> {

    @Query(value = "SELECT \n" +
            "p.id AS id_prenda,\n" +
            "p.nombre_prenda,\n" +
            "p.descripcion,\n" +
            "p.talla,\n" +
            "p.categoria,\n" +
            "p.condicion,\n" +
            "COUNT(i.id) AS total_intercambios\n" +
            "FROM prendas p\n" +
            "INNER JOIN intercambios i ON i.id_prenda = p.id\n" +
            "GROUP BY p.id\n" +
            "ORDER BY total_intercambios DESC\n" +
            "LIMIT 5;\n", nativeQuery = true)
    List<Prendas> buscarTop5Intercambio();
}
