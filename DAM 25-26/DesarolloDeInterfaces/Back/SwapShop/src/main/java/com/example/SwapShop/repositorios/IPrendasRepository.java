package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Prendas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer> {
    Prendas findByTalla(String talla);


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
