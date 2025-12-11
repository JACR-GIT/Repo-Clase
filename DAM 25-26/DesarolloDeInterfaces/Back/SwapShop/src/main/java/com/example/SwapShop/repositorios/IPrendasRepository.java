package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Prendas;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer> {

    @Query(value = "SELECT * FROM Prendas p WHERE p.talla = :talla", nativeQuery = true)
    List<Prendas> buscarPorTalla(@Param("talla") String talla);

    List<Prendas> findByDisponibleTrue();
}
